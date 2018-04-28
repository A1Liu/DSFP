package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.App;
import static util.Const.*;

/**
 * handles GUI logic
 * @author liu_albert
 *
 */
public class Controller {

	private Stage window;
	
	public Controller(App application) {
		this.window = application.getStage();
	}
	
	//Methods to set the scene and show it.
	public void display(Parent root) {
		window.setScene(new Scene(root, WIDTH, HEIGHT));
	}
	public void loginPage() {window.setScene(new LoginPage(this));}
	public void newLoginPage() {window.setScene(new NewLoginPage(this));}
	public void show() {window.show();}
}
