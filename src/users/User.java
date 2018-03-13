package users;

import java.util.ArrayList;

//This class handles all the actions the user can use the application to do.
/*
 * input information and change information
 * rate other users
 * request a list of relevant users from the server
 * check personal information
 */

public class User extends Account {
	
	
	private ArrayList<RatedAccount> RatedAccounts;
	private ArrayList<RatedAccount> RatingsList;
	
	public User() {
		this(null, null, null, -1);
	}
	
	public User(String username, String first, String last, int birthday) {
		this.setName(username);
		this.setFirst(first);
		this.setLast(last);
		this.setBirthday(birthday);
	}

	public void giveRating(User u, int r) {
		
	}
	
	public void receiveRating(User u, int r) {
		
	}
	
}
