package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import main.App;
import users.User;

public class TestRunner extends Application {

	public static void main(String... args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) {
		primaryStage.setTitle("MEOWMEOWBEENZ");
		App a = new App(primaryStage,new User("USERNAME","EMAIL","NAME"));
		a.startup();
		a.getController().homePage();
    }

}
