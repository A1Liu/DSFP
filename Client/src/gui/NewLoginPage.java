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
	private static Button btn;
	private static int count = 0;
	
	static {{

		pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.getColumnConstraints().add(new ColumnConstraints(100));
        
        title = new Text("Create an Account");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        pane.add(title, 0, count++, 2, 1);

        userName = new Label("User Name:");
        pane.add(userName, 0,count++);

        userNameText = new TextField();
        userNameText.setPromptText("Username");
        userNameText.setPrefWidth(100);
        pane.add(userNameText, 0, count++);
        
        name = new Label("Name:");
        pane.add(name, 0,count++);

        nameText = new TextField();
        nameText.setPromptText("John Doe");
        nameText.setPrefWidth(100);
        pane.add(nameText, 0, count++);
        
        email = new Label("Email:");
        pane.add(email, 0,count++);

        emailText = new TextField();
        emailText.setPromptText("johnDoe@gmail.com");
        emailText.setPrefWidth(800);
        pane.add(emailText, 0, count++);

        password = new Label("Password:");
        pane.add(password, 0, count++);

        pwBox = new PasswordField();
        pwBox.setPromptText("StrongPasswordThatCan'tBeHacked");
        pane.add(pwBox, 0, count++);
		
        password2 = new Label("Confirm Password:");
        pane.add(password2, 0, count++);

        pw2Box = new PasswordField();
        pw2Box.setPromptText("StrongPasswordThatCan'tBeHacked");
        pane.add(pw2Box, 0, count++);
        
        btn = new Button();
		btn.setText("Create Account");
		pane.add(btn, 4,20);

	}}
	
	public NewLoginPage(Controller c) {
		super(pane,c,Const.WIDTH,Const.HEIGHT);
		btn.setOnAction(var -> {
			System.out.println("a");
			getController().loginPage();
		});
	}
}
