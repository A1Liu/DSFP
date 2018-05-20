package gui;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import users.User;
import util.Const;

/**
 * 
 * @author aliu
 *
 */
public class NewLogin extends Controller {

	@FXML private TextField username;
	@FXML private TextField email;
	@FXML private TextField name;
	@FXML private PasswordField password;
	@FXML private PasswordField confirmPassword;
	
	public NewLogin() {
		
	}

	@Override
	public void initialize() {
		
	}
	
	@FXML
	private void newLogin() {
		//TODO: logic
		
		
		
		
		
		/*String username = userNameText.getText();
		String email = emailText.getText();
		String name = nameText.getText();
    	String password = pwBox.getText();
    	String password2 = pw2Box.getText();
    	
    	if (!password.equals(password2)) {
    		errorText.setText("Passwords don't match!");
    		errorText.setVisible(true);
    		return;
    	}
    	
    	try {
    		if (!control.getApp().getConnection().isConnected()) {
    			control.getApp().getConnection().run();
    			if (!control.getApp().getConnection().isConnected()) {
    				errorText.setText("Can't connect to server.");
    				errorText.setVisible(true);
    				return;
    			}
    		}
    		
    		control.getApp().setUser(control.getApp().login(new User(username, email, name), password));
    		errorText.setVisible(false);
    		control.homePage();
    	} catch (Exception e) {
    		errorText.setText("Username/Email is already taken.");
    		errorText.setVisible(true);
    	}
    });*/
	}
	
	@FXML
	private void hasAccount() {
		this.getApp().getLoginPage();
	}
	
	
	
}