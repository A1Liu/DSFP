package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestClients extends Application {

	public static void main(String...strings) {
		launch(strings);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MEOWMEOWBEENZ");
		App application = new App(primaryStage);
	}
	
	

}
