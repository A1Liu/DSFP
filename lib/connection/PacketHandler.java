package connection;


import java.io.Serializable;
import sun.misc.Queue;

public class PacketHandler {
	
	private final int port;
	private final Queue<Serializable> queue;
	
	public PacketHandler() {
		this.port = 1100;
		queue = new Queue<Serializable>();
	}
	
	public <T> void addPacket(double label, T data) {
		Packet<T> p = new Packet<T>(label, data);
		queue.enqueue(p);
	}
	
	public void sendPacket() throws InterruptedException {
		Serializable packet = queue.dequeue();
	}
	
}
