package server.terminal;

import commands.ObjParamC;

public abstract class TerminalC extends ObjParamC<Terminal> {

	public TerminalC(TCommands terminal, String... strings) {
		super(terminal.getTerminal(), strings);
	}
}
