package sockets.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This will be an abstract class that includes an abstract method that has a method that can hold server logic.
 * @author aliu
 *
 */
abstract class RH extends Thread {
    
	private Socket socket;
	private final String name;
    
	RH(Socket socket) {
		this(null, socket);
	}
	
    RH( String name, Socket socket ) {
        this.socket = socket;
        this.name = name;
    }
    
    /**
     * This will hold a lot of the server logic. I'll make helper classes/methods to make the code of this simpler
     */
    @Override
    public void run() {
        try {
            System.out.println( "Received a connection" );
            
            
            //Get input and output streams
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            
            //Write out our header to the client
            out.writeObject(name);
            out.flush();


            //Close our connection
            in.close();
            out.close();
            socket.close();

            System.out.println( "Connection closed" );
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}