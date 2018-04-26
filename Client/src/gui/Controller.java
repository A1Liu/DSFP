package gui;

import javafx.stage.Stage;
import server.*;

/**
 * handles instantiation and transition between pages
 * @author liu_albert
 *
 */
public class Controller {

	private Stage window;
	
	public Controller(Stage primaryStage) {
		this.window = primaryStage;
	}
	
	
	//Methods to set the scene and show it.
	public void loginPage() {window.setScene(new LoginPage(this));}
	public void newLoginPage() {window.setScene(new NewLoginPage(this));}
	public void show() {window.show();}
}
