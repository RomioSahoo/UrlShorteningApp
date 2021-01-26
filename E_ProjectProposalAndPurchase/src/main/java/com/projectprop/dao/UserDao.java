package com.projectprop.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.projectprop.model.UserCredentials;
import com.projectprop.model.UserRegistration;
import com.projectprop.queryconstants.UserConstants;

public class UserDao  {

	private JdbcTemplate jdbcTemplate;

	/*
	 * public UserDaoImpl(DataSource dataSoruce) { jdbcTemplate = new
	 * JdbcTemplate(dataSoruce); }
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int registerUser(UserRegistration register) {
		String sql = UserConstants.USERREGISTER;

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { register.getFirstName(), register.getLastName(),
					register.getContact(), register.getEmail(), register.getPassword(), register.getSkills() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String loginUser(UserCredentials user) {

		String sql = UserConstants.USERLOGIN;

		try {

			String name = jdbcTemplate.queryForObject(sql, new Object[] { user.getEmail(), user.getPassword() },
					String.class);

			return name;

		} catch (Exception e) {
			return null;
		}
	}

}
