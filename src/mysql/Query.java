package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import users.User;


public class Query {
	
	Connection connection;
	
	public Query(Connection c) {
		connection = c;
	}
	
	public boolean addUser(User u) {
		return true;
	}
	
	public User getUser(Long id) {
		return null;
	}
	
	
	
	public void hello() throws SQLException {
	
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
	
}
}
