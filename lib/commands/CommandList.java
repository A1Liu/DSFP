package commands;

import java.util.Arrays;
import java.util.Hashtable;
import static commands.Util.*;

class CommandList {

	private ComTree comTree;//This is the data structure that holds the command hierarchy.
	private Hashtable<Integer,Command> coms;
	private int count;
	
	CommandList(String[] graph) {
		this.addGraph(graph);
	}
	
	CommandList() {
		comTree = new ComTree();
		coms = new Hashtable<Integer,Command>();
		coms.put(-1, new NullC());
		count = 0;
	}
	
	/**
	 * Begins the recursion to create the command tree based off of a formatted String array
	 * @param commands the array of strings that represents the command tree
	 */
	void addGraph(String[] commands) {
		for (int x = 0; x< commands.length; x++) {
			int y = commands[x].lastIndexOf('\t') + 1;
			commands[x] = y + commands[x].trim() + " ";
		}
		
		addGraph(comTree.getRoot(),commands,0,commands.length-1);
		if (!comTree.getRoot().containsChild("help")) {
			while (coms.containsKey(++count)) {}
			comTree.getRoot().addChild("help", count);
			comTree.getRoot().getChild("help").setHelp("This command gives helpful information. You can add command paths as arguments and it will give you help for a specific command.");
			coms.put(count, new HelpC(comTree));
		}
	}
	
	/**
	 * Recursively creates a tree using a string array that represents the tree
	 * @param node The parent node of this recursive call
	 * @param commands the string array to take input from
	 * @param startIndex The initial index of this recursive call
	 * @param endIndex the stopping point of this recursive call
	 */
	private void addGraph(ComTreeNode node, String[] commands, int startIndex, int endIndex) {//Use this to specify object type requirements Class.forName("classStringName");
		int indent = Integer.parseInt(commands[startIndex].substring(0, 1));//what level of the tree are we at?
		
		for (int x = startIndex; x <= endIndex; x++) {//loop through all of the lines in the array. X represents the position the reader is at in the array.
			if(Integer.parseInt(commands[x].substring(0, 1)) == indent) {//If the line we're reading is at the level we're at, then let's add it to the tree
				String[] commandParts = formatCommand(commands[x]);
				String command = commandParts[0];
				addCommand(node,commandParts);
				
				if (x < endIndex) {//If we're not at the end of this call's scope, then this could be a parent node
					if (Integer.parseInt(commands[x+1].substring(0, 1)) > indent) {//If this node is a parent node, call recursion
						ComTreeNode parent = node.getChild(command);//create a reference to the parent node
						int begin = x + 1;//the call should begin right below the parent's line
						
						while ( x < endIndex && Integer.parseInt(commands[x+1].substring(0, 1)) > indent) {
							x++;
						}//And end at the end of the scope of the recursion, or when the next item at this call's level is, whichever comes first.
						addGraph(parent, commands, begin,x);//enter recursion if necessary
					} else if (node.getChild(command).getID() == null){
						node.getChild(command).setID(-1);
					}
				} else if (node.getChild(command).getID() == null)
					node.getChild(command).setID(-1);
			}
		}
	}
	
	private String[] formatCommand(String raw) {
		String command = (raw.substring(1).equals("null") || raw.substring(1).trim().equals("")) ? null : raw.substring(1).trim();
		if (command == null) 
			return new String[] {null};
		String[] out = command.split("\\s*;\\s*",2);
		if (out.length > 1) {
			
			out[1] = (out[1].trim().equals("") ? null : out[1].trim());
			out = Util.append(out[0].split(":",2), out[1]);
		} else {
			out = out[0].split(":",2);
		}
		out[0] = out[0].toLowerCase().replaceAll("\\s","");
		return out;
	}
	
	private void addCommand(ComTreeNode parent, String[] command) {
		
		parent.addChild(command[0]);
		
		if (command.length >= 3) {// in form name:ints - helptext
			if (isNumber(command[1])) {
				parent.getChild(command[0]).setID(Integer.parseInt(command[1]));
				addCommand(Integer.parseInt(command[1]), new NullC());
			}
			parent.getChild(command[0]).setHelp(command[2]);
		} else if (command.length == 2){
			parent.addChild(command[0]);
			if(isNumber(command[1].trim())) {
				parent.getChild(command[0]).setID(Integer.parseInt(command[1].trim()));
				addCommand(Integer.parseInt(command[1].trim()), new NullC());
			} else {
				parent.getChild(command[0]).setHelp(command[1]);
			}
		}
	}
	
	/**
	 * adds an executable command to the command tree
	 * @param path 
	 * @param c
	 */
	void addCommand(String[] path, Command command) {
		if (command == null)
			throw new CommandConfigurationException("The command object cannot be null.");
		while (!coms.containsKey(++count)) {}
		comTree.addPath(path,count);
		coms.put(count, command);
	}
	
	void addCommand(Integer label, Command command) {
		if (command == null)
			throw new CommandConfigurationException("The command object cannot be null.");
		if (label.intValue() < 0)
			throw new IllegalArgumentException("Cannot have a negative ID.");
		coms.put(label,  command);
	}
	
	/**
	 * adds functionality to a point on the command tree. Only adds to points that already exist.
	 * @param label
	 * @param command
	 */
	void setCommand(Integer label, Command command) {
		if (command == null)
			throw new CommandConfigurationException("The command object cannot be null.");
		coms.replace(label, command);
	}
	
	public String toString() {
		return comTree.toString().replaceFirst("\\n", "");
	}
	
	Command get(Integer i) {
		return coms.get(i);
	}
	
	ComTree getTree() {
		return comTree;
	}

}






