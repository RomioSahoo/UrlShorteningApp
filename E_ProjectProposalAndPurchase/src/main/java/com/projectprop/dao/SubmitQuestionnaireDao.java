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


public class SubmitQuestionnaireDao {
JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 
	public Boolean saves(final SubmitQuestionnaire q){    
	    //String sql="insert into reviewQuestionnaire values('"+q.getQuestion1()+"','"+q.getQuestion2()+"','"+q.getQuestion3()+"')";    
	    String sql=QuestionnaireConstants.ADDANSWERSTODATABASE;
		//return template.update(sql);  
	    return template.execute(sql,new PreparedStatementCallback<Boolean>(){  
	        public Boolean doInPreparedStatement(PreparedStatement ps)  
	                throws SQLException, DataAccessException {  
	                  
	            ps.setString(1,q.getAnswer1());  
	            ps.setString(2,q.getAnswer2());  
	            ps.setString(3,q.getAnswer3());  
	                  
	            return ps.execute();  
	                  
	        }  
	        });  
	}
	public int deletes() {
		String sql=QuestionnaireConstants.DELETEANSWERSFROMDATABASE;
		return template.update(sql);
	}
	
	public List<ReviewQuestionnaire> getQuestionsFromReview() {
		return template.query(
				QuestionnaireConstants.QUESTIONFETCH,
				new ResultSetExtractor<List<ReviewQuestionnaire>>() {
					public List<ReviewQuestionnaire> extractData(ResultSet rs) throws SQLException, DataAccessException {

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
}
