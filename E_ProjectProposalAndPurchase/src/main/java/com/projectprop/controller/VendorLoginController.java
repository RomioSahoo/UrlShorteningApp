package com.projectprop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectprop.bo.VendorBo;
import com.projectprop.model.VendorCredentials;

@Controller
public class VendorLoginController {
	private static final Logger logger = Logger.getLogger(VendorLoginController.class);
	@Autowired
	private VendorBo vendorBo;
	// will inject vendorBo from XML file
	@RequestMapping(value = "/vendorlogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("email") String email, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		// ModelAndView object is created
		VendorCredentials vendor = new VendorCredentials();
		logger.info("VendorCredentials object created");
		vendor.setEmail(email);
		vendor.setPassword(password);

		String name = vendorBo.loginVendor(vendor);

		if (name != null) {
			logger.info("Vendor Credentials details:" + vendor);
			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
			mv.setViewName("welcomevendor");

		} else {

			logger.error("Invalid user id or password.");
			mv.addObject("msg", "Invalid email id or password.");
			mv.setViewName("vendorLogin");
		}

		return mv;

	}

}
