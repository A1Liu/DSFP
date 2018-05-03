package server;

import java.io.Serializable;

public class Packet<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private T data;
	
	public Packet(String label, T data) {
		this.label = label;
		this.data = data;
	}
	
}
