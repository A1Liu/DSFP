package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class TableDAO<E extends SQLObj<E>> extends DBDAO {
	
	private String tableName;
	
	public TableDAO(Connection c, String table) throws SQLException {
		super(c);
		tableName = table;
	}
	
	public boolean addRow(E e) {
		return true;
	}
	
	public boolean deleteRow(Long id) {
		return true;
	}
	
	public E getRow(Long id) {
		return null;
	}
	
	public boolean checkCompatible() {
		return true;
	}
	
	private ResultSet executeStatement(String statement) {
		return null;
		
	}
	
	private ArrayList<E> getResults(ResultSet r) {
		return null;
	}
	
	private E getResultRow(int row) {
		return null;
	}
	
	public void hello() throws SQLException {
	
	
	
    // Step 3: Execute a SQL SELECT query, the query result
    //  is returned in a 'ResultSet' object.
    String selectQuery = "select title, price, qty from books";//creates query
    System.out.println("The SQL query is: " + selectQuery); // Echo For debugging
    System.out.println();

    ResultSet results = getStatement().executeQuery(selectQuery);//executes query

    // Step 4: Process the ResultSet by scrolling the cursor forward via next().
    System.out.println("The records selected are:");
    while(results.next()) {   // Move the cursor to the next row, return false if no more row
       String title = results.getString("title");//gets information from the result of the query. The string is the column name
       double price = results.getDouble("price");
       int    qty   = results.getInt("qty");
       System.out.println(title + ", " + price + ", " + qty);
    }
	
}
}
