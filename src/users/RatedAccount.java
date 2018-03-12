package users;

public class RatedAccount {
	
	private final double userID;
	private int rating;
	
	public RatedAccount(User u, int r) {
		userID = u.getID();
		rating = r;
	}
	
	/**
	 * @return the account that was rated
	 */
	public double getUserID() {
		return userID;
	}
	
	/**
	 * @return the rating for the account
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int r) {
		this.rating = r;
	}
	
	
}
