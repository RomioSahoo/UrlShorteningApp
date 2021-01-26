package com.projectprop.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectprop.dao.AdminDao;
import com.projectprop.model.AdminCredentials;
import com.projectprop.model.AdminRegistration;

public class AdminBo {
	@Autowired
	AdminDao ad;
	// will inject ad from XML file

	public int registerAdmin(AdminRegistration register) {
		return ad.registerAdmin(register);
	}

	public String loginAdmin(AdminCredentials admin) {
		return ad.loginAdmin(admin);
	}
}
