package com.projectprop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectprop.bo.UserBo;
import com.projectprop.model.UserRegistration;

@Controller
public class UserRegistrataionController {
	private static final Logger logger = Logger.getLogger(UserRegistrataionController.class);
	@Autowired
	private UserBo userBo;
	// will inject userBo from XML file

	@RequestMapping(value = "/userregister", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName, @RequestParam("contactnumber") String contact,
			@RequestParam("emailid") String email, @RequestParam("pw") String password,
			@RequestParam("skills") String skill) {

		ModelAndView mv = new ModelAndView();
		// ModelAndView object is created
		UserRegistration user = new UserRegistration();
		logger.info("UserRegistration object is created");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setContact(contact);
		user.setEmail(email);
		user.setPassword(password);
		user.setSkills(skill);

		int counter = userBo.registerUser(user);

		if (counter > 0) {
			logger.info("User registration details: " + user);
			mv.addObject("msg", "User registration successful.");
		} else {
			logger.error("User already exist");
			mv.addObject("msg", "User already exist");
		}

		mv.setViewName("userRegistration");

		return mv;

	}

}
