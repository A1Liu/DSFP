package gui;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import util.Const;


class NewLoginPage extends Page {
	
	private static GridPane pane;
	private static Text title;
	private static Label userName;
	private static TextField userNameText;
	private static Label name;
	private static TextField nameText;
	private static Label email;
	private static TextField emailText;
	private static Label password;
	private static PasswordField pwBox;
	private static Label password2;
	private static PasswordField pw2Box;
	private static Text placeholder;
	private static Button btn;
	private static int count = 0;
	
	static {{

		pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.getColumnConstraints().add(new ColumnConstraints(200));
        pane.getColumnConstraints().add(new ColumnConstraints(50));
        
        title = new Text("Create an Account");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        userName = new Label("User Name:");
        
        userNameText = new TextField();
        userNameText.setPromptText("Username");
        
        name = new Label("Name:");
        
        nameText = new TextField();
        nameText.setPromptText("John Doe");

        email = new Label("Email:");

        emailText = new TextField();
        emailText.setPromptText("johnDoe@gmail.com");
        
        password = new Label("Password:");
        
        pwBox = new PasswordField();
        pwBox.setPromptText("StrongPasswordThatCan'tBeHacked");
        
        password2 = new Label("Confirm Password:");

        pw2Box = new PasswordField();
        pw2Box.setPromptText("StrongPasswordThatCan'tBeHacked");
      
        placeholder = new Text("");
        
        btn = new Button();
		btn.setText("Create Account");
		
		pane.add(title, 0, 0, 2, 1);        
        pane.add(userName, 0,1);
        pane.add(userNameText, 0, 2,2,1);
        pane.add(name, 0,3);
		pane.add(nameText, 0, 4,2,1);
		pane.add(email, 0,5);
		pane.add(emailText, 0, 6,2,1);
		pane.add(password, 0, 7);
		pane.add(pwBox, 0, 8,2,1);
		pane.add(password2, 0, 9);
		pane.add(pw2Box, 0, 10,2,1);
        pane.add(placeholder,0,11);
		pane.add(btn, 1,12,2,1);
        pane.setPrefHeight(100);
		
	}}
	
	public NewLoginPage(Controller c) {
		super(pane,c);
		btn.setOnAction(var -> {
			/*
			 * Communicate with server 
			 */
		});
	}
}
