package GUI;

import java.io.IOException;

import edu.century.finalproject.BTNode;
//import edu.century.finalproject.CreatePDF;
import edu.century.finalproject.ResponseList;
import edu.century.finalproject.ResponseNode;
import fileReader.CSVReader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class QuestionView extends VBox{

	Button yesBtn;
	Button noBtn;
	Button resultBtn;
	Label questionLabel;

	private BTNode questionTreeRoot;
	private BTNode questionCursor;
	private ResponseList responseList;


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
		this.setPrefWidth(800);
		this.setPrefHeight(600);
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
		this.setStyle("-fx-background-color: " + UtilityColors.centuryBlue() +";" +
						"-fx-padding: 30,30,30,30");

		StackPane questionPane = new StackPane();
		HBox btnBox = new HBox();

		questionLabel = UtilityGUI.createQuestionLabel();


		yesBtn = UtilityGUI.createButton("YES");
		yesBtn.setOnAction(e -> responseClicked(this.yesBtn));

		noBtn = UtilityGUI.createButton("NO");
		noBtn.setOnAction(e -> responseClicked(this.noBtn));

		questionPane.setStyle("-fx-background-color: white;");
//		questionPane.setStyle("-fx-border-color: " + UtilityColors.centuryBlue() + ";" +
//								"-fx-border-width: 5 5 0 5;" +
//								"-fx-background-color: white;");
		questionPane.setPrefWidth(800);
		questionPane.setPrefHeight(400);
		questionPane.getChildren().add(questionLabel);
		questionPane.setAlignment(Pos.CENTER);

		btnBox.setStyle("-fx-background-insets: 0, 20, 20, 20;" +
						"-fx-background-color: white;");
		btnBox.setPrefWidth(800);
		btnBox.setPrefHeight(200);
		btnBox.setPadding(new Insets(25,0,25,0));

		btnBox.getChildren().add(UtilityGUI.createNullPane(160, 200));
		btnBox.getChildren().add(yesBtn);
		btnBox.getChildren().add(this.resultBtn);
			resultBtn.setVisible(false);
		btnBox.getChildren().add(noBtn);
		btnBox.getChildren().add(UtilityGUI.createNullPane(160, 200));



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


		responseList.add(new ResponseNode(question, answer));

		//If the user has reached a leaf of the tree, add the benefit to the ResponseList and disable the buttons.
		if(questionCursor.getLeft() == null && questionCursor.getRight() == null) {
			responseList.add(new ResponseNode(questionCursor.getData(), "yes"));
			this.yesBtn.setVisible(false);
			this.noBtn.setVisible(false);
			this.resultBtn.setVisible(true);

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