package server.commands;

import commands.ObjParamC;
import server.TerminalCommands;

public abstract class TerminalCommand extends ObjParamC<TerminalCommands> {

	public TerminalCommand(TerminalCommands object, String[] strings) {
		super(object, strings);
	}
}
