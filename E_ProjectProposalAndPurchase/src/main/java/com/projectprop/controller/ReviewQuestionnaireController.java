package com.projectprop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectprop.bo.ReviewQuestionnaireBo;
import com.projectprop.model.ReviewQuestionnaire;
import com.projectprop.model.SubmitQuestionnaire;

@Controller
public class ReviewQuestionnaireController {

	@Autowired
	ReviewQuestionnaireBo rqb;
	// will inject rqb from XML file

	@RequestMapping(value = "/showComplete")
	public String save(Model m) {
		System.out.println("Inside save");
		List<ReviewQuestionnaire> subu = rqb.getQuestions();
		m.addAttribute("subu", subu);
		List<SubmitQuestionnaire> subj = rqb.getAnswers();
		m.addAttribute("subj", subj);
		return "showComplete";
	}

	/*
	 * used to create  create Review for feedback
	 */
	@RequestMapping(value = "/createReviewQuestionnaire", method = RequestMethod.POST)
	public String showForm(@ModelAttribute("question") ReviewQuestionnaire question) {

		return "reviewQuestionnaireAdmin";
	}

	@RequestMapping(value = "/submitQuestion", method = RequestMethod.POST)
	public String submitQuestionnaire(@ModelAttribute("question") ReviewQuestionnaire question) {
		rqb.saveQuestion(question);
		return "feedbackAdded";
	}

}
