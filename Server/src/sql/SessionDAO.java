package sql;

import users.User;

public class SessionDAO implements dao.SessionDAO {

	private DAOFactory dao;
	
	SessionDAO(DAOFactory dao) {
		this.dao = dao;
	}
	
	@Override
	public long createSession(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long createSession(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long updateSession(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteSession(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
