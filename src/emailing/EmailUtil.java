package emailing;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	
	private final static String PASSWORD = "qvPK4nUmFc2W";
	private final static String FROM_EMAIL = "smtpjavatest@gmail.com";
	
	
	

	public static void sendEmail(Session session, String toEmail, String subject, String bodyText) {
	
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("No_Reply@gmail.com",false));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject);
			message.setText(bodyText);

			Transport.send(message);


		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * @desc
	 * 	will generate a new session object that has the ability to send messages using TLS authentication
	 * @return
	 * 	a session that can send email's
	 */
	public static Session getTLSSession() {
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
					}
		});
		
		return session;
	}
	
	
	/**
	 * @desc
	 * 	sends an email to the targetEmail address with an attachment
	 * @param session
	 * 	the session object recommend using getTLSSession()
	 * @param targetEmail
	 * 	the email address of the person you want to send a message to 
	 * @param subject
	 * 	the subject line of the email
	 * @param body
	 * 	the body text of the email, can also be formated using HTML
	 * @param targetFileLocation
	 * 	the file location of the desired attachment
	 */
	public static void sendAttachment(Session session, String targetEmail, String subject, String body, String targetFileLocation) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "tex/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@gmail.com",false));
			msg.setSubject(subject, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(targetEmail,false));
			
			BodyPart messagePart = new MimeBodyPart();
			messagePart.setText(body);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messagePart);
			
			messagePart = new MimeBodyPart();
			DataSource source = new FileDataSource(targetFileLocation);
			messagePart.setDataHandler(new DataHandler(source));
			messagePart.setFileName("Results.pdf");
			multipart.addBodyPart(messagePart);
			
			msg.setContent(multipart);
			
			Transport.send(msg);
			
		}catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[]args) {
		

		sendAttachment(getTLSSession(), "will.schuss@gmail.com", "TestAttachment", "Testing", "D:/git/FinalProject/Will Smith_Response.pdf");


	}
}
