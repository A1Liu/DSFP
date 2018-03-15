package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {

	public static void main(String[] args) {
		
		String url = Config.getUrlpreset();
		String username = Config.getUsernamepreset();
		String password = Config.getPasswordpreset();

		System.out.println("Connecting database...");
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    Thread.sleep(1000000);
			connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}