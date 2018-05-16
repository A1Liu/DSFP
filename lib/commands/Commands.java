package commands;

import java.util.Arrays;

/**
 *<pre>
 * Takes formatted command graph, and creates a graph of commands
 * 
 * Format:
 * 
 * 	Command
 * 		SubCommand:2; Words after the semicolon are considered help text, and can be viewed by the user using the 'help' command.
 * 		SubCommand2:4; The integer after the colon specifies a key to be used when creating command objects using setCommand().
 * 		SubCommand3:4; The integer isn't necessary, but it helps make assigning commands to endpoints in the tree easier.
 * 			SubSubCommand:-3; the integer can't be negative. This will throw a CommandConfiguration exception
 * 			SubSubCommand:2; Writing the same command name for 2 commands that are siblings in the tree results in the combining of both. The help text and integer ID of the last one are used
 * 			SubSubCommand:1; But the command below won't overrwrite the help text, because it doesn't have helpText.
 * 			SubSubCommand
 * 			SubSubCommand; However, if you include a semicolon, it will overrwrite the help text, like the one below
 *			SubSubCommand;
 * 			SubSubCommand:3; Even though the -3 is overriden by 2 in the above commands, -3 is checked first, so an exception will be thrown before the interpreter reaches 2
 * 	help; adding the help command here overrides the default help command
 * 	Null; typing null anywhere in the tree creates a null node. This can't be accessed by the user, so use these to make hidden commands accessible only by code
 *</pre> 
 * @author aliu
 *
 */
public class Commands {
	
	private CommandList comList;
	
	public Commands() {
		comList = new CommandList();
	}
	
	public Object input(String in) {
		return input(in.split("\\s+"));
	}
	
	/**
	 * takes an input and executes a command based off of it. Should traverse as far as it can down the command tree and then take the rest of the input as parameters
	 * @param in the input string to take
	 */
	public final Object input(String[] in) {
		try {
		int counter = 0;
		ComTreeNode current = comList.getTree().getRoot();
		while(counter < in.length && current.containsChild(in[counter])) {
			current = current.getChild(in[counter]);
			counter++;
		}
		if (current == comList.getTree().getRoot()) {
			throw new CommandException("That's not a valid command!");
		} else if (current.getID() == null && current.getChildren().size() != 0) {
			String comPath = "";
			for (int x = 0; x < counter; x++) {
				comPath += in[x] + " ";
			}
			comPath = comPath.trim();
			if (counter < in.length) {
				throw new CommandException("'" + in[counter] + "' is not a recognized subcommand of " + comPath);	
			} else {
				throw new CommandException("'" + comPath + "' is not a complete command. Please pass more parameters.");
			}
		} else {
			return comList.get(current.getID()).execute(Arrays.copyOfRange(in, counter, in.length));
		}
		} catch (Exception e) {
			if (e instanceof CommandException)
				throw e;
			else throw new CommandException(e.getMessage(),e);
		}
	}
	
	/**
	 * Creates a command tree from a formatted String array
	 * @param commands the array of strings that represents the command tree
	 */
	public void addGraph(String[] commands) {
		comList.addGraph(commands);
	}
	
	/**
	 * adds functionality to a point on the command tree. Only adds to points that already exist.
	 * @param label
	 * @param command
	 */
	public void setCommand(Integer label, Command command) {
		comList.setCommand(label, command);
	}
	
	/**
	 * adds an executable command to the command tree
	 * @param path 
	 * @param c
	 */
	public void addCommand(String[] path, Command command) {
		comList.addCommand(path, command);
	}
	
	/**
	 * Returns a command. Use primarily when a command tree isn't being used.
	 * @param label integer identifier of command
	 * @return the command
	 */
	protected Command getCommand(Integer label) {
		return comList.get(label);
	}
	
	/**
	 *  Maps a command to an integer label without checking whether it's accessible to the command tree. Use this when a terminal isn't being used.
	 * @param label integer label of command
	 * @param command command object
	 */
	protected void addCommand(Integer label, Command command) {
		comList.addCommand(label, command);
	}
	
	/**
	 * Outputs the annotated structure of the command tree. Does not include help messages.
	 */
	public String toString() {
		return comList.toString();
	}
}
