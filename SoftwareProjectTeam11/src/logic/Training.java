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
	@Column(name="beginDatum")
	private String beginDatum;
	@Column(name="eindDatum")
	private String eindDatum;
	@Column(name="trainingName")
	private String trainingName;
	@Column(name="trainingSummary")
	private String trainingSummary;
	@Column(name="visibility")
	private int visibility;
	
	public Training(int trainingId, int locationId, String beginDatum, String eindDatum, String trainingName,
			String trainingSummary, int visibility) {
		super();
		this.trainingId = trainingId;
		this.locationId = locationId;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
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

	public String getBeginDatum() {
		return beginDatum;
	}

	public void setBeginDatum(String beginDatum) {
		this.beginDatum = beginDatum;
	}

	public String getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(String eindDatum) {
		this.eindDatum = eindDatum;
	}

	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", locationId=" + locationId + ", beginDatum=" + beginDatum
				+ ", eindDatum=" + eindDatum + ", trainingName=" + trainingName + ", trainingSummary=" + trainingSummary
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
