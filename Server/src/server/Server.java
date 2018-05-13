package server;

import java.io.InputStreamReader;

import server.daoWrapper.LoginDAO;
import server.terminal.Terminal;
import sql.DAOFactory;

public class Server extends sockets.server.Server {

	private DAOFactory database;
	private LoginDAO logindao;
	Terminal terminal;
	
	public Server(int port) {
		super(new ClientHandler(port));
		database = DAOFactory.getInstance("javabase.jdbc");
		logindao = new LoginDAO(database);
	}
	
	public synchronized void start() {
		this.run();
	}

	@Override
	public void run() {
		terminal = new Terminal(this, new InputStreamReader(System.in));
		terminal.start();
		
	}
	
	public void stopServer() {
		terminal.quit();
		super.stopServer();
	}
	
	public LoginDAO getLoginDAO() {
		return logindao;
	}
	
}
