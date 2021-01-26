package com.projectprop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectprop.bo.UserBo;
import com.projectprop.dao.ProjectDao;
import com.projectprop.model.UserCredentials;

@Controller
public class UserLoginController {
	private static final Logger logger = Logger.getLogger(UserLoginController.class);
	@Autowired
	private UserBo userBo;
	// will inject userBo from XML file
	@Autowired
	private ProjectDao projectDao;
	// will inject projectDao from XML file

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("emailid") String email, @RequestParam("pw") String password) {

		ModelAndView mv = new ModelAndView();
		// ModelAndView object is created
		UserCredentials user = new UserCredentials();
		logger.info("UserCredentials object created");
		user.setEmail(email);
		user.setPassword(password);

		String name = userBo.loginUser(user);
		// String name = userBo.loginUser(user);
		String skills = projectDao.UserSkill(user);
		System.out.println(skills);
		mv.addObject("skills", skills);

		if (name != null) {
			logger.info("User Login Details:" + user);
			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
			mv.setViewName("welcomeuser");

		} else {

			mv.addObject("msg", "Invalid user id or password.");
			logger.error("Invalid user id or password.");
			mv.setViewName("userLogin");
		}

		return mv;

	}

}
