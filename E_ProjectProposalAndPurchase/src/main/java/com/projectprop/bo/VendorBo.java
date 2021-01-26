package com.projectprop.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectprop.dao.VendorDao;

import com.projectprop.model.VendorCredentials;
import com.projectprop.model.VendorRegistration;

public class VendorBo {
	@Autowired
	VendorDao vd;
	// will inject vd from XML file

	public int registerVendor(VendorRegistration register) {
		return vd.registerVendor(register);
	}

	public String loginVendor(VendorCredentials vendor) {
		return vd.loginVendor(vendor);
	}
}
