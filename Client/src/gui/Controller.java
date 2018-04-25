package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
	private Stage window;
	
	public Controller(Stage w) {
		this.window = w;
	}
	
	public void setScene(Scene value) {
		window.setScene(value);
	}
	
	public void show() {
		window.show();
	}
}
