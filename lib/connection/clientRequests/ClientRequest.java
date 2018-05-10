package connection.clientRequests;

import connection.Packet;

/**
 * 

 * 
 * @author aliu
 *
 */
public abstract class ClientRequest extends Packet {

	private static final long serialVersionUID = 1L;
	
	protected ClientRequest(int tag) {
		super(tag);
	}
}
