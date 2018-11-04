package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VeteranBenefitsApplication extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		QuestionView questionView = new QuestionView("veteran.csv");

		Scene scene = new Scene(questionView,600,800);
		stage.setHeight(600);
		stage.setWidth(800);
		stage.setScene(scene);;
		stage.show();
		
	}

}
