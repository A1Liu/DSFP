package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import main.App;

public class TestRunner extends Application {

	public static void main(String... args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) {
		primaryStage.setTitle("MEOWMEOWBEENZ");
		App a = new App(primaryStage);
    }

}
