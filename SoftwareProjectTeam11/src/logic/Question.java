package logic;

import java.util.ArrayList;

public class Question {
	
	private int questionId;
	private int surveyId;
	private ArrayList<String> questions;
	
	public Question(int questionId, int surveyId, ArrayList<String> questions) {
		super();
		this.questionId = questionId;
		this.surveyId = surveyId;
		this.questions = questions;
	}

	public Question() {
		// Constructor Hibernate
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public ArrayList<String> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}
	
	
	
	

}
