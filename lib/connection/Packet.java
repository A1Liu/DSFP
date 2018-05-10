package connection;

import java.io.Serializable;

public abstract class Packet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int tag;
	
	protected Packet(int tag) {
		this.tag = tag;
	}
	
	public int getTag() {
		return tag;
	}
}
