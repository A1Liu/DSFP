package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.net.ConnectException;
import java.net.Socket;

public class Const {
	
	
	public static final String PROPERTIES_FILE = "client.properties";
	public static final double WIDTH;
	public static final double HEIGHT;
	public static final int SERVER_PORT;
	public static Integer sessionID;
	
	static {
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(PROPERTIES_FILE));
			WIDTH = Integer.parseInt(props.getProperty("client.width"));
			HEIGHT = Integer.parseInt(props.getProperty("client.height"));
			SERVER_PORT = Integer.parseInt(props.getProperty("server.port"));
			
			Socket test = new Socket(props.getProperty("server.ip"),SERVER_PORT);
			test.close();
			
			String sessID = props.getProperty("server.sessionid");
			
			if (sessID.equals("") || sessID.trim().length() == 0) {
				sessionID = null;
			} else {
				sessionID = Integer.parseInt(sessID);
			}
			
		} catch (FileNotFoundException f) {
			throw new StartUpException("Encountered an error loading information on start up.");
		} catch (NumberFormatException n) {
			throw new StartUpException("Encountered an error loading information on start up.");
		} catch (ConnectException c) {
			throw new StartUpException("Could not connect to server.");
		} catch (IOException e) {
			throw new StartUpException("An unknown error occurred.");
		}
	}
}
