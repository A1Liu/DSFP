package main;

import gui.LoginPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {
	
	
	
	public static void main(String... args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) {
        
		primaryStage.setTitle("JavaFX Welcome");
        Scene scene = new LoginPage();
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
}
