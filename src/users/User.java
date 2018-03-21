package users;

import java.util.Date;

//This class handles all the actions the user can use the application to do.
/*
 * input information and change information
 * rate other users
 * request a list of relevant users from the server
 * check personal information
 */

public class User extends NewAccount {
	
	private static final long serialVersionUID = 1L;
	private final Long id;
	
	public User(Long id, NewAccount u) {
		super(u);
		this.id = id;
	}
	
	public User(NewAccount u) {
		this(null,u);
	}
	
	public User(Long id, String username, String email, String first, String last, Date birthday) {
		super(username,email,first,last,birthday);
		this.id = id;
	}	
	
	@Override
	public Long getID() {
		return id;
	}
	
}
