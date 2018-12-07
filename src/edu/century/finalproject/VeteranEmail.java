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

}
