package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;

public class ErrorScreen extends GridPane {

	private static Text message;
	
	static {
		message = new Text("Error");
		
	}
	
	public ErrorScreen() {
		this.setPadding(new Insets(25,25,25,25));
		this.add(message,0,0);
	}
	
}
