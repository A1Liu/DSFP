package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

public class ErrorScreen extends GridPane {

	private static Text message;
	private static Rectangle box;
	private static StackPane container;
	
	static {
		
		box = new Rectangle(300, 250, Paint.valueOf("0000ff"));
		container = new StackPane();
		container.getChildren().add(box);
		
		message = new Text("Error");
		message.setFont(new Font(100));
		container.getChildren().add(message);
	}
	
	public ErrorScreen() {
		this.setup();
	}
	
	private void setup() {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(25,25,25,25));
		this.add(container,0,0);
	}
	
}
