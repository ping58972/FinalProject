package edu.century.finalproject;
/**public class VeteranEmail from the package edu.century.finalproject
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  VeteranEmail.java, Programming Final Project.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 12/07/2018
 * */

import java.io.UnsupportedEncodingException;
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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class VeteranEmail {

    private String filenamePath; //set attachment file path.
    private  String sourceEmail;// requires valid Gmail id
    private String password; // correct password for Gmail id
    private String toEmail; // any destination email id
    
    /*public VeteranEmail(String sourceEmail, String password, 
	 * 	String toEmail, String filenamePath, String subject, String body)
	 * @Descriptions 
	 * 		to construct and set user name by user information. 
	 * @Parameter: 
	 * 		sourceEmail - String.
	 * 		password - String.
	 * 		toEmail - String.
	 * 		filenamePath - String.
	 * 		subject - String.
	 * 		body - String.
	 * @Precondition : all String not null.
	 * @Postcondition
	 * @Return
	 * @Thorws 	: null exception.
	 * */
    public VeteranEmail(String sourceEmail, String password, String toEmail, 
    		String filenamePath, String subject, String body) {
    	this.filenamePath = filenamePath;
    	this.password = password;
    	this.sourceEmail = sourceEmail;
    	this.toEmail = toEmail;
    	try {
			setEmail(subject, body);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /*public  void setEmail(String subject, String body)
	 * @Descriptions 
	 * 		to setup email. 
	 * @Parameter: 
	 * 		subject - String.
	 * 		body - String.
	 * @Precondition : all String not null.
	 * @Postcondition
	 * @Return
	 * @Thorws 	: AddressException and MessagingException exception.
	 * */
    public  void setEmail(String subject, String body) 
    		throws AddressException, MessagingException {
    	//setup Properties.
    	Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Authenticator authentication = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sourceEmail, password);
            }
        };
        generateEmailAndAttachment(Session.getInstance(props, authentication),toEmail, subject, body); 
    }
    
    /*public void generateEmailAndAttachment(Session session, 
	 * String toEmail, String subject, String body)
	 * @Descriptions 
	 * 		to generate Email And Attachment.
	 * @Parameter: 
	 * 		session - Session.
	 * 		toEmail - String.
	 * 		subject - String.
	 * 		body - String.
	 * @Precondition : all String not null.
	 * @Postcondition
	 * @Return
	 * @Thorws 
	 * */
    public void generateEmailAndAttachment(Session session, String toEmail, String subject, String body) {   	
        try {
            MimeMessage crunchifyMessage = new MimeMessage(session);
            crunchifyMessage.setFrom(new InternetAddress(sourceEmail,
                    "NoReply-CenturyCollege"));
            crunchifyMessage.setReplyTo(InternetAddress.parse(sourceEmail, false));
            crunchifyMessage.setSubject(subject, "UTF-8");
            crunchifyMessage.setSentDate(new Date());
            crunchifyMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail, false));           
            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body+"\nSent Data: " + new Date().toString(), "text/html");
            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            // Valid file location
            messageBodyPart.setDataHandler(new DataHandler(new FileDataSource(filenamePath)));
            messageBodyPart.setFileName(filenamePath);
            multipart.addBodyPart(messageBodyPart);
            crunchifyMessage.setContent(multipart);
            // Finally Send message
            Transport.send(crunchifyMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
