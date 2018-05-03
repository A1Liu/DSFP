package gui;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import util.Const;

public class NewLoginPage extends Scene {
	
	static Group group;
	static StackPane stackpane;
	static Button btn;
	
	
	public NewLoginPage() {
		super(stackpane,Const.WIDTH,Const.HEIGHT);
	}
	static {{
		group = new Group();
		stackpane = new StackPane();
		
		btn = new Button();
		btn.setText("Hello!");
		
		btn.setOnAction(var -> {System.out.println("a");});
		
		stackpane.getChildren().add(btn);
	}}
	
	
}
