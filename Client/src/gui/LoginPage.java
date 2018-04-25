package gui;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
import javafx.scene.text.*;
import main.Cache;
import util.Const;

class LoginPage extends Page {
	
	private static GridPane grid;
	private static Text scenetitle;
	private static Label userName;
	private static TextField userTextField;
	private static Label pw;
	private static PasswordField pwBox;
	private static Button btn;
	private static HBox hbBtn;
	private final static Text actiontarget;
	
	static {{
		grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        scenetitle = new Text("Sign In");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        userTextField.setPromptText("Username");
        grid.add(userTextField, 1, 1);

        pw = new Label("Password:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        pwBox.setPromptText("Password");
        grid.add(pwBox, 1, 2);
        
        //Sign in button
        btn = new Button("Sign in");
        hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	/*
            	 * Get username and password with these two methods, then pass then to main
            	 * userTextField.getText();
            	 * pwBox.getText();
            	 * 
            	 * 
            	 */
            }
        });
	}}
	
	public LoginPage(Controller c) {
		super(grid,c,Const.WIDTH,Const.HEIGHT);
	}
	
	
	
}
