package gui;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import util.Const;


class NewLoginPage extends GridPane {
	
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
	
	{
        this.setAlignment(Pos.TOP_LEFT);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        this.getColumnConstraints().add(new ColumnConstraints(200));
        this.getColumnConstraints().add(new ColumnConstraints(50));
        
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
		
		this.add(title, 0, 0, 2, 1);        
        this.add(userName, 0,1);
        this.add(userNameText, 0, 2,2,1);
        this.add(name, 0,3);
		this.add(nameText, 0, 4,2,1);
		this.add(email, 0,5);
		this.add(emailText, 0, 6,2,1);
		this.add(password, 0, 7);
		this.add(pwBox, 0, 8,2,1);
		this.add(password2, 0, 9);
		this.add(pw2Box, 0, 10,2,1);
        this.add(placeholder,0,11);
		this.add(btn, 1,12,2,1);
        this.setPrefHeight(100);
		
	}
	
	public NewLoginPage(Controller c) {
		btn.setOnAction(var -> {
			/*
			 * Communicate with server 
			 */
		});
	}
}
