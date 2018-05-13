package server;

import sql.DAOFactory;

public class Server extends Thread {

	private int port;
	private DAOFactory database;
	
	public Server(int port) {
		this.port = port;
		database = DAOFactory.getInstance("javabase.jdbc");
	}
	
	public synchronized void start() {
		
	}
	
	public synchronized void hello() {
		
	}
	
}
