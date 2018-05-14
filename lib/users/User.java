package users;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String email;
	private String name;
	private Date birthday;
	
	public User() {
		this(null,null,null,null,null);
	}
	
	public User(String username, String email, String name) {
		this(null,username,email,name,null);
	}
	
	public User(Long id, String username, String email, String name, Date birthday) {
		this.setEmail(email);
		this.setUsername(username);
		this.setName(name);
		this.setBirthday(birthday);
		this.id = id;
	}	
	
	public User(String username, String email, String name, Date birthday) {
		this(null, username, email, name, birthday);
	}	
	
	public User(Long id, User other) {
		if (other != null) {
			username = other.getUsername();
			email = other.getEmail();
			name = other.getName();
			birthday = other.getBirthday();
		} else {
			this.setEmail(null);
			this.setUsername(null);
			this.setName(null);
			this.setBirthday(null);
		}
		this.id = id;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String first) {
		this.name = first;
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
		 this.id = id;
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
        return String.format("User[id=%d,username=%s,email=%s,name=%s,birthdate=%s]", 
        					getID(), username, email, name, birthday);
    }
	
	
	
	
}
