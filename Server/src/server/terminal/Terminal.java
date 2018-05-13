package server.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import server.Server;
import users.User;

public class Terminal extends Thread {
	
	private final BufferedReader cmdLine;
	private final TCommands terminal;
	private volatile boolean running;
	private final Server server;
	private User user;
	private boolean root;
	
	public Terminal(Server server, Reader input) {
		cmdLine = new BufferedReader(input);
		terminal = new TCommands(this);
		this.server = server;
		root = false;
	}
	
	public void run() {
		running = true;
		while (running) {
			try {
				Object print = terminal.input(cmdLine.readLine());
				if (print != null) {
					System.out.println(print.toString());
				}
			} catch (IOException e) {
				running = false;
				e.printStackTrace();
			}
		}
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean loggedIn() {
		return !(user == null || user.getID() == null);
	}
	
	public void setRoot(boolean root) {
		this.root = root;
	}
	
	public boolean isRoot() {
		return root;
	}
	
	public void quit() {
		running = false;
	}
	
	void startServer() {
		server.goOnline();
	}
	
	void stopServer() {
		server.goOffline();
	}
	
	public Server getServer() {
		return server;
	}

	public void logout() {
		user = null;
	}
}
