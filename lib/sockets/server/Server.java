package sockets.server;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;


/**
 * The Server has 2 parts:
 * 
 * Client Thread handling, and Server side threads.
 * 
 * Later subclasses will implement database stuff as well.
 * 
 * @author aliu
 *
 */
public abstract class Server extends Thread {

	ClientHandler clientHandler;
	
	protected Server(ClientHandler threadHandler) {
		this.clientHandler = threadHandler;
	}
	
    public synchronized void start() {
    	goOnline();
    	this.run();
    }
    
    /**
     * Non-Client related run tasks.
     */
    public abstract void run();
    
    public void stopServer() {
    	goOffline();
    }
    
    public synchronized final void goOnline() {
    	clientHandler.start();
    }
    
    public synchronized final void goOffline() {
    	clientHandler.endAll();
    	try {
    	clientHandler.offline();
    	} catch (Exception e) {
    		
    	}
    }
}