package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Answer")
public class Answer {
	
	@Id
	@Column(name="answerId")
	private int answerId;
	@Column(name="answer")
	private String answer;
	@Column(name="questionId")
	private int questionId;
	
	
	public Answer(int answerId, String answer, int questionId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questionId = questionId;
	}

	public Answer() {

	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
}
