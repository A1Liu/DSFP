package server.terminal.commands.admin;

import server.terminal.TerminalCommands;
import server.terminal.TerminalCommand;

public class AdminLogout extends TerminalCommand {

	public AdminLogout(TerminalCommands terminal) {
		super(terminal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Object... elist) {
		getObject().setRoot(false);
		getObject().getCommands().getCommand(1).execute();
		setOutput("Logged out of root account.");
	}

}
