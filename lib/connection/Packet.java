package connection;

import java.io.Serializable;

/**
 * Object that holds information in a way that can be interpreted easily by server and client
 * @author aliu
 *
 * @param <T>
 */
public class Packet<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final double label;
	private final T data;
	
	public Packet(double label, T data) {
		this.label = label;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public double getLabel() {
		return label;
	}
	
}