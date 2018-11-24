package GUI;

import java.io.IOException;

import edu.century.finalproject.BTNode;
import edu.century.finalproject.CreatePDF;
//import edu.century.finalproject.CreatePDF;
import edu.century.finalproject.ResponseList;
import edu.century.finalproject.ResponseNode;
import fileReader.CSVReader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class QuestionView extends VBox{
	
	Button yesBtn;
	Button noBtn;
	Button resultBtn;
	Label questionLabel;

	private BTNode questionTreeRoot;
	private BTNode questionCursor;
	private ResponseList responseList;
	static CreatePDF pdf;

	/**
	 * Constructor to create the QuestionUI
	 * @param targetFile the csv file for creating a question tree.
	 * @pre targetFile is a valid file name.
	 * @post The UI will be displayed.
	 */
	public QuestionView(String targetFile, Button resultBtn) {
		
		try {
			questionTreeRoot = CSVReader.readFile(targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		responseList = new ResponseList();
		questionCursor = questionTreeRoot;
		this.resultBtn = resultBtn;
		
		setDisplay();
		setQuestion();

	
	}
	
	/**
	 * Method for creating on the visual components of the UI.
	 * @post The visual components are added to the QuestionView.
	 */
	private void setDisplay() {
		Pane questionPane = new Pane();
		HBox btnBox = new HBox();
		
		questionLabel = UtilityGUI.createQuestionLabel();
		
		yesBtn = UtilityGUI.createButton("YES");
		yesBtn.setOnAction(e -> responseClicked(this.yesBtn));
		
		noBtn = UtilityGUI.createButton("NO");
		noBtn.setOnAction(e -> responseClicked(this.noBtn));
		
		questionPane.setStyle("-fx-border-color: black");
		questionPane.setPrefWidth(800);
		questionPane.setPrefHeight(400);
		questionPane.getChildren().add(questionLabel);
		
		btnBox.setStyle("-fx-border-color: black");
		btnBox.setPrefHeight(200);
		btnBox.setPadding(new Insets(25,0,25,0));
		
		btnBox.getChildren().add(UtilityGUI.createNullPane(160, 200));
		btnBox.getChildren().add(yesBtn);
		btnBox.getChildren().add(this.resultBtn);
			resultBtn.setVisible(false);
		btnBox.getChildren().add(noBtn);
		btnBox.getChildren().add(UtilityGUI.createNullPane(160, 200));
		
		
		pdf = new CreatePDF("John Smith");
		this.getChildren().addAll(questionPane, btnBox);
		
	}
	
	/**
	 * Method to handle the data structures when a user clicks a button.
	 * @param btnClicked the button that was clicked - either "Yes" or "No".
	 * @post The question and answer to the current question is added to the responseQueue. The cursor is set to the next link.
	 */
	public void responseClicked(Button btnClicked) {
		String question = questionCursor.getData();
		String answer;
		
		if(btnClicked.equals(this.yesBtn)) {
			answer = "yes";
			questionCursor = questionCursor.getLeft();
		}else {
			answer = "no";
			questionCursor = questionCursor.getRight();
		}
		
		pdf.add(question, answer);
		responseList.add(new ResponseNode(question, answer));
		
		//If the user has reached a leaf of the tree, disable the buttons.
		if(questionCursor.getLeft() == null && questionCursor.getRight() == null) {
			this.yesBtn.setVisible(false);
			this.noBtn.setVisible(false);
			this.resultBtn.setVisible(true);
			pdf.close(questionCursor.getData().toString());
		}
		setQuestion();
	}
	
	/**
	 * Sets the text of the questionLabel.
	 * @post the questionLabel's text will be the set to the data of the questionCursor.
	 */
	private void setQuestion() {
		if(questionCursor.getAdditionalFlag())
			questionLabel.setText(questionCursor.getData() + "\n" + questionCursor.getAdditionalData());
		else
			questionLabel.setText(questionCursor.getData());
	}
	
	public ResponseList getResults() {
		return responseList;
	}
	
	public void resetView() {
		ResponseList temp = new ResponseList();
		responseList = temp;
		
		questionCursor = questionTreeRoot;
		setQuestion();
		
		this.yesBtn.setVisible(true);
		this.noBtn.setVisible(true);
		this.resultBtn.setVisible(false);
	}
	
}
