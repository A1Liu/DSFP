package dao;

import users.User;

public interface SessionDAO {

	public long createSession(User user);
	
	public long createSession(int id);
	
	public long updateSession(long id);
	
	public void deleteSession(long id);
}
