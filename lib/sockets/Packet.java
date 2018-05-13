package sockets;

import java.io.Serializable;

public class Packet<T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final double label;
	private final T data;
	
	public Packet(double label, T data) {
		this.label = label;
		this.data = data;
	}

	/**
	 * get data
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * get label
	 * @return label
	 */
	public double getLabel() {
		return label;
	}
	
	
	
}
