package GUI;

import edu.century.finalproject.CreatePDF;
import edu.century.finalproject.ResponseList;
import edu.century.finalproject.ResponseNode;
import edu.century.finalproject.VeteranEmail;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class ResultView extends VBox {

	private TextFlow responseArea;
	
	private Button pdfBtn;
	private Button emailBtn;
	private Button retakeBtn;
	
	private ResponseList responses;
	
	private CreatePDF pdfResult;
	
	public ResultView(ResponseList responses, Button retakeBtn) {
		this.setPrefHeight(600);
		this.setPrefWidth(800);
		
		
		this.responses = responses;
		responseArea = new TextFlow();
		
		this.retakeBtn = retakeBtn;
		populate();
		setDisplay();
		
	}
	
	private void setDisplay() {
		this.setStyle("-fx-background-color: " + UtilityColors.centuryBlue() +";" +
				"-fx-padding: 30,30,30,30");
		
		ScrollPane scrollArea = new ScrollPane();
		Pane responsePane = new Pane();
		HBox btnBox = new HBox();
		
		
		responsePane.setPrefWidth(this.getPrefWidth());
		responsePane.setPrefHeight(this.getPrefHeight() * (2.0/3));
		responsePane.setStyle("-fx-background-color: white;");
		responsePane.getChildren().add(responseArea);
		
		scrollArea.setPrefWidth(responsePane.getWidth());
		scrollArea.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollArea.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollArea.setContent(responsePane);
		
		this.getChildren().add(scrollArea);
		 
		
		pdfBtn = UtilityGUI.createButton("Generate PDF");
		
		//PDF SHOULD ONLY BE CREATED WHEN THE USERS CLICKS THE 'GENERATE PDF' BUTTON
		//OTHERWISE WE NEED TO KEEP TRACK OF THE PDF FILE THROUGHOUT THE ENTIRE CLASS
		pdfBtn.setOnAction(e ->{
			createPDF();
			pdfResult.openPDF();
			
		});
		emailBtn = UtilityGUI.createButton("Send Email -> Exit ");
		emailBtn.setTextAlignment(TextAlignment.CENTER);
		emailBtn.setWrapText(true);
		
		//NEED VETERANEMAIL CLASS AND MAINGUI IMPELEMENTED - COMMENTED OUT SO CODE IS TESTABLE
		emailBtn.setOnAction(e ->{
			createPDF();
			//Setup the information for sending email here.
			String sourceEmail = "finalprojecttest2018century@gmail.com";
	    	String password = "2018Century";
	    	String toEmail = MainGUI.email;
	    	String filenamePath = pdfResult.getFilePath();
	    	String subject = "Sending Veteran Email  example with PDF Attachment";
	    	String body = "Hi, " + MainGUI.firstName +" "+ MainGUI.lastName+"\n This is Sending Veteran Email  example with PDF Attachment for testing. \nThanks.\nBy Century College Veteran Services.\n";
	    	//sending email when clicked the email button.
	    	VeteranEmail email = new VeteranEmail(sourceEmail,  password, toEmail, filenamePath, subject, body);	
	    	//exit when click sending email button.
	    	
		});
		
		
		btnBox.setPrefWidth(this.getPrefWidth());
		btnBox.setPrefHeight(this.getPrefHeight() * (1.0/3));
		btnBox.setStyle("-fx-background-color: white;");
		btnBox.setAlignment(Pos.CENTER_LEFT);
		btnBox.setPadding(new Insets(0,25,0,25));
		
		
		btnBox.getChildren().add(pdfBtn);
		btnBox.getChildren().add(UtilityGUI.createNullPane(160, 200));
		btnBox.getChildren().add(emailBtn);
		btnBox.getChildren().add(UtilityGUI.createNullPane(160, 200));
		btnBox.getChildren().add(retakeBtn);
		
		this.getChildren().add(btnBox);
		
		
	}
	
	public void populate() {
		ResponseNode cursor;
		if(responses.getHead() == null)
			return;
		
		for(cursor = responses.getHead(); cursor.getLink() != null; cursor = cursor.getLink()) {
			Text question = new Text(cursor.getQuestion() + "\n");
			Text response = new Text(cursor.getAnswer());
			response.setFont(Font.font(null, FontWeight.BOLD, 12));
			
			if(response.getText().equals("Yes")) {
				response.setFill(Color.GREEN);
			}else {
				response.setFill(Color.RED);
			}
			
			responseArea.getChildren().addAll(question, new Text("\tYour Response: "), response, new Text("\n\n"));
			
		}
		
		responseArea.getChildren().addAll(new Text("You may qualify for the following benefit(s): " + cursor.getQuestion()));

	}
	
	public void resetView() {
		responseArea.getChildren().clear();
		
	}

	public void setResponses(ResponseList responses) {
		this.responses = responses;
	}
	
	private void createPDF() {
		pdfResult = new CreatePDF(MainGUI.firstName + " " + MainGUI.lastName, MainGUI.email);	//GENERIC INFORMATION UNTIL THE MAIN GUI IS IMPLEMENTED
		pdfResult.add(responses);
		
	}
}