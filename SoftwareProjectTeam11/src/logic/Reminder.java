package logic;

import java.util.Date;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reminder {
	@Id
	private int reminderId;
	private Date reminderDate;
	
	public Reminder(int reminderId, Date rinderDate) {
		this.reminderId = reminderId;
		this.reminderDate = rinderDate;
	}
	
	public Reminder() {
		
	}
	
	public void setReminder(int reminderId, Date reminderDate) {
		this.setReminderId(reminderId);
		this.setReminderDate(reminderDate);
	}

	public int getReminderId() {
		return reminderId;
	}

	public void setReminderId(int reminderId) {
		this.reminderId = reminderId;
	}

	public Date getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(Date rinderDate) {
		this.reminderDate = rinderDate;
	}
	
	/*
public void sendReminder(Training training, String recipient) {
		
		final String username = "noreplythismail34@gmail.com";
		final String password = "Soft2Groep11";
	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(props, 
				new javax.mail.Authenticator() {
					
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("noreplythismail34@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(recipient));
			message.setSubject("Reminder to training");
			message.setContent(
					"<head><style>" +
					"body {background-color: linen;" +
							"font-family: \"Optima\", Times, serif;}" +
					
					"h1 {color: maroon;" +
						"text-align: center;}" +
					
					"#fullText {border-style: groove;}" +
						
					"#textOnly {margin-left: 40px;}" +
					
					"#footer {text-align: center;}" +
					
					"</style></head>" +
					
					"<h1>This mail is a reminder for your next training:</h1>\n" + 
						"<div id=" + " \"fullText\" " + ">" +
							"<div id=" + " \"textOnly\" " + ">" +
								"<h2>Training details:</h2>\n" + 
									"<ul>\n" + 
										"    <li><p>TrainingID: " + training.getTrainingID() + "</p></li>\n" + 
										"    <li><p>Date: " + training.getDate() + "</p></li>\n" + 
										//"    <li><p>Address: " + training.getLocation().toStringForMail() + "</p></li>\n" + 
											//Hiervoor is volgende methode in de klasse Locatie nodig:
											
											/* public String toStringForMail() {
												return super.getPostal() + " " + super.getCity() + " - " + super.getStreet() + " " + super.getNumber() + " " + super.getBus();
												}
											 
												
										"    <li><p>Duration: " + training.getDuration() + " hours</p></li>\n" + 
									"</ul>\n" + 
								"<h2>Sumary of the training:</h2>\n" +
									"<p>" + training.getSummary() + "</p>" +
								"<h2>List of materials you need for this training:</h2>\n" +
									"<p>" + training.showMaterialListForMail() + "</p>\n" +
								"<h2>Guest list:</h2>\n" +
									"<p>" + training.showEmployeeListForMail() + "</p>\n" +
							"</div>" +
							"<br />\n" + 
						"</div>" +
						"<div id=" + " \"footer\" " + ">" +
							"<p>We are looking formard to see you at the training</p>\n" + 
							"<p>Kind regards</p>\n" + 
							"<br />\n" + 
							"<p>Note: this is a no-reply email address, their is no reply needed to this email</p>" +
						"</div>", 
					"text/html; charset=utf-8");
			Transport.send(message);
			
			System.out.println("...Mail succesfully send...");
		}
		
		catch (MessagingException e){
			throw new RuntimeException("...Failed to send email...");
		}
	}
	*/
	
}