package gui.homepage;

import gui.Controller;
import gui.GraphicsException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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
			if(this.getApp().tryConnect()) {
			this.getApp().changeInfo(user);
			errorText.setTextFill(Color.AZURE);
			errorText.setText("Changed username.");
			errorText.setVisible(true);
			} else throw new GraphicsException("Couldn't connect to server.");
		} catch (Exception e) {
			errorText.setTextFill(Color.RED);
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
			errorText.setTextFill(Color.AZURE);
			errorText.setText("Changed email.");
			errorText.setVisible(true);
		} catch (Exception e) {
			errorText.setTextFill(Color.RED);
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
			errorText.setTextFill(Color.AZURE);
			errorText.setText("Changed name.");
			errorText.setVisible(true);
		} catch (Exception e) {
			errorText.setTextFill(Color.RED);
			errorText.setText(e.getMessage());
			errorText.setVisible(true);
		}
	}
	@FXML
	private void changePassword() {
		try {
			String oldPass = this.oldPassField.getText();
			String newPass = this.newPassField.getText();
			this.getApp().tryConnect();
			errorText.setText(this.getApp().changePass(oldPass, newPass));
			errorText.setTextFill(Color.AZURE);
			errorText.setVisible(true);
		} catch (Exception e) {
			errorText.setTextFill(Color.RED);
			errorText.setText(e.getMessage());
			errorText.setVisible(true);
		}
	}
}
