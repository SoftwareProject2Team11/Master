package logic;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Training")
public class Training {
	
	@Id
	@Column(name="addressId")
	private int trainingId;
	@Column(name="locationId")
	private int locationId;
	@Column(name="startDate")
	private String startDate;
	@Column(name="endDate")
	private String endDate;
	@Column(name="trainingName")
	private String trainingName;
	@Column(name="trainingSummary")
	private String trainingSummary;
	@Column(name="visibility")
	private int visibility;
	
	public Training(int trainingId, int locationId, String startDate, String endDate, String trainingName,
			String trainingSummary, int visibility) {
		super();
		this.trainingId = trainingId;
		this.locationId = locationId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainingName = trainingName;
		this.trainingSummary = trainingSummary;
		this.visibility = visibility;
	}

	public Training() {
		super();
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getstartDate() {
		return startDate;
	}

	public void setstartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getendDate() {
		return endDate;
	}

	public void setendDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", locationId=" + locationId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", trainingName=" + trainingName + ", trainingSummary=" + trainingSummary
				+ ", visibility=" + visibility + "]";
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTrainingSummary() {
		return trainingSummary;
	}

	public void setTrainingSummary(String trainingSummary) {
		this.trainingSummary = trainingSummary;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	
	
	
	

}
