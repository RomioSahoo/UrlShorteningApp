package com.projectprop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectprop.bo.AdminBo;
import com.projectprop.model.AdminRegistration;

@Controller
public class AdminRegistrationController {
	private static final Logger logger = Logger.getLogger(AdminRegistrationController.class);
	@Autowired
	private AdminBo adminBo;
	// will inject adminBo from XML file
	@RequestMapping(value = "/adminregister", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("contactNumber") String contactNumber,
			@RequestParam("email") String email, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		// ModelAndView object is created
		AdminRegistration register = new AdminRegistration();
		logger.info("AdminRegistration object is created");
		register.setFirstName(firstName);
		register.setLastName(lastName);
		register.setContactNumber(contactNumber);
		register.setEmail(email);
		register.setPassword(password);

		int counter = adminBo.registerAdmin(register);

		if (counter > 0) {
			logger.info("Admin registration details: " + register);
			mv.addObject("msg", "User registration successful.");
		} else {
			logger.error("Admin already exist");
			mv.addObject("msg", "Admin already exist");
		}

		mv.setViewName("adminRegistration");

		return mv;

	}

}