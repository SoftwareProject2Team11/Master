package logic;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
public void sendEmail(String recipient, String HTMLBody) {
		
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
			message.setContent(HTMLBody,"text/html; charset=utf-8");
			Transport.send(message);
			
			System.out.println("...Mail succesfully send...");
		}
		
		catch (MessagingException e){
			throw new RuntimeException("...Failed to send email...");
		}
	}
}
