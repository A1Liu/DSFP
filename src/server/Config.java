package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {
	//Local:192.168.1.5
	//IPv4: 71.112.186.101
	private static final String urlPreset = "jdbc:mysql://172.27.23.143:3306/javabase";//canyouseeme.org
	private static final String usernamePreset = "java";
	private static final String passwordPreset = "java";
	
	private String url = "jdbc:mysql://192.168.1.5:3306/javabase";
	private String username = "java";
	private String password = "java";
	
	/**
	 * Reads the pre-formatted config file
	 * @param input name of file to be read
	 * @throws IOException Throws an exception if there's a problem reading the file
	 */
	public void readFile(String input) throws IOException {

		FileReader readFile = new FileReader(input); //or input.readLine( ) if from prompt
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine();
		
		String[] fields = inputString.split(" ",3);
			
		username = fields[0];
		password = fields[1];
		url = fields[2];		
		inFile.close();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static String getUrlpreset() {
		return urlPreset;
	}

	public static String getUsernamepreset() {
		return usernamePreset;
	}

	public static String getPasswordpreset() {
		return passwordPreset;
	}
	
	
	
}
