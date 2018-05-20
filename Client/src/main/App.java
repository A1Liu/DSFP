package main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import connection.clientRequests.LoginExistUser;
import connection.clientRequests.LoginNewUser;
import connection.clientRequests.Logout;
import connection.serverPackets.ServerPacket;
import gui.MetaController;
import javafx.stage.Stage;
import server.ClientException;
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
		this.getStage().show();
	}
	/** go to login page */
	public void getLoginPage() {
		this.getPage("gui/login.fxml").setApp(this);}
	
	/** go to new user page */
	public void getNewLoginPage() {
		this.getPage("gui/newLogin.fxml").setApp(this);}
	public void getHomePage() {
		this.getPage("gui/homePage.fxml").setApp(this);
	}
	
	/**
	 * Login as a new user
	 * @param user
	 * @param password
	 * @return
	 */
	public User login(User user, String password) {
		connection.sendPacket(new LoginNewUser(user, password));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			this.user = (User) packet.getData()[0];
			return user;
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
	/**
	 * login as an existing user
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		connection.sendPacket(new LoginExistUser(username, password));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			user = (User) packet.getData()[0];
			return user;
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
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
		//connection.sendPacket(); TODO: logout
		connection.sendPacket(new Logout());
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			user = null;
			this.getLoginPage();
		} else {
			user = null;
			this.getLoginPage();
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	/** check if logged in 
	 * @return true if logged in*/
	public boolean loggedIn() {
		return user == null;}

	@Override
	public void initialize() {
		
	}
}
