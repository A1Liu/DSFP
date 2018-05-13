package sockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TH extends Thread {
	private ServerSocket serverSocket;
    private int port;
    private boolean running = false;

    public TH( int port )
    {
    	this.port = port;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket( port );
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        running = false;
        this.interrupt();//If the server is currently listening for a connection with accept(), it stops
    }

    @Override
    public void run() {
        running = true;
        while( running ) {
            try {
                System.out.println( "Listening for a connection" );
                // Call accept() to receive the next connection
                Socket socket = serverSocket.accept();
                // Pass the socket to the RequestHandler thread for processing
                RequestHandler requestHandler = new RequestHandler( socket ) {

					@Override
					public void execute(Object... args) throws InterruptedException, Exception {
						// TODO Auto-generated method stub
						
					}};
                requestHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}