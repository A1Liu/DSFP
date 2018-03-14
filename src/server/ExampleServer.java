package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleServer {

	private ExampleServer() {
		
	}
	
	public static void mainExample() {
		
		String url = Config.getUrlpreset();
		String username = Config.getUsernamepreset();
		String password = Config.getPasswordpreset();

		System.out.println("Connecting database...");
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		
			System.out.println("Database connected!");
		    
		    Statement statement = connection.createStatement();//makes a statement object

	         // Step 3: Execute a SQL SELECT query, the query result
	         //  is returned in a 'ResultSet' object.
	         String selectQuery = "select title, price, qty from books";//creates query
	         System.out.println("The SQL query is: " + selectQuery); // Echo For debugging
	         System.out.println();
	 
	         ResultSet results = statement.executeQuery(selectQuery);//executes query
	 
	         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	         System.out.println("The records selected are:");
	         int rowCount = 0;
	         while(results.next()) {   // Move the cursor to the next row, return false if no more row
	            String title = results.getString("title");//gets information from the result of the query. The string is the column name
	            double price = results.getDouble("price");
	            int    qty   = results.getInt("qty");
	            System.out.println(title + ", " + price + ", " + qty);
	            ++rowCount;
	         }
	         System.out.println("Total number of records = " + rowCount);
	         
	         
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
