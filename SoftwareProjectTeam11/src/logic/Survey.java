package logic;

public class Survey {
	
	private int surveyId;
	private Training training;
	private String surveyDescription;
	private Employee employee;

	public Survey(int surveyId, Training training, String surveyDescription, Employee employee) {
		super();
		this.surveyId = surveyId;
		this.training = training;
		this.surveyDescription = surveyDescription;
		this.employee = employee;
	}
	
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
