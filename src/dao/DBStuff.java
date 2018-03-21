package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBStuff extends Stuff{
	
	public DBStuff(Connection c) throws SQLException {
		super(c);
	}
	
	public int getRowCount(String t) {
		return 0;
	}
	
	public ArrayList<String> getColNames(String t) {
		return null;
	}
	
	public boolean checkConnection() {
		return true;
	}
	
	public boolean contains(String t) {
		return true;
	}
	
	public ArrayList<String> listTables() {
		return null;
	}
}
