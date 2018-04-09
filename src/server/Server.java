package server;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import dao.DAOException;
import sql.DAOFactory;
import sql.PassDAO;
import sql.UserDAO;

public class Server {
	
	DAOFactory javabase;
	UserDAO userDAO;
	PassDAO passDAO;
	String driverName;
	ThreadHandler userConnections;
	int port;
	
	Server(String driverName, int port) {
		this.driverName = driverName;
		this.port = port;
	}
	
    public static void main(String[] args) throws Exception {
        
    	Server server = new Server("javabase.jdbc", 1100);
    	
    	int port = 1100;
        System.out.println( "Start server on port: " + port );
        
        ThreadHandler threads = new ThreadHandler( port );
        
		BufferedReader consoleLine = new BufferedReader(new InputStreamReader(System.in));
        boolean on = true;
        String input;
        while (on) {
        	input = consoleLine.readLine();
        	
        	switch (input) {
        	case "start":
        		threads.startServer();
        		System.out.println("Server Started!");
        		break;
        	case "stop":
        		threads.stopServer();
        		System.out.println("Server Stopped.");
        		on = false;
        		break;
        	default:
        		System.out.print("That's not a valid command!");
        	}
        }
    	/*
    	// Obtain DAO's
        DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
        System.out.println("DAOFactory successfully obtained: " + javabase);
        UserDAO userDAO = javabase.getUserDAO();
        System.out.println("UserDAO successfully obtained: " + userDAO);
        PassDAO passDAO = javabase.getPassDAO();
        System.out.println("PassDAO successfully obtained: " + passDAO);

        fillDB("lib/userList.txt", userDAO, passDAO);
        */
    }
    
    void execute(String command) {
		execute(command.split(" "));
	}
	
	void execute(String[] command) throws IllegalArgumentException, DAOException {
		
		switch(command[0]) {
		case "start"://start server. First connect to DB, then open to user connections
			javabase = DAOFactory.getInstance(driverName);
	        System.out.println("DAOFactory successfully obtained: " + javabase);
	        userDAO = javabase.getUserDAO();
	        System.out.println("UserDAO successfully obtained: " + userDAO);
	        passDAO = javabase.getPassDAO();
	        System.out.println("PassDAO successfully obtained: " + passDAO);
	        
			break;
		case "stop"://stop server. should also save all working memory and stuff like that to DB before closing connection with DB
			break;
		default:
			throw new IllegalArgumentException("that's not a valid command!");
		}
	}
}