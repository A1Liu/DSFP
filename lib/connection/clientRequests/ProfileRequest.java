package connection.clientRequests;

/**
10 - account information request
	server sends back user object
 * @author aliu
 *
 */
public class ProfileRequest extends ClientRequest {

	private static final long serialVersionUID = 1L;

	protected ProfileRequest() {
		super(10);
	}

}
