package sql;

import users.User;

/**
 * TODO: Implement sessionID
 * @author aliu
 *
 */
public class SessionDAO implements dao.SessionDAO {

	private DAOFactory dao;
	
	SessionDAO(DAOFactory dao) {
		this.dao = dao;
	}
	
	@Override
	public long createSession(User user) {
		
		return 0;
	}

	@Override
	public long createSession(long id) {
		
		return 0;
	}

	@Override
	public long updateSession(long id) {
		
		return 0;
	}

	@Override
	public void deleteSession(long id) {
		
		
	}

	@Override
	public void deleteUser(long id) {
		
		
	}

	@Override
	public void deleteUser(User user) {
		
		
	}

}
