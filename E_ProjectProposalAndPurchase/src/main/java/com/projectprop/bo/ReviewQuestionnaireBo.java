package com.projectprop.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectprop.dao.ReviewQuestionnaireDao;
import com.projectprop.model.ReviewQuestionnaire;
import com.projectprop.model.SubmitQuestionnaire;

public class ReviewQuestionnaireBo {
	
	@Autowired
	ReviewQuestionnaireDao rqd;
	
	public void saveQuestion(ReviewQuestionnaire q)
	{
		rqd.delete();
		rqd.save(q);
	}
	public List<ReviewQuestionnaire> getQuestions() {
		// TODO Auto-generated method stub
		
		List<ReviewQuestionnaire> b=rqd.getQuestionsFromReview();
		return b;
	}
	public List<SubmitQuestionnaire> getAnswers() {
		List<SubmitQuestionnaire> f=rqd.getAnswersFromSubmit();
		return f;
	}

}
