package server.terminal.commands;

import server.terminal.TerminalCommand;
import users.User;
import server.terminal.TerminalCommands;

public class LoginExistUser extends TerminalCommand {

	public LoginExistUser(TerminalCommands terminal) {
		super(terminal, "String", "String");
	}

	@Override
	public void execute(Object... elist) {
		User user = getObject().getServer().getLoginDAO().login((String) elist[0], (String) elist[1]);
		user.setID((long) -1);
		getObject().setUser(user);
		setOutput(user);
	}

}
