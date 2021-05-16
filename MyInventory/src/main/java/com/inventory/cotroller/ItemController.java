package com.inventory.cotroller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inventory.model.Item;
import com.inventory.repo.ItemRepository;

@Controller
@Transactional
public class ItemController {

	@Autowired
	private ItemRepository repo;
	
	@GetMapping("/add_items")
	public String addItemForm(Model model) {
		model.addAttribute("item", new Item());
		return "addItem";
	}


	@GetMapping("/list_items")
	public String viewUserList(Model model) {

		List<Item> listItems = repo.findAll();
		model.addAttribute("listItems", listItems);

		return "items";
	}
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView editEmployee(@PathVariable(name="id") int id) {
		ModelAndView mv = new ModelAndView("editItem");
		Item item=repo.findById(id).get();
		mv.addObject("item", item);
		return mv;

	}
	
	@RequestMapping(value="/editSave", method=RequestMethod.POST)
	public String saveEdit(@ModelAttribute("item") Item item) {
		repo.save(item);
		return "redirect:/list_items";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/list_items";
	}
}
