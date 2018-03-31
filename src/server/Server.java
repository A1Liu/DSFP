package server;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;

import sql.UserDAO;
import sql.DAOFactory;
import sql.PassDAO;

import static server.ServerUtil.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Server {

    public static void main(String[] args) throws Exception {
        
    	int port = 1100;
        System.out.println( "Start server on port: " + port );

        ThreadHandler server = new ThreadHandler( port );
        
		BufferedReader consoleLine = new BufferedReader(new InputStreamReader(System.in));
        boolean on = true;
        String input;
        while (on) {
        	input = consoleLine.readLine();
        	
        	switch (input) {
        	case "start":
        		server.startServer();
        		System.out.println("Server Started!");
        		break;
        	case "stop":
        		server.stopServer();
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
}