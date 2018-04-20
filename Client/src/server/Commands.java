package server;

import dao.DAOException;
import sql.DAOFactory;
import sql.PassDAO;
import sql.UserDAO;


class Commands {
	
	DAOFactory javabase;
	UserDAO userDAO;
	PassDAO passDAO;
	
	void execute(String command) {
		execute(command.split(" "));
	}
	
	void execute(String[] command) throws IllegalArgumentException, DAOException {
		
		switch(command[0]) {
		case "start"://start server. First connect to DB, then open to user connections
			javabase = DAOFactory.getInstance("javabase.jdbc");
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
