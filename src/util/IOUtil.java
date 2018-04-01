package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IOUtil {

	private IOUtil() {}
	
	/**
	 * checks if a string is an integer
	 * @param in string to test
	 * @return true if the string can be parsed to an integer
	 */
	public static boolean isNumber(String in) {
		try{
			Integer.parseInt(in);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Reads the file that is given and creates a list from it
	 * @param input name of file to be read
	 * @throws IOException Throws an exception if there's a problem reading the file
	 */
	public static ArrayList<String> readFile(String input) throws IOException {

		FileReader readFile = new FileReader(input); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		ArrayList<String> output = new ArrayList<String>();
		
		String inputString = inFile.readLine();
		while(inputString != null) {
			
			output.add(inputString);
			
			inputString = inFile.readLine();
		}
		inFile.close();
		return output;
	}
	
	
}
