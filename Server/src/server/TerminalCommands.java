package server;

import commands.Commands;
import static util.IOUtil.readLines;

import java.io.IOException;

public class TerminalCommands extends Commands {
	
	private final static String[] GRAPH;
	private final Terminal terminal;
	
	static {
		String[] a = new String[1];
		try {
			a = readLines("Properties/commands.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		GRAPH = a;
	}
	
	public TerminalCommands(Terminal terminal) {
		addGraph(GRAPH);
		this.terminal = terminal;
	}
	
}
