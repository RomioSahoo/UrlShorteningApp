package com.projectprop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectprop.bo.AdminBo;
import com.projectprop.model.AdminCredentials;

@Controller
public class AdminLoginController {
	private static final Logger logger = Logger.getLogger(AdminLoginController.class);

	@Autowired
	private AdminBo adminBo;
	// will inject adminBo from XML file

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("email") String email, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		// ModelAndView object is created
		AdminCredentials admin = new AdminCredentials();
		logger.info("AdminCredentials Object created");
		admin.setEmail(email);
		admin.setPassword(password);

		String name = adminBo.loginAdmin(admin);

		if (name != null) {
			logger.info("The entered details are= " + admin);
			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
			mv.setViewName("welcomeadmin");

		} else {
			logger.error("Invalid user id or password.");
			mv.addObject("msg", "Invalid email id or password.");
			mv.setViewName("adminLogin");
		}

		return mv;

	}

}
