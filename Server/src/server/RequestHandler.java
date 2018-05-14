package server;

import java.net.Socket;
import connection.Packet;
import server.terminal.TerminalCommand;

/**
 * This holds a lot of the server communication logic.
 * @author aliu
 *
 */
public class RequestHandler extends RHandler {

	private boolean isAdmin;
	
	protected RequestHandler(Server server, Socket socket) {
		super(server, socket);
		isAdmin = false;
	}

	@Override
	public void execute() throws InterruptedException, Exception {
		 {
				this.start();
				
				while(isRunning()) {
					Object input = getInputStream().readObject();
					if (input instanceof Packet) {
						Packet packet = (Packet) input;
						if (packet.getTag() > 99) {//They're trying to use an admin command
							if (isAdmin) {
								
							} else {
								//send error message: not authorized to use that command
							}
						} else {//not trying to use admin command
							TerminalCommand command = (TerminalCommand) getCommands().getCommand(packet.getTag());
							if (command.checkParams(packet.getData())) {
								command.execute(packet.getData());	
								getOutputStream().writeObject(command.getOutput());
								getOutputStream().flush();
							} else {
								getOutputStream().writeObject("Error");
								getOutputStream().flush();
							}
						}
					} else {//Not talking to a client that we recognize
						disconnect();
						quit();
					}
				}
			}
	}

}
