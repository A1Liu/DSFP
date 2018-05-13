package sockets.server;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class represents a handler for individual clients. It establishes a connection, then runs server logic until it needs to disconnect.
 * @author aliu
 *
 */
public abstract class RequestHandler extends Thread {

	private Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	protected RequestHandler(Socket socket) {
		this.socket = socket;
		out = null;
		in = null;
		this.setPriority(MAX_PRIORITY-2);
	}
	
	@Override
	public final void run() {
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			disconnect();
			return;
		}
		
		try {
			execute();
		} catch (InterruptedException i) {
			disconnect();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		disconnect();
	}
	
	public abstract void execute(Object ...args) throws InterruptedException,Exception;
	
	public final void disconnect() {
		try {
			if (out != null)
				out.close();
		} catch (IOException e) {}
		try {
			if (in != null)
				in.close();
		} catch(IOException e) {}
	}
	
	public final void forceQuit() throws InterruptedException {
		disconnect();
		throw new InterruptedException();
	}
}
