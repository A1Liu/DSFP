package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public abstract class Stuff {

	private Connection con;
	private Statement stmt;
	
	public Stuff(Connection c) throws SQLException {
		con = c;
		stmt = con.createStatement();
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public Statement getStatement() {
		return stmt;
	}
	
}
