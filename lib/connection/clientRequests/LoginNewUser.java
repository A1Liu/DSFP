package connection.clientRequests;

public class LoginNewUser extends ClientRequest {

	private static final long serialVersionUID = 1L;

	protected LoginNewUser(int tag, String username, String email, String name, String password) {
		super(tag,username, email, name, password);
	}

}
