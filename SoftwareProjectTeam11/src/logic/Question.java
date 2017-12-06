package logic;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Question {
	@Id
	private int questionId;
	private String question;
	private int surveyId;
	private ArrayList<String> questions;
	
	public Question(int questionId, int surveyId, ArrayList<String> questions) {
		super();
		this.questionId = questionId;
		this.surveyId = surveyId;
		this.questions = questions;
	}


	public Question() {
		super();
	}

	public Question(int questionId, String question, int surveyId, ArrayList<String> questions) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.surveyId = surveyId;
		this.questions = questions;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
	

}
