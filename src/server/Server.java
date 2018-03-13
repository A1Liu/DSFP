package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://192.168.1.5:3306/javabase";
		String username = "java";
		String password = "java";

		System.out.println("Connecting database...");

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		
	}
	
	
	
}



//https://github.com/speedment/speedment/wiki/Tutorial:-Build-a-Social-Network
	//https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database