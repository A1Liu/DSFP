package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.*;
import static util.Const.*;

/**
 * handles instantiation and transition between pages
 * @author liu_albert
 *
 */
public class Controller {

	private Stage window;
	
	public Controller() {
		this(new Stage());
	}
	
	public Controller(Stage primaryStage) {
		this.window = primaryStage;
	}
	
	
	//Methods to set the scene and show it.
	public void display(Parent root) {
		window.setScene(new Scene(root, WIDTH, HEIGHT));
	}
	public void loginPage() {window.setScene(new LoginPage(this));}
	public void newLoginPage() {window.setScene(new NewLoginPage(this));}
	public void show() {window.show();}
}
