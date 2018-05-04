package users;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String email;
	private String first;
	private String last;
	private Date birthday;
	
	public User() {
		id = null;
		username = null;
		email = null;
		first = null;
		last = null;
		birthday = null;
	}
	
	public User(Long id, String username, String email, String first, String last, Date birthday) {
		this(username,email,first,last,birthday);
		this.id = id;
	}	
	
	public User(String username, String email, String first, String last, Date birthday) {
		this.setEmail(email);
		this.setUsername(username);
		this.setFirst(first);
		this.setLast(last);
		this.setBirthday(birthday);
		this.id = null;
	}	
	
	public User(User other) {
		this();
		if (other != null) {
			username = other.getUsername();
			email = other.getEmail();
			first = other.getFirst();
			last = other.getLast();
			id = other.getID();
		}
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirst() {
		return first;
	}
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	public String getLast() {
		return last;
	}
	
	public void setLast(String last) {
		this.last = last;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	 
	 public Long getID() {
		 return id;
	 }
	 
	 public void setID(Long id) {
			this.id=id;
	}

	
	  /**
     * The user ID is unique for each User. So this should compare User by ID only.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        return (other instanceof User) && (getID() != null)
             ? getID().equals( ( (User) other).getID() )
             : (other == this);
    }

    /**
     * The user ID is unique for each User. So User with same ID should return same hashcode.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return (getID() != null)
             ? (this.getClass().hashCode() + getID().hashCode()) 
             : super.hashCode();
    }

    /**
     * Returns the String representation of this User. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("User[id=%d,username=%s,email=%s,firstname=%s,lastname=%s,birthdate=%s]", 
        					getID(), username, email, first, last, birthday);
    }
	
	
	
	
}
