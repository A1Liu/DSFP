package server;

import dao.DAOException;


class Commands {
	
	private Commands() {
		
	}
	
	static void execute(String command) throws IllegalArgumentException, DAOException {
		
		switch(command) {
		case "start":
			break;
		case "stop":
			break;
		default:
		}
	}
	
}
