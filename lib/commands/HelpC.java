package commands;

/**
 * This class represents a command that outputs a guide to a command tree.
 * @author aliu
 *
 */
public class HelpC implements Command {

	private ComTree commands;
	
	public HelpC(ComTree commands) {
		this.commands = commands;
	}
	
	
	
	@Override
	public void execute(Object... elist) {
		
		String[] path = (String[]) elist;
		boolean done = false;
		boolean listSubs = false;
		ComTreeNode current = commands.getRoot();
		for (String element : path) {
			if (!done) {//Traverses down the tree until it can't anymore. Note that a single wrong name will cause the help method to stop and print out an error message.
				if (current.containsChild(element))
					current = current.getChild(element);
				else if (element.endsWith("...") && current.containsChild(element.replace("...", ""))) {
					current = current.getChild(element.replace("...", ""));
					listSubs = true;
					done = true;
				} else if (element.equals("...")) {
					listSubs = true;
					done = true;
				} else {
					if (current == commands.getRoot()) {
						System.out.printf("NOTE: '%s' is not a valid command. For a list of valid commands and their explanations, type 'help'.%n",element);
						return;
					} else {
						System.out.printf("NOTE: '%s' is not a valid subcommand of '%s'.%n",element,current.getName());
					}
				}
			}
			else	{
				done = true;
			}
		}
		
		if (current == commands.getRoot()) {//If there were no parameters given
			System.out.println("Command List: ");
			for (ComTreeNode node : current.getChildren()) {
				String name = node.getName();
				String help = node.getHelp() == null ? "'" + node.getName() + "' command." : node.getHelp();
				System.out.printf("  %8s %s%n",name+":",help);
			}
		} else if (!listSubs) {//if the parameters were given but the user didn't ask for subcommands.
			String name = current.getName();
			String help = current.getHelp() == null ? "'" + current.getName() + "' command." : current.getHelp();
			System.out.printf("%s %s%n",name+":",help);
			System.out.println("Type '...' at the end of the last command to get a list of available subcommands, along with help for each.");
		} else {//if the parameters were given with a '...' at the end, which means that subcommands should also be outputted
			if (current.getChildren().size() == 0) {
				System.out.printf("'%s' doesn't have any subcommands.");
				return;
			}
			
			System.out.printf("Subcommands of'%s': %n",current.getName());
			for (ComTreeNode node : current.getChildren()) {
				String name = node.getName();
				String help = node.getHelp() == null ? "'" + node.getName() + "' command." : node.getHelp();
				System.out.printf("  %8s %s%n",name+":",help);
			}
			
		}

		
		
		
	}

}
