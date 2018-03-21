package dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactorySQL {//use preparedstatement instead of statement
	
	
	
	abstract Connection getConnection() throws SQLException;
}
