package gui2;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller of controllers
 * @author aliu
 *
 */
public abstract class MetaController {

	private FXMLLoader fxmlLoader;
	private Stage window;
	
	public MetaController(Stage primaryStage) {
		this.window = primaryStage;
		fxmlLoader = new FXMLLoader();
		
	}
	
	/**
	 * sets the scene
	 * @param root scene to set
	 */
	public void setScene(Parent root) {
		window.setScene(new Scene(root));
	}
	
	/**
	 * setter for stage
	 * @param window stage
	 */
	void setStage(Stage window) {
		this.window = window;
	}
	/**
	 * getter for stage
	 * @return stage
	 */
	public Stage getStage() {
		return window;
	}
	
	/**
	 * Loads and displays the page at the specified location, and returns the controller object associated with it
	 * @param location location of page's fxml file
	 * @return the controller for that page
	 */
	Controller getPage(String location) {
		try {
			fxmlLoader.setLocation(new File(location).toURI().toURL());
			setScene(fxmlLoader.load());
			Controller controller = (Controller) fxmlLoader.getController();
			fxmlLoader.setLocation(null);
			return controller;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
