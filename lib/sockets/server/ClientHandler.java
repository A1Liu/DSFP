package sockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public abstract class ClientHandler extends Thread {

	private ServerSocket server;
	private int port;
	private boolean running;
	private ArrayList<RequestHandler> connections;
	
	protected ClientHandler(int port) {
		this.port = port;
		running = false;
		this.setPriority(MIN_PRIORITY);
		connections = new ArrayList<RequestHandler>();
	}
	
	public void start() {
		try {
			server = new ServerSocket( port );
			super.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void run() {
		running = true;
		System.out.println("Listening for connections.");
		while (running) {
			try {
				RequestHandler requestHandler = newRequestHandler(server.accept());
				requestHandler.start();
				connections.add(requestHandler);
				System.out.println("Connection established!");
			} catch (IOException e) {
				System.out.println("Failed to connect. Retrying...");
			}
		}
	}
	
	public abstract RequestHandler newRequestHandler(Socket socket);
	
	public void disconnectAll() {
		for (RequestHandler request : connections) {
			request.disconnect();
		}
		connections = new ArrayList<RequestHandler>();
	}
	
	public void endAll() {
		for (RequestHandler request : connections) {
			try{request.forceQuit();}catch (InterruptedException i) {}
		}
		connections = new ArrayList<RequestHandler>();
	}
	
	public void offline() {
		this.endAll();
		running = false;
		try {
			server.close();
		} catch (Exception e) {
			
		}
	}
}
