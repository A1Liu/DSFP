package users;

import java.io.Serializable;
import java.util.Date;

public abstract class NewAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String email;
	private String first;
	private String last;
	private Date birthday;
	private String password;
	
	public NewAccount() {
		
	}
	
	public NewAccount(String username, String email, String first, String last, Date birthday) {
		this.setEmail(email);
		this.setUsername(username);
		this.setFirst(first);
		this.setLast(last);
		this.setBirthday(birthday);
	}	
	
	public NewAccount(NewAccount a) {
		if (a != null) {
			username = a.getUsername();
			email = a.getEmail();
			first = a.getFirst();
			last = a.getLast();
			password = a.getPassword();
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
	
	public String getPassword() {
		return password;
	}
	
	 public void setPassword(String password) {
	        this.password = password;
	    }
	 
	 public Long getID() {
		 return null;
	 }

	
	  /**
     * The user ID is unique for each User. So this should compare User by ID only.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        return (other instanceof NewAccount) && (getID() != null)
             ? getID().equals( ( (NewAccount) other).getID() )
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
