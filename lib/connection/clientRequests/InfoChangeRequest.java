package connection.clientRequests;

/**
11 - change of email request
	packet contains email
	server sends back error message or success message
12 - change of username request
	packet contains new username
	server sends back error message or success message
13 - change of password request
	packet contains old password and new password
	server sends back error message or success message
 * @author aliu
 *
 */
public class InfoChangeRequest extends ClientRequest {

	private static final long serialVersionUID = 1L;
	private final String data;
	private final String confimation;
	
	public InfoChangeRequest(String data, String confirmation) {
		super(13);
		this.data = data;
		this.confimation = confirmation;
	}
	
	public InfoChangeRequest(String data) {
		super(data.contains("@") ? 11 : 12);
		this.data = data;
		this.confimation = null;
	}

	public String getData() {
		return data;
	}

	public String getConfimation() {
		return confimation;
	}
	
	

}
