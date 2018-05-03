package main;

import java.net.Socket;

import gui.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Contains the app logic for a single instance of the application.
 * Has methods to connect back end to front end
 * @author Alyer
 *
 */
public class App {
	
	private final Stage window;
	private final Controller gui;
	private Socket server;
	
	public App() {
		this(new Stage());
	}
	
	public App(Stage primaryStage) {
		window = primaryStage;
		gui = new Controller(this);
		startup();
	}
	
	public void startup() {
		gui.newLoginPage();
        gui.show();
	}
	
	public Stage getStage() {
		return window;
	}
	
	
	
}
