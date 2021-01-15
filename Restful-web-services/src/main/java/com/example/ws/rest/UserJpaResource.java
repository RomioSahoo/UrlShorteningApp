package com.example.ws.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
 
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
public class UserJpaResource {

	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PostRepository postRepo;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repo.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		Optional<User> user=repo.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id:"+id);
		
		//providing link for all users retrieval
		//"all-users", SERVER_PATH + "/users"
				//retrieveAllUsers
				EntityModel<User> resource = EntityModel.of(user.get());
				
				WebMvcLinkBuilder linkTo = 
						linkTo(methodOn(this.getClass()).retrieveAllUsers());
				
				resource.add(linkTo.withRel("all-users"));
				
				//HATEOAS
				
				return resource;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User userSaved = repo.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId())
				.toUri();
		// ResponseEntity used to show status and headers
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/jpa/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User user)
	{
		User us=repo.findById(id).orElseThrow();
		us.setName(user.getName());
		us.setBirthDate(user.getBirthDate());
		us.setPost(user.getPost());
		
		User updatedUser=repo.save(us);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePosts(@PathVariable int id) {
		 Optional<User> userOptional=repo.findById(id);
		 if(!userOptional.isPresent())
			 throw new UserNotFoundException("id:"+id);
		 return userOptional.get().getPost();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost( @PathVariable int id ,@Valid @RequestBody Post post) {
		 Optional<User> userOptional=repo.findById(id);
		 if(!userOptional.isPresent())
			 throw new UserNotFoundException("id:"+id);
		 
		 User user=userOptional.get();
		 post.setUser(user);
		 
		 postRepo.save(post);
		 

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		// ResponseEntity used to show status and headers
		return ResponseEntity.created(location).build();
	}
	

	
}
