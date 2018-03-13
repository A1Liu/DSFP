package users;

//handles all the actions done behind the scenes by the application

public abstract class Account {

	private String username;
	private String first;
	private String last;
	private int birthday;
	
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	private int weight;
	private String bio;//write it in text file or as static string[]
	//Info:https://stackoverflow.com/questions/10056183/java-ignore-escape-sequences
	
	/**
	 * @return the name
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * @return the first name
	 */
	public String getFirst() {
		return first;
	}
	/**
	 * @param first the first name to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	/**
	 * @return the last name
	 */
	public String getLast() {
		return last;
	}
	/**
	 * @param last the last name to set
	 */
	public void setLast(String last) {
		this.last = last;
	}
	/**
	 * @param name the user name to set
	 */
	public void setName(String name) {
		this.username = name;
	}
	/**
	 * @return the birthday
	 */
	public int getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}
	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
