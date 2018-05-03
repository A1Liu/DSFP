package server;

public class ShortPacket extends Packet<Integer> {

	private static final long serialVersionUID = 1L;

	public ShortPacket(double label, Integer data) {
		super(label, data);
	}
}
