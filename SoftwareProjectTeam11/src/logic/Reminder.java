package logic;

import java.util.Date;

public class Reminder {
	private int reminderId;
	private Date reminderDate;
	
	public Reminder(int reminderId, Date rinderDate) {
		super();
		this.reminderId = reminderId;
		this.reminderDate = rinderDate;
	}

	public int getReminderId() {
		return reminderId;
	}

	public void setReminderId(int reminderId) {
		this.reminderId = reminderId;
	}

	public Date getRinderDate() {
		return reminderDate;
	}

	public void setRinderDate(Date rinderDate) {
		this.reminderDate = rinderDate;
	}
	
}