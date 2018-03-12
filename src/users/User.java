package users;

import java.util.ArrayList;

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
		this.setRating(0);
		this.setWeight(0);
	}

	public void giveRating(User u, int r) {
		
	}
	
	public void receiveRating(User u, int r) {
		
	}
	
}
