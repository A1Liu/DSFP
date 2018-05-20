package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.App;
import users.User;

/**
 * 
 * @author aliu
 *
 */
public class TestRunner extends Application {

	public static void main(String... args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws IOException {
		App app = new App(primaryStage);//,new User("alyert","a@liu","albert"));
		
		//app.getNewLoginPage();
//		app.getHomePage();
//		app.getStage().show();
//		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
//		Scene scene = new Scene(root,335,600);
//		primaryStage.setScene(new LoginPage(null));
//		primaryStage.show();
    }

}
