package sql;

import static sql.DAOUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.DAOException;
import users.User;

public class PassDAO implements dao.PassDAO {//use MD5 (?) for password sql statements

    private DAOFactory daoFactory;
    
    /**
     * Construct a Password DAO for the given DAOFactory. Package private so that it can be constructed
     * inside the DAO package only.
     * @param daoFactory The DAOFactory to construct this User DAO for.
     */
    PassDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	@Override
	public List<Long> list() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPass(Long id, String pass) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePass(Long id, String pass) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSalt(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changePass(Long id, String oldPass, String newPass) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existID(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPass(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 *  @Override
    public void changePassword(User user) throws DAOException {
        if (user.getID() == null) {
            throw new IllegalArgumentException("User is not created yet, the user ID is null.");
        }

        Object[] values = {
            user.getPassword(),
            user.getID()
        };

        try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, SQL_CHANGE_PASSWORD, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Changing password failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
	 */

}
