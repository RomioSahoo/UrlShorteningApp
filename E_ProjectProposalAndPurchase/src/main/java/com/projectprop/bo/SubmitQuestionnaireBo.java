package com.projectprop.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectprop.dao.SubmitQuestionnaireDao;
import com.projectprop.model.ReviewQuestionnaire;
import com.projectprop.model.SubmitQuestionnaire;

public class SubmitQuestionnaireBo {

	@Autowired
	SubmitQuestionnaireDao sqd;
	
	public void saveAnswer(SubmitQuestionnaire q)
	{
		sqd.deletes();
		sqd.saves(q);
		
	}

	public List<ReviewQuestionnaire> getQuestions() {
		// TODO Auto-generated method stub
		List<ReviewQuestionnaire> m=sqd.getQuestionsFromReview();
		return m;
	}

}
