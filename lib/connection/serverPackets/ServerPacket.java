package connection.serverPackets;

import connection.Packet;

/**
 * Object that holds information in a way that can be interpreted easily by server and client
 * @author aliu
 *
 * @param <T>
 */
public class ServerPacket<T> extends Packet {
	
	private static final long serialVersionUID = 1L;
	private final T data;
	
	public ServerPacket(int label, T data) {
		super(label);
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
}