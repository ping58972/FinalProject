package emailing;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	private final static String PASSWORD = "qvPK4nUmFc2W";
	private final static String FROM_EMAIL = "smtpjavatest@gmail.com";
	

	public static void sendEmail(String targetEmail, String subject, String bodyText) {
		sendTLSEmail(FROM_EMAIL, PASSWORD, targetEmail, subject, bodyText);
	}

	public static void sendTLSEmail(String fromEmail, String password, String toEmail,
			String subject, String bodyText) {
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject);
			message.setText(bodyText);

			Transport.send(message);


		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[]args) {
		

		sendEmail("will.schuss@gmail.com","Testing for final Project", "This is only a test");


	}
}
