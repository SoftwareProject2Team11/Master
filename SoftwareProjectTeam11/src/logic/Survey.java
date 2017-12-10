package logic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Survey {
 
	@Id
	private int surveyId;
	private String surveyDescription;
	private Training training;
	private Employee employee;
	
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurveyDescription() {
		return surveyDescription;
	}
	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Survey(int surveyId, String surveyDescription, Training training, Employee employee) {
		super();
		this.surveyId = surveyId;
		this.surveyDescription = surveyDescription;
		this.training = training;
		this.employee = employee;
	}
	public Survey() {
		super();
		
	}
}
