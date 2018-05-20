package gui2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.stage.Stage;
import server.Connection;
import users.User;

/**
 * handles GUI logic, decides what is displayed, etc.
 * @author liu_albert
 *
 */
public class App extends MetaController {

	private Connection connection;
	private User user;
	
	public App () {
		this(new Stage());
	}
	
	public App (Stage primaryStage) {
		this(primaryStage, null);
		startup();
	}
	
	public App (Stage primaryStage, User user) {
		super(primaryStage);
		this.user = user;
		connection = new Connection();
	}
	
	public void startup() {
		connection.start();
		this.getLoginPage();
	}
	/** go to login page */
	public void getLoginPage() {
		this.getPage("gui/login.fxml").setApp(this);}
	
	/** go to new user page */
	public void getNewLoginPage() {
		this.getPage("gui/newLogin.fxml").setApp(this);}
	
	/** getter for connection
	 * @return connection object*/
	public Connection getConnection() {
		return connection;}
	/** getter for user 
	 * @return user*/
	public User getUser() {
		return user;}
	/** setter for user 
	 * @param user user to set*/
	public void setUser(User u) {
		this.user = u;}
	/** log out of account */
	public void logout() {
		user = null;}
	/** check if logged in 
	 * @return true if logged in*/
	public boolean loggedIn() {
		return user == null;}
}
