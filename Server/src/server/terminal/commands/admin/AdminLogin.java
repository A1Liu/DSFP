package server.terminal.commands.admin;

import server.terminal.TerminalCommand;
import server.terminal.TerminalCommands;

public class AdminLogin extends TerminalCommand {

	public AdminLogin(TerminalCommands terminal, String... strings) {
		super(terminal, strings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Object... elist) {
		getObject().setRoot(true);
		setOutput("Logged in as server admin.");
	}

}
