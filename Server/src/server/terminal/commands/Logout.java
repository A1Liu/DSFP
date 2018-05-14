package server.terminal.commands;

import server.terminal.*;
import server.terminal.Terminal;
import server.terminal.TerminalCommand;

public class Logout extends TerminalCommand {

	public Logout(TerminalCommands terminal) {
		super(terminal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Object... elist) {
		if (getObject().loggedIn()) {
			getObject().logout();
			setOutput("Logged out.");
		} else
			setOutput("Not logged in!");
	}

}
