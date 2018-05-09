package connection.clientRequests;

import users.User;

/**
0 - new user request
	Packet includes username, password, email, birthday
	Server sends back error message or session id
1 - login request (with username and password)
	Packet includes username and password
	Server sends back error message or session id
2 - login request (with session ID)
	Packet includes session id
	Server sends back error message or new session id
 * @author aliu
 *
 */
public class LoginRequest extends ClientRequest {

	private static final long serialVersionUID = 1L;
	private final Long sessionID;
	private final User user;
	
	public LoginRequest(Long sessionID) {
		super(2);
		this.user = null;
		this.sessionID = sessionID;
	}
	
	public LoginRequest(boolean isNew, User user) {
		super(isNew ? 0 : 1);
		this.user = user;
		this.sessionID = null;
	}

	public Long getSessionID() {
		return sessionID;
	}

	public User getUser() {
		return user;
	}

}
