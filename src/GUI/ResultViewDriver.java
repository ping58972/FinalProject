package GUI;

import edu.century.finalproject.ResponseList;
import edu.century.finalproject.ResponseNode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ResultViewDriver extends Application {

	private ResponseList responses;
	
	public static void main(String[] args) {
		
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		responses = new ResponseList();
		responses.add(new ResponseNode("This is question 1?", "yes"));
		responses.add(new ResponseNode("This is question 2?", "no"));
		responses.add(new ResponseNode("This is question 3?", "no"));
		responses.add(new ResponseNode("This is question 4?", "yes"));
		
		ResultView responseView = new ResultView(responses);
		
		Scene scene = new Scene(responseView, 600, 800);
		stage.setHeight(600);
		stage.setWidth(800);
		stage.setScene(scene);
		stage.show();
		
	}

}
