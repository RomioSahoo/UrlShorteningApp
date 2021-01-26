package com.projectprop.queryconstants;

public class QuestionnaireConstants {
	
	public static final String ADDQUESTIONSTODATABASE="insert into reviewQuestionnaire values(?,?,?)";
	public static final String DELETEQUESTIONSFROMDATABASE="delete from reviewQuestionnaire";
	public static final String ADDANSWERSTODATABASE="insert into submitQuestionnaire values(?,?,?)";
	public static final String DELETEANSWERSFROMDATABASE="delete from submitQuestionnaire";
	public static final String QUESTIONFETCH="select question1,question2,question3 from reviewQuestionnaire";
	public static final String ANSWERFETCH="select answer1,answer2,answer3 from submitQuestionnaire";

}
