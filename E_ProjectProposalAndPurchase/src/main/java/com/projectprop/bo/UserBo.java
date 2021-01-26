package com.projectprop.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectprop.dao.UserDao;
import com.projectprop.model.UserCredentials;
import com.projectprop.model.UserRegistration;

public class UserBo {

	@Autowired
	UserDao ud;
	// will inject ud from XML file

	public String loginUser(UserCredentials user) {
		return ud.loginUser(user);
	}

	public int registerUser(UserRegistration register) {
		return ud.registerUser(register);
	}

}
