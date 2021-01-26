package com.projectprop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectprop.bo.VendorBo;
import com.projectprop.model.VendorRegistration;

@Controller
public class VendorRegistrationController {
	private static final Logger logger = Logger.getLogger(VendorLoginController.class);
	@Autowired
	private VendorBo vendorBo;
	// will inject vendorBo from XML file
	@RequestMapping(value = "/vendorregister", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("contactNumber") String contactNumber,
			@RequestParam("email") String email, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		// ModelAndView object is created
		VendorRegistration register = new VendorRegistration();
		logger.info("VendorRegistration object created");
		register.setFirstName(firstName);
		register.setLastName(lastName);
		register.setContactNumber(contactNumber);
		register.setEmail(email);
		register.setPassword(password);

		int counter = vendorBo.registerVendor(register);

		if (counter > 0) {
			logger.info("Vendor registration details:" + register);
			mv.addObject("msg", "User registration successful.");
		} else {
			logger.error("Vendor already exist");
			mv.addObject("msg", "Vendor already exist");
		}

		mv.setViewName("vendorRegistration");

		return mv;

	}

}