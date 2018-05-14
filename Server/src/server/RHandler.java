package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import connection.Packet;

/**
 * This class represents a request handler... or at least, part of it. I broke up the request handler into two classes to make it easier to read.
 * @author aliu
 *
 */
public abstract class RHandler extends BaseRequestHandler implements Runnable {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	protected RHandler(Server server, Socket socket) {
		super(server);
		this.socket = socket;
		out = null;
		in = null;
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
	
	/**
	 * Server Logic.
	 * @throws InterruptedException if thread gets interrupted
	 * @throws Exception for general case exceptions
	 */
	public abstract void execute() throws InterruptedException,Exception;
	
	/**
	 * gets the outputStream
	 * @return output stream
	 */
	public final ObjectOutputStream getOutputStream() {
		return out;
	}
	
	/**
	 * gets the input stream
	 * @return input stream
	 */
	public final ObjectInputStream getInputStream() {
		return in;
	}
	
	/**
	 * disconnects from client
	 */
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
	
	/**
	 * forces this thread to quit.
	 * @throws InterruptedException to kill the thread
	 */
	public final void forceQuit() throws InterruptedException {
		disconnect();
		throw new InterruptedException();
	}
}