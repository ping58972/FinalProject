package emailing;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type","text/HTML; charset=utf-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@examle.com","NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "Utf-8");
			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail,false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("Message is sent");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[]args) {
		final String password = "qvPK4nUmFc2W";
		final String fromEmail = "smtpjavatest@gmial.com";
		final String toEmail = "will.schuss@gmail.com";

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //smtp
		props.put("mail.smtp.socketFactory.port", "465"); //SSL
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail,password);
			}
		};

		Session session = Session.getInstance(props,auth);
		System.out.println("Session created");
		EmailUtil.sendEmail(session, toEmail,"SSLEmail testing Subject","SSLEmail Testing body");
	}
}
