package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Terminal extends Thread {
	
	private final BufferedReader cmdLine;
	private final TerminalCommands terminal;
	private boolean running;
	private final Server server;
	
	public Terminal(Server server, Reader input) {
		cmdLine = new BufferedReader(input);
		terminal = new TerminalCommands(this);
		this.server = server;
	}
	
	public void run() {
		running = true;
		System.out.println("Listening for connections.");
		while (running) {
			try {
				terminal.input(cmdLine.readLine());
			} catch (IOException e) {
				running = false;
				e.printStackTrace();
			}
		}
	}
	
	public Server getServer() {
		return server;
	}
}
