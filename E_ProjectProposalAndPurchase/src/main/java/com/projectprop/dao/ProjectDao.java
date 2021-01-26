package com.projectprop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.projectprop.model.Project;
import com.projectprop.model.UserCredentials;
import com.projectprop.model.UserRegistration;
import com.projectprop.queryconstants.ProjectConstants;

public class ProjectDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Project p) {
		System.out.println(p.getBudget());
		String sql = ProjectConstants.PROJECTDETAILS;

		return jdbcTemplate.update(sql,
				new Object[] { p.getProjectName(), p.getDuration(), p.getBudget(), p.getSkills() });
	}

	public List<Project> getProject() {

		return jdbcTemplate.query(ProjectConstants.PROJECTFETCH, new ResultSetExtractor<List<Project>>() {

			public List<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Project> list = new ArrayList<Project>();
				while (rs.next()) {
					Project proj = new Project();
					proj.setProjectName(rs.getString(1));
					proj.setDuration(rs.getString(2));
					proj.setBudget(rs.getInt(3));
					proj.setSkills(rs.getString(4));
					list.add(proj);
				}
				return list;
			}
		});

	}

	public String UserSkill(UserCredentials user) {

		String sql = ProjectConstants.PROJECTUSER;

		try {

			String skills = jdbcTemplate.queryForObject(sql, new Object[] { user.getEmail() }, String.class);

			return skills;

		} catch (Exception e) {
			return null;
		}
	}

	public List<Project> getProjectAcSkill(String skills) {

		System.out.println("Inside getProjectAcSkill");
		return jdbcTemplate.query(ProjectConstants.PROJECTSKILL, new Object[] { skills },
				new ResultSetExtractor<List<Project>>() {

					public List<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<Project> list = new ArrayList<Project>();
						while (rs.next()) {
							Project proj = new Project();
							proj.setProjectName(rs.getString(1));
							System.out.println(rs.getString(1));
							proj.setDuration(rs.getString(2));
							proj.setBudget(rs.getInt(3));
							proj.setSkills(rs.getString(4));
							list.add(proj);
						}
						return list;
					}
				});
	}

	public List<UserRegistration> getUserProposal() {
		return jdbcTemplate.query(ProjectConstants.PROJECTPROP, new ResultSetExtractor<List<UserRegistration>>() {
			public List<UserRegistration> extractData(ResultSet rs) throws SQLException, DataAccessException {

				System.out.println("Inside getUserProposal");

				List<UserRegistration> list = new ArrayList<UserRegistration>();
				while (rs.next()) {
					UserRegistration user = new UserRegistration();
					user.setFirstName(rs.getString(1));
					System.out.println(rs.getString(1));
					user.setLastName(rs.getString(2));
					user.setContact(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setSkills(rs.getString(5));
					list.add(user);
				}
				return list;
			}
		});
	}

	public List<Project> getProjectStatus() {
		return jdbcTemplate.query(ProjectConstants.PROJECTFETCH, new RowMapper<Project>() {
			public Project mapRow(ResultSet rs, int row) throws SQLException {
				Project p = new Project();
				p.setProjectName(rs.getString(1));
				p.setStatus(rs.getString(5));
				return p;
			}
		});
	}

	public int updateStatus(Project proj) {
		String sql = "update projectdata set status='" + proj.getStatus() + "' where name='" + proj.getProjectName()
				+ "'";
		return jdbcTemplate.update(sql);
	}

}
