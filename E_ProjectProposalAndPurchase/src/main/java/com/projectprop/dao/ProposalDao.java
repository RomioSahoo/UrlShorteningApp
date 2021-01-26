package com.projectprop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.projectprop.model.PaymentDetails;
import com.projectprop.model.Project;
import com.projectprop.model.Proposal;
import com.projectprop.queryconstants.ProposalConstants;

public class ProposalDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Proposal> getProposal() {
		return jdbcTemplate.query(ProposalConstants.PROPOSALFETCH, new RowMapper<Proposal>() {
			public Proposal mapRow(ResultSet rs, int row) throws SQLException {
				Proposal p = new Proposal();
				p.setEmail(rs.getString(1));
				p.setProjectName(rs.getString(2));
				p.setStatus(rs.getString(3));
				p.setSkills(rs.getString(4));
				return p;
			}
		});
	}

	public int acceptUser(String email) {
		String sql = "update proposal set Status='" + "Accepted" + "' where email='" + email + ".com'";
		System.out.println(email);
		return jdbcTemplate.update(sql);
	}

	public int rejectUser(String email) {
		System.out.println(email);
		String sql = "delete from proposal where email='" + email + ".com'";
		return jdbcTemplate.update(sql);
	}

	public List<Project> getCompletedProject() {

		return jdbcTemplate.query(
				ProposalConstants.PROPOSALSTATUS,
				new ResultSetExtractor<List<Project>>() {

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

	public int paymentDetails(PaymentDetails pay) {
		// String sql = AdminConstants.ADMINREGISTER;

		try {

			int counter = jdbcTemplate.update(ProposalConstants.PROPOSALPAYMENT,
					new Object[] { pay.getName(), pay.getEmail(), pay.getCardNumber() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<PaymentDetails> getVendorPayment() {

		return jdbcTemplate.query(ProposalConstants.PROPOSALPAYDETAILS, new ResultSetExtractor<List<PaymentDetails>>() {

			public List<PaymentDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<PaymentDetails> list = new ArrayList<PaymentDetails>();
				while (rs.next()) {
					PaymentDetails pay = new PaymentDetails();
					pay.setTrans_id(rs.getInt(1));
					pay.setName(rs.getString(2));
					pay.setEmail(rs.getString(3));
					pay.setCardNumber(rs.getString(4));
					list.add(pay);
				}
				return list;
			}
		});

	}

}
