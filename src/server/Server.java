package server;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;

import sql.UserDAO;
import sql.DAOFactory;
import sql.PassDAO;

import static server.ServerUtil.*;

public class Server {

    public static void main(String[] args) throws Exception {
        
    	int port = 1100;
        System.out.println( "Start server on port: " + port );

        ThreadHandler server = new ThreadHandler( port );
        server.startServer();

        // Automatically shutdown in 1 minute
        try {
            Thread.sleep( 10000 );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        server.stopServer();
    	
    	// Obtain DAO's
        DAOFactory javabase = DAOFactory.getInstance("javabase.jdbc");
        System.out.println("DAOFactory successfully obtained: " + javabase);
        UserDAO userDAO = javabase.getUserDAO();
        System.out.println("UserDAO successfully obtained: " + userDAO);
        PassDAO passDAO = javabase.getPassDAO();
        System.out.println("PassDAO successfully obtained: " + passDAO);

        fillDB("lib/userList.txt", userDAO, passDAO);
        
        
        
    }
}