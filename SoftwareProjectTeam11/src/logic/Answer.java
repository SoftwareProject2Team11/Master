package logic;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Answer {
	@Id
	private int answerId;
	private String answer;
	private int questionId;
	private ArrayList<String> answers;
	
	public Answer(int answerId, int questionId, ArrayList<String> answers) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.answers = answers;
	}
	
	
	public Answer() {
		super();
		//Hibernate
	}


	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Answer(int answerId, String answer, int questionId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questionId = questionId;
	}
	
	
	

}
