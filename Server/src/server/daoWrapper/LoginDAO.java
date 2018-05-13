package server.daoWrapper;

import dao.DAOFactory;
import dao.PassDAO;
import dao.UserDAO;
import users.User;

/**
 * Wrapper to make it easier to write log in command in terminal
 * @author aliu
 *
 */
public class LoginDAO {

	UserDAO userdao;
	PassDAO passdao;
	
	public LoginDAO(DAOFactory dao) {
		userdao = dao.getUserDAO();
		passdao = dao.getPassDAO();
	}
	
	public synchronized User newAcct(User user, String password) throws IllegalArgumentException {
		if (userdao.existEmail(user.getEmail()))  {
			throw new IllegalArgumentException("Email already taken.");
		}else if(userdao.existUsername(user.getUsername())) {
			throw new IllegalArgumentException("Username already taken.");
		} else {
			user = userdao.create(user);
			passdao.createPass(user.getID(), password);
		}
		return user;
	}
	
	public synchronized User login(String name, String password) throws IllegalArgumentException {
		User user = userdao.find(name);
		if (user == null)
			throw new IllegalArgumentException(name.indexOf('@') == -1 ? "Incorrect Username!" : "Incorrect Password");
		if (passdao.checkPass(user.getID(), password)) {
			return user;
		} else {
			throw new IllegalArgumentException("Incorrect Password!");
		}
		
	}
	
}
