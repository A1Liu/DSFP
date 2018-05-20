package gui.homepage;

import connection.clientRequests.*;
import gui.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import users.User;

public class Settings extends Controller {

	@FXML private TextField username;
	@FXML private TextField email;
	@FXML private TextField name;
	@FXML private PasswordField oldPassField;
	@FXML private PasswordField newPassField;
	@FXML private Label errorText;
	
	public Settings() {

	}

	@Override
	public void initialize() {
		
	}
	
	@FXML
	private void changeUsername() {
		try {
			String username = this.username.getText();
			User user = new User(null, this.getApp().getUser());
			user.setUsername(username);
			System.out.println(user);
			System.out.println(this.getApp().tryConnect());
			this.getApp().changeInfo(user);
			errorText.setVisible(false);
		} catch (Exception e) {
			errorText.setText(e.getMessage());
			errorText.setVisible(true);
		}
	}
	
	@FXML
	private void changeEmail() {
		try {
			String email = this.email.getText();
			User user = new User(null, this.getApp().getUser());
			user.setEmail(email);
			this.getApp().tryConnect();
			this.getApp().changeInfo(user);
			errorText.setVisible(false);
		} catch (Exception e) {
			errorText.setText(e.getMessage());
			errorText.setVisible(true);
		}
	}
	@FXML
	private void changeName() {
		try {
			String name = this.name.getText();
			User user = new User(null, this.getApp().getUser());
			user.setName(name);
			this.getApp().tryConnect();
			this.getApp().changeInfo(user);
			errorText.setVisible(false);
		} catch (Exception e) {
			errorText.setText(e.getMessage());
			errorText.setVisible(true);
		}
	}
	@FXML
	private void changePassword() {
		
	}
}
