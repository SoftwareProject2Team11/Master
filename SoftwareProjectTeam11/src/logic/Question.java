package logic;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@Column(name="questionId")
	private int questionId;
	@Column(name="trainingId")
	private int trainingId;
	@Column(name="question")
	private String question;
	
	
	public Question(int questionId, int trainingId, String question) {
		super();
		this.questionId = questionId;
		this.trainingId = trainingId;
		this.question = question;
	}
	
	public Question() {

	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}
