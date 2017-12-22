package logic;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import logic.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Email() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /**
    * Validate hex with regular expression
    * 
    * @param hex
    *            hex for validation
    * @return true valid hex, false invalid hex
    */
    public boolean validate(final String hex) {

    matcher = pattern.matcher(hex);
    return matcher.matches();

    }
	
public void sendEmail(String recipient, String HTMLBody) {
		
	
		final String username = "noreplythismail34@gmail.com";
		final String password = "Soft2Groep11";
		System.out.println(1.2);
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		System.out.println(1.3);
		Session session = Session.getInstance(props, 
				new javax.mail.Authenticator() {
					
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
		});
		
		System.out.println(1.4);
		try {
			System.out.println(1.5);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(recipient));
			message.setSubject("New Password");
			System.out.println(1.6);
			message.setContent(HTMLBody,"text/html; charset=utf-8");
			System.out.println(1.7);
			Transport.send(message);
			System.out.println(1.8);
			System.out.println("...Mail succesfully send...");
		}
		
		catch (MessagingException e){
			throw new RuntimeException("...Failed to send email...");
		}
	}
}
