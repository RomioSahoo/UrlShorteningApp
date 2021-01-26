package com.projectprop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectprop.bo.SubmitQuestionnaireBo;
import com.projectprop.model.ReviewQuestionnaire;
import com.projectprop.model.SubmitQuestionnaire;

@Controller
public class SubmitQuestionnaireController {
	@Autowired
	SubmitQuestionnaireBo sqb;
	// will inject sqb from XML file

	/*
	 * used to create  create questions for feedback
	 */
	@RequestMapping(value = "/createSubmitQuestionnaire", method = RequestMethod.POST)
	public String showForm(@ModelAttribute("answer") SubmitQuestionnaire answer, Model m) {
		List<ReviewQuestionnaire> sub = sqb.getQuestions();
		m.addAttribute("sub", sub);
		return "submitQuestionnaireVendor";
	}

	@RequestMapping(value = "/submitAnswer", method = RequestMethod.POST)
	public String submitQuestionnaire(@ModelAttribute("answer") SubmitQuestionnaire answer) {
		sqb.saveAnswer(answer);
		return "feedbackSuccess";
	}
}
