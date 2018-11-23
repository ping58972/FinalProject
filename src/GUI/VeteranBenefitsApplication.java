package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VeteranBenefitsApplication extends Application {

	Stage window;
	Scene questionScene;
	QuestionView questionView;
	Scene resultScene;
	ResultView resultView;
	
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setHeight(600);
		window.setWidth(800);
		
		Button viewResultBtn = UtilityGUI.createButton("View Results");
		viewResultBtn.setOnAction(e -> {
			window.setScene(resultScene);
			resultView.resetView();
			resultView.setResponses(questionView.getResults());
			resultView.populate();
			
		});
		
		Button retakeBtn = UtilityGUI.createButton("Retake");
		retakeBtn.setOnAction(e -> {
			window.setScene(questionScene);
			questionView.resetView();
		});
		
		questionView = new QuestionView("veteran.csv", viewResultBtn);
		resultView = new ResultView(questionView.getResults(), retakeBtn);
		
		questionScene = new Scene(questionView, 600, 800);
		resultScene = new Scene(resultView, 600, 800);
		
		window.setScene(questionScene);
		window.show();
		
	}

}
