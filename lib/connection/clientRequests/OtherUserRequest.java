package connection.clientRequests;

/**
20 - other account information request
	packet contains user identifier
	server sends back error message or public profile user object
21 - rate other user request
	packet contains user identifier and rating
	server sends back error message or success message
22 - friend other user request
	packet contains user identifier
	server sends back error message or success message
 * @author aliu
 *
 */
public class OtherUserRequest extends ClientRequest {

	private static final long serialVersionUID = 1L;
	private final String data;
	private final Integer rating;

	public OtherUserRequest(String data, Integer rating) {
		super(21);
		this.data = data;
		this.rating = rating;
	}
	
	public OtherUserRequest(int tag, String data) {
		super(tag);
		this.data = data;
		this.rating = null;
	}

	public String getData() {
		return data;
	}

	public Integer getRating() {
		return rating;
	}

}
