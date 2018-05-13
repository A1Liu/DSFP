package server.terminal;

import commands.Commands;
import server.terminal.commands.*;
import static util.DataUtil.prepend;
import static util.IOUtil.readLines;

import java.io.IOException;

public class TCommands extends Commands {
	
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
	
	TCommands(Terminal terminal) {
		addGraph(GRAPH);
		this.terminal = terminal;
		setup();
		
	}
	
	public Terminal getTerminal() {
		return terminal;
	}

	public Object userInput(String[] input) {
		if (terminal.loggedIn()) {
			return this.input(prepend(input,null));
		} else {
			return this.input(input);
		}
	}
	
	public Object rootInput(String[] input) {
		if (terminal.isRoot()) {
			return this.input(prepend(prepend(input,null),null));
		} else {
			return this.input(input);
		}
	}
	
	public Object input(String input) {
		try {
		if (terminal.isRoot()) {
			return rootInput(input.split("\\s+"));
		} else {
			return userInput(input.split("\\s+"));
		} } catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public void setup() {
		
		//login
		//setCommand(0,null);//login with sessionid
		setCommand(1,new LoginExistUser(this));//login with username and password
		setCommand(2,new LoginNewUser(this));//new user
		
		//interact with own account
		//setCommand(10,null);//refresh user information
		//setCommand(11,null);//change username
		//setCommand(12,null);//change email
		//setCommand(13,null);//change password
		
		//interact with other users
		//setCommand(20,null);//search
		//setCommand(21,null);//get info on specified user
		//setCommand(22,null);//rate another user. takes arguments <username> <integer>. If currently viewing a user, then <username> field is optional
		//setCommand(23,null);//friend another user. takes arguments <username>. If currently viewing a user, then <username> field is optional
		
		//logout
		setCommand(98,new Logout(this));//log out
		setCommand(99, new TerminalC(this){@Override public void execute(Object... elist) {getObject().quit();}});
		
		//admin commands: 100-199
		
		//Login and basics
		//setCommand(100,null);//root: login as root user
		//setCommand(101,null);//start: start server
		//setCommand(102,null);//stop: stop server
		//setCommand(103,null);//new: new terminal instance
		//setCommand(103,null);//
		//setCommand(100,null);//
		//setCommand(100,null);//
		//setCommand(100,null);//
		///setCommand(100,null);//
		//setCommand(100,null);//
		//setCommand(101,null);//
		//setCommand(90,null);
		//setCommand(90,null);
		//setCommand(90,null);
	}
	
}
