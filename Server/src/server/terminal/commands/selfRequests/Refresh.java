package server.terminal.commands.selfRequests;

import server.terminal.TerminalCommand;
import users.User;
import server.terminal.TerminalCommands;

public class Refresh extends TerminalCommand {

	public Refresh(TerminalCommands terminal) {
		super(terminal);
	}

	@Override
	public void execute(Object... elist) {
		User user = getObject().getServer().getLoginDAO().getUserDAO().find(getObject().getUser().getUsername());
		getObject().setUser(user);
		user.setID(null);
		setOutput(user);
	}

}
