package server;

import java.net.Socket;

import sockets.server.RequestHandler;

public class ClientHandler extends sockets.server.ClientHandler {

	ClientHandler(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RequestHandler newRequestHandler(Socket socket) {
		// TODO Auto-generated method stub
		return null;
	}

}
