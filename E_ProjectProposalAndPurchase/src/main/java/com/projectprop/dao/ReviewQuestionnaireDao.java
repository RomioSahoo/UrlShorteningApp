package com.projectprop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.projectprop.model.ReviewQuestionnaire;
import com.projectprop.model.SubmitQuestionnaire;
import com.projectprop.queryconstants.QuestionnaireConstants;

public class ReviewQuestionnaireDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Boolean save(final ReviewQuestionnaire q) {
		String sql = QuestionnaireConstants.ADDQUESTIONSTODATABASE;
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, q.getQuestion1());
				ps.setString(2, q.getQuestion2());
				ps.setString(3, q.getQuestion3());

				return ps.execute();

			}
		});
	}

	public int delete() {
		String sql = QuestionnaireConstants.DELETEQUESTIONSFROMDATABASE;
		return template.update(sql);
	}

	public List<ReviewQuestionnaire> getQuestionsFromReview() {
		return template.query(QuestionnaireConstants.QUESTIONFETCH,
				new ResultSetExtractor<List<ReviewQuestionnaire>>() {
					public List<ReviewQuestionnaire> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						System.out.println("Inside getQuestionsFromReview");

						List<ReviewQuestionnaire> listing = new ArrayList<ReviewQuestionnaire>();
						while (rs.next()) {
							ReviewQuestionnaire review = new ReviewQuestionnaire();
							review.setQuestion1(rs.getString(1));
							System.out.println(rs.getString(1));
							review.setQuestion2(rs.getString(2));
							review.setQuestion3(rs.getString(3));
							listing.add(review);
						}
						return listing;
					}
				});
	}

	public List<SubmitQuestionnaire> getAnswersFromSubmit() {
		System.out.println("hi");
		return template.query(QuestionnaireConstants.ANSWERFETCH, new ResultSetExtractor<List<SubmitQuestionnaire>>() {
			public List<SubmitQuestionnaire> extractData(ResultSet rs) throws SQLException, DataAccessException {

				System.out.println("Insdie getAnswersFromSubmit");

				List<SubmitQuestionnaire> listin = new ArrayList<SubmitQuestionnaire>();
				while (rs.next()) {
					SubmitQuestionnaire review = new SubmitQuestionnaire();
					review.setAnswer1(rs.getString(1));
					System.out.println(rs.getString(1));
					review.setAnswer2(rs.getString(2));
					review.setAnswer3(rs.getString(3));
					listin.add(review);
				}
				return listin;
			}
		});
	}

}
