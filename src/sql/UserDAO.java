package sql;

import static sql.DAOUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOException;
import users.User;

/**
 * This class represents a concrete JDBC implementation of the {@link UserDAO} interface.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */

public class UserDAO implements dao.UserDAO {

    // Constants ----------------------------------------------------------------------------------

    private static final String SQL_FIND_BY_ID =
        "SELECT id, username, email, firstname, lastname, birthdate FROM User WHERE id = ?";
    private static final String SQL_FIND_BY_USERNAME =
            "SELECT id, username, email, firstname, lastname, birthdate FROM User WHERE username = ?";
    private static final String SQL_FIND_BY_EMAIL =
            "SELECT id, username, email, firstname, lastname, birthdate FROM User WHERE email = ?";
    private static final String SQL_LIST_ORDER_BY_ID =
        "SELECT id, username, email, firstname, lastname, birthdate FROM User ORDER BY id";
    private static final String SQL_INSERT =
        "INSERT INTO User (username, email, firstname, lastname, birthdate) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE =
        "UPDATE User SET username = ?, email = ?, firstname = ?, lastname = ?, birthdate = ? WHERE id = ?";
    private static final String SQL_DELETE =
        "DELETE FROM User WHERE id = ?";
    private static final String SQL_EXIST_EMAIL =
        "SELECT id FROM User WHERE email = ?";
    private static final String SQL_EXIST_USERNAME =
            "SELECT id FROM User WHERE username = ?";

    // Vars ---------------------------------------------------------------------------------------

    private DAOFactory daoFactory;

    // Constructors -------------------------------------------------------------------------------

    /**
     * Construct an User DAO for the given DAOFactory. Package private so that it can be constructed
     * inside the DAO package only.
     * @param daoFactory The DAOFactory to construct this User DAO for.
     */
    UserDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    // Actions ------------------------------------------------------------------------------------

    @Override
    public User find(Long id) throws DAOException {
        return find(SQL_FIND_BY_ID, id);
    }

    @Override
    public User find(String name) throws DAOException {
        return 	(name.indexOf('@')==-1)
        		? find(SQL_FIND_BY_USERNAME, name)
        		: find(SQL_FIND_BY_EMAIL, name);
    }
    
    

    /**
     * Returns the user from the database matching the given SQL query with the given values.
     * @param sql The SQL query to be executed in the database.
     * @param values The PreparedStatement values to be set.
     * @return The user from the database matching the given SQL query with the given values.
     * @throws DAOException If something fails at database level.
     */
    private User find(String sql, Object... values) throws DAOException {
        User user = null;

        try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, sql, false, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return user;
    }

    @Override
    public List<User> list() throws DAOException {
        List<User> users = new ArrayList<>();

        try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ID);
            ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return users;
    }

    @Override
    public void create(User user) throws IllegalArgumentException, DAOException {
        if (user.getID() != null) {
            throw new IllegalArgumentException("User is already created, the user ID is not null.");
        }

        Object[] values = {
        	user.getUsername(),
            user.getEmail(),
            user.getFirst(),
            user.getLast(),
            toSqlDate(user.getBirthday())
        };

        try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, SQL_INSERT, true, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Creating user failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	user.setID(generatedKeys.getLong(1));
                } else {
                    throw new DAOException("Creating user failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        if (user.getID() == null) {
            throw new IllegalArgumentException("User is not created yet, the user ID is null.");
        }

        Object[] values = {
        	user.getUsername(),
            user.getEmail(),
            user.getFirst(),
            user.getLast(),
            toSqlDate(user.getBirthday()),
            user.getID()
        };

        try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, SQL_UPDATE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Updating user failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(User user) throws DAOException {
        Object[] values = { 
            user.getID()
        };

        try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, SQL_DELETE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Deleting user failed, no rows affected.");
            } else {
                user.setID(null);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    @Override
	public boolean existUsername(String name) throws DAOException {
		 Object[] values = { 
		            name
		        };

		        boolean exist = false;

		        try (
		            Connection connection = daoFactory.getConnection();
		            PreparedStatement statement = prepareStatement(connection, SQL_EXIST_USERNAME, false, values);
		            ResultSet resultSet = statement.executeQuery();
		        ) {
		            exist = resultSet.next();
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }

		        return exist;
	}

    @Override
    public boolean existEmail(String email) throws DAOException {
        Object[] values = { 
            email
        };

        boolean exist = false;

        try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = prepareStatement(connection, SQL_EXIST_EMAIL, false, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            exist = resultSet.next();
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return exist;
    }
    
    

    // Helpers ------------------------------------------------------------------------------------

    /**
     * Map the current row of the given ResultSet to a User.
     * @param resultSet The ResultSet of which the current row is to be mapped to an User.
     * @return The mapped User from the current row of the given ResultSet.
     * @throws SQLException If something fails at database level.
     */
    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User(resultSet.getLong("id"),
        		resultSet.getString("username"),
        		resultSet.getString("email"),
        		resultSet.getString("firstname"),
        		resultSet.getString("lastname"),
        		resultSet.getDate("birthdate"));
        return user;
    }

}
