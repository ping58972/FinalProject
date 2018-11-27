package GUI;

import edu.century.finalproject.CreatePDF;
import edu.century.finalproject.ResponseList;
import edu.century.finalproject.ResponseNode;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ResultView extends VBox {

	private TextFlow responseArea;
	
	private Button pdfBtn;
	private Button emailBtn;
	private Button retakeBtn;
	
	private ResponseList responses;
	
	
	
	public ResultView(ResponseList responses, Button retakeBtn) {
		this.setPrefHeight(600);
		this.setPrefWidth(800);
		
		
		this.responses = responses;
		responseArea = new TextFlow();
		
		this.retakeBtn = retakeBtn;
		setDisplay();
		populate();
	}
	
	private void setDisplay() {
		Pane responsePane = new Pane();
		HBox btnBox = new HBox();
		
		responsePane.setPrefWidth(this.getPrefWidth());
		responsePane.setPrefHeight(this.getPrefHeight() * (2.0/3));
		responsePane.setStyle("-fx-border-color: black");
		responsePane.getChildren().add(responseArea);
		
		
		this.getChildren().add(responsePane);
		
		pdfBtn = UtilityGUI.createButton("Print PDF of Results");
		pdfBtn.setOnAction(e ->{
			CreatePDF pdfResult = new CreatePDF("John Smith");
			pdfResult.add(responses);
			pdfResult.openPDF();
			
		});
		emailBtn = UtilityGUI.createButton("Email Century Veteran Service");

		
		btnBox.setPrefWidth(this.getPrefWidth());
		btnBox.setPrefHeight(this.getPrefHeight() * (1.0/3));
		btnBox.setStyle("-fx-border-color: black");
		btnBox.getChildren().add(pdfBtn);
		btnBox.getChildren().add(emailBtn);
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
}