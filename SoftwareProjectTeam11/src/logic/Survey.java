package logic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Survey")
public class Survey {
 
	@Id
	private int surveyId;
	private int employeeId;
	private int trainingId;
	private boolean visibility;
	private String surveyDescription;
	//private Training training;
	//private Employee employee;
	
	
	
	public Survey() {
		super();
		
	}



	public int getSurveyId() {
		return surveyId;
	}



	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public int getTrainingId() {
		return trainingId;
	}



	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}



	public boolean isVisibility() {
		return visibility;
	}



	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}



	public String getSurveyDescription() {
		return surveyDescription;
	}



	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}
}
