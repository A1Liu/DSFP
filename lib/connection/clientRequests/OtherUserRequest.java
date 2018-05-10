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
23 - search for users
	packet contains search string
	server sends back results
 * @author aliu
 *
 */
public class OtherUserRequest extends ClientRequest {

	private static final long serialVersionUID = 1L;
	private final String data;
	private final int rating;

	public OtherUserRequest(String data, int rating) {
		super(21);
		this.data = data;
		if (rating > 5)
			rating = 5;
		else if (rating < 1)
			rating = 1;
		this.rating = rating;
	}
	
	/**
	 * 
	 * @param friendly determines whether this request friends the user or just asks for information
	 * @param data
	 */
	public OtherUserRequest(int label, String data) {
		super(label);
		this.data = data;
		this.rating = -1;
	}

	public String getData() {
		return data;
	}

	public int getRating() {
		return rating;
	}

}
