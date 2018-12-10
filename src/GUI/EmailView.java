
package GUI;

import edu.century.finalproject.CreatePDF;
import edu.century.finalproject.VeteranEmail;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmailView extends Application{

	private VBox root;
	private Label bodyLbl;

	private TextArea bodyTxtArea;
	
	private Button sendEmailBtn;
	
	
	
	public EmailView() {
		
		setComponents();
		
		HBox btnBox = new HBox(sendEmailBtn);
		btnBox.setAlignment(Pos.CENTER);
		root.setSpacing(5);
		root.getChildren().add(bodyLbl);
		root.getChildren().add(bodyTxtArea);
		root.getChildren().add(btnBox);
		
		
	}



	private void setComponents() {
		root = new VBox();
		bodyLbl = new Label("Compose Message for Email:");
		bodyTxtArea = new TextArea();
		bodyTxtArea.setWrapText(true);
		
		sendEmailBtn =	UtilityGUI.createButton("Send Email");
		
		
	}



	
	@Override
	public void start(Stage primaryStage) throws Exception {
		sendEmailBtn.setOnAction(e ->{

			//Setup the information for sending email here.
			String sourceEmail = "finalprojecttest2018century@gmail.com";
	    	String password = "2018Century";
	    	String toEmail = MainGUI.email;
	    	String filenamePath = CreatePDF.getFilePath();//CreatePDF.getFilePath(); 
	    	String subject = "Sending Veteran Email  example with PDF Attachment";
	    	String body = "Hi, " + MainGUI.firstName +" "+ MainGUI.lastName+bodyTxtArea.getText()+"\nBy Century College Veteran Services.\n";
	    	//sending email when clicked the email button.
	    	VeteranEmail email = new VeteranEmail(sourceEmail,  password, toEmail, filenamePath, subject, body);
			primaryStage.close();
		});
		primaryStage.setScene(new Scene(root));
		
		primaryStage.showAndWait();
		
	}
	
	
}
