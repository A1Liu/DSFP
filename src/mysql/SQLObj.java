package mysql;

import java.io.Serializable;
import java.util.ArrayList;

public interface SQLObj<E> extends Serializable {

	public ArrayList<Object> toSQLRow();
	
	public E fromSQLRow(ArrayList<Object> fields);
	
}
