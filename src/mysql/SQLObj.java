package mysql;

import java.io.Serializable;
import java.util.ArrayList;

//object that can be made into an SQL table row
public interface SQLObj<E> extends Serializable {

	public ArrayList<Object> toSQLRow();
	
	public E fromSQLRow(ArrayList<Object> fields);
	
}
