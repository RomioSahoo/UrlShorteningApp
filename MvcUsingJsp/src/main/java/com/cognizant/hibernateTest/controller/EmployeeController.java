package com.cognizant.hibernateTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.hibernateTest.entity.Employee;
import com.cognizant.hibernateTest.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService es;

	@RequestMapping("/")
	public String viewHomePage(Model m) {
		List<Employee> list = es.listAll();
		System.out.println("Inside viewHomePage");
		m.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newEmployee(Model m) {
		System.out.println("Inside newEmployee");
		m.addAttribute("command", new Employee());
		return "newEmployee";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute("emp") Employee emp) {
		
		System.out.println("Inside addEmployee");
		es.save(emp);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editEmployee(@PathVariable int id, Model m) {
		System.out.println("Inside editEmployee");
		Employee emp=es.get(id);
		m.addAttribute("command", emp);
		return "editEmployee";
		
	}
	
	@RequestMapping(value="/editSave", method=RequestMethod.POST)
	public String saveEdit(@ModelAttribute("emp") Employee emp)
	{
		System.out.println("Inside saveEdit");
		es.save(emp);
		return "redirect:/";
	}
	@RequestMapping(value="/delete/{id}")
	public String deleteEmployee(@PathVariable int id,Model m)
	{
		System.out.println("Inside deleteEmployee");
		es.delete(id);
		return "redirect:/";
	}
	
	
}
