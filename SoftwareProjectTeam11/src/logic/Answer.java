package logic;

import java.util.ArrayList;

public class Answer {
	
	private int answerId;
	private int questionId;
	private ArrayList<String> answers;
	
	public Answer(int answerId, int questionId, ArrayList<String> answers) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.answers = answers;
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

	

}
