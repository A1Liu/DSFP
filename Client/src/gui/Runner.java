package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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