package connection;

import java.io.Serializable;

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