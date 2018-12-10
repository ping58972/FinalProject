
package GUI;

import emailing.EmailUtil;
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
			EmailUtil.sendAttachment(EmailUtil.getTLSSession(), "smtpJavaTest@gmail.com", "Vet Benifit App Email", 
					bodyTxtArea.getText(), System.getProperty("user.home") + "/Downloads/VET_Benift.pdf");
			primaryStage.close();
		});
		primaryStage.setScene(new Scene(root));
		
		primaryStage.showAndWait();
		
	}
	
	
}
