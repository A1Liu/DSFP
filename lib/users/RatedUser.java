package users;

public class RatedUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rated;
	
	public RatedUser(User user, int rating) {
		super(user);
		this.rated = rating;
	}
	
	public int getRated() {
		return rated;
	}
	public void setRated(int rated) {
		this.rated = rated;
	}
	
}
