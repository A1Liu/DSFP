package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import dao.PassDAO;
import dao.UserDAO;
import users.User;

public class ServerUtil {

	public static void fillDB(String document, UserDAO userDAO, PassDAO passDAO) throws IOException {
		FileReader readFile = new FileReader(document); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine();
		int line = 1;
		ArrayList<String> inputRow;
		while(inputString != null) {
			inputRow = new ArrayList<String>(Arrays.asList(inputString.split(",")));
			if(inputRow.size() > 2) {
				User albert = new User();
				albert.setUsername(inputRow.get(0));
				albert.setEmail(inputRow.get(1));
				inputRow.remove(0);
				inputRow.remove(0);
				while (inputRow.size()>1) {
					if(inputRow.get(0).contains("/")) {
						try {
							albert.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(inputRow.get(0)));
							inputRow.remove(0);
						} catch (ParseException e) {inputRow.remove(0);}
					} else {
						if (albert.getFirst() != null) {
							albert.setFirst(inputRow.get(0));
							inputRow.remove(0);
						} else {
							albert.setLast(inputRow.get(0));
							inputRow.remove(0);
						}	
					}	
				}
			userDAO.create(albert);
			passDAO.createPass(albert.getID(), inputRow.get(0));
			} else {
				System.out.println("Line " + line + "skipped: Too few arguments.");
			}
			inputString = inFile.readLine();
			line++;
		}
		inFile.close();
	}

	
}
