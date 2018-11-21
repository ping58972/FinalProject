package GUI;

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
	
	
	
	public ResultView(ResponseList responses) {
		
		this.responses = responses;
		
		responseArea = new TextFlow();
		
		
		setDisplay();
		populate(responses.getHead());
	}
	
	private void setDisplay() {
		Pane responsePane = new Pane();
		HBox btnBox = new HBox();
		
		responsePane.setPrefWidth(this.getPrefWidth());
		responsePane.getChildren().add(responseArea);
		
		
		this.getChildren().add(responsePane);
		
		pdfBtn = UtilityGUI.createButton("Print PDF of Results");
		emailBtn = UtilityGUI.createButton("Email Century Veteran Service");
		retakeBtn = UtilityGUI.createButton("Retake");
		
		btnBox.setPrefWidth(this.getPrefWidth());
		btnBox.getChildren().add(pdfBtn);
		btnBox.getChildren().add(emailBtn);
		btnBox.getChildren().add(retakeBtn);
		
		this.getChildren().add(btnBox);
		
	}
	
	private void populate(ResponseNode head) {
		ResponseNode cursor;
		if(head == null)
			return;
		
		for(cursor = head; cursor != null; cursor = cursor.getLink()) {
			Text question = new Text(cursor.getQuestion() + "\n");
			Text response = new Text(cursor.getAnswer());
			response.setFont(Font.font(null, FontWeight.BOLD, 12));
			
			if(response.getText().equals("Yes")) {
				response.setFill(Color.GREEN);
			}else {
				response.setFill(Color.RED);
			}
			
			
			responseArea.getChildren().addAll(question, new Text("Your Response: "), response, new Text("\n\n"));
			
		}
		
		
	}

}
