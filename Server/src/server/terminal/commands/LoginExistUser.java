package server.terminal.commands;

import server.terminal.TerminalC;
import users.User;
import server.terminal.TCommands;

public class LoginExistUser extends TerminalC {

	public LoginExistUser(TCommands terminal) {
		super(terminal, "String", "String");
	}

	@Override
	public void execute(Object... elist) {
		User user = getObject().getServer().getLoginDAO().login((String) elist[0], (String) elist[1]);
		getObject().setUser(user);
		setOutput(user);
	}

}
