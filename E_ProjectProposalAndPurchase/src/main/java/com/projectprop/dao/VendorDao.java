package com.projectprop.dao;

import org.springframework.jdbc.core.JdbcTemplate;


import com.projectprop.model.VendorCredentials;
import com.projectprop.model.VendorRegistration;
import com.projectprop.queryconstants.VendorConstants;

public class VendorDao  {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int registerVendor(VendorRegistration register) {
		String sql = VendorConstants.VENDORREGISTER;

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { register.getFirstName(), register.getLastName(),
					register.getContactNumber(), register.getEmail(), register.getPassword() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String loginVendor(VendorCredentials vendor) {
		String sql = VendorConstants.VENDORLOGIN;

		try {

			String name = jdbcTemplate.queryForObject(sql, new Object[] { vendor.getEmail(), vendor.getPassword() },
					String.class);

			return name;

		} catch (Exception e) {
			return null;
		}
	}

}
