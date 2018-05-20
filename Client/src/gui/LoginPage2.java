package gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginPage2 extends Page {

	public LoginPage2(Controller control) {
		super(null, control);
		try {
			this.setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
