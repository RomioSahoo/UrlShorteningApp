package com.projectprop.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.projectprop.model.AdminCredentials;
import com.projectprop.model.AdminRegistration;
import com.projectprop.queryconstants.AdminConstants;

public class AdminDao  {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int registerAdmin(AdminRegistration register) {
		String sql = AdminConstants.ADMINREGISTER;

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { register.getFirstName(), register.getLastName(),
					register.getContactNumber(), register.getEmail(), register.getPassword() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String loginAdmin(AdminCredentials admin) {
		String sql = AdminConstants.ADMINLOGIN;

		try {

			String name = jdbcTemplate.queryForObject(sql, new Object[] { admin.getEmail(), admin.getPassword() },
					String.class);

			return name;

		} catch (Exception e) {
			return null;
		}
	}

}
