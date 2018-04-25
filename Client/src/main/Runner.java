package main;

import gui.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Runner extends Application {
	
	
	
	public static void main(String... args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) {
        
		primaryStage.setTitle("MEOWMEOWBEENZ");
		Controller window = new Controller(primaryStage);
        Scene scene = new NewLoginPage();
        window.setScene(scene);
        
        window.show();
        
    }
	
	/**
	 * Infinitely loops through the draw and utilities methods.
	 */
	public static void runAnimation() {
		EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				
			}
		};
		Timeline tl = new Timeline(new KeyFrame(Duration.ONE, eh));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
	}
}
