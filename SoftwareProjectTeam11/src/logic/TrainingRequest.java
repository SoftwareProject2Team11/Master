package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Training_Requests")
public class TrainingRequest {

	@Id
	@Column(name="requestId")
	private int requestId;
	@Column(name="trainingId")
	private int trainingId;
	@Column(name="reason")
	private String reason;
	@Column(name="created_at")
	private String createDate;
	@Column(name="updated_at")
	private String updateDate;
	@Column(name="user_Id")
	private int userId;
	@Column(name="status")
	private int status;
	
	
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public TrainingRequest(int requestId, int trainingId,  String createDate, String updateDate,
			int userId) {
		super();
		this.requestId = requestId;
		this.trainingId = trainingId;

		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
	}
	
	public TrainingRequest (int requestId ,int trainingId,String reason,  String createDate, String updateDate,
			int userId, int status) {
		super();
		this.requestId = requestId;
		this.trainingId = trainingId;

		this.reason=reason;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
		this.status=status;
	}
	
	public TrainingRequest() {
		
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}



	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
