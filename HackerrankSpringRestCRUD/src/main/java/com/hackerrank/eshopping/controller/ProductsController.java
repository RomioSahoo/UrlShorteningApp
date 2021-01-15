package com.hackerrank.eshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.eshopping.model.Product;
import com.hackerrank.eshopping.repository.ProductRepository;

@RestController
public class ProductsController {

	@Autowired
	ProductRepository repo;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		List<Product> list=repo.findAll();
		return list;
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable int id ) {
		return repo.findById(id);
	}
	
	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody Product product)
	{
		if(product!=null)
		{
		Product productSaved=repo.save(product);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		repo.deleteById(id);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		Product pd=repo.findById(id).orElseThrow();
		pd.setName(product.getName());
		pd.setCategory(product.getCategory());
		pd.setRetailPrice(product.getRetailPrice());
		pd.setDiscountedPrice(product.getDiscountedPrice());
		pd.setAvailability(product.isAvailability());
		Product updatedProduct=repo.save(pd);
		return ResponseEntity.ok(updatedProduct);
		
	}

	
	
}
