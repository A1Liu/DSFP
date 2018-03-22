package dao;

import java.util.List;

import users.User;

/**
 * all the methods that need to be implemented by a PassDAO
 * @author Alyer
 *
 */
public interface PassDAO {

    /**
     * Returns a list of all usernames from the database ordered by user ID. The list is never null and
     * is empty when the database does not contain any user.
     * @return A list of all users from the database ordered by user ID.
     * @throws DAOException If something fails at database level.
     */
    public List<Long> list() throws DAOException;
    
    /**
     * Create a password entry for the given id and password in the database. The user ID must not be null, otherwise it will throw
     * IllegalArgumentException.
     * @param user The user to be created in the database.
     * @throws IllegalArgumentException If the ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void createPass(Long id, String pass) throws IllegalArgumentException, DAOException;
    
    /**
     * delete the given user entry in the database. The user ID must not be null, otherwise it will throw
     * IllegalArgumentException.
     * @param user The user to be created in the database.
     * @throws IllegalArgumentException If the user ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void deletePass(Long id, String pass) throws IllegalArgumentException, DAOException;
    
    /**
     * Returns the salt of the given id
     * @param id id of the user whose salt is being retrieved
     * @return the salt of the user
     * @throws DAOException If something fails at the database level.
     */
    public int getSalt(Long id) throws DAOException;
    
    /**
     * Update the password of a user. After deleting, the DAO will set the ID of the given
     * user to null.
     * @param user The user to be deleted from the database.
     * @throws DAOException If something fails at database level.
     * @throws IllegalArgumentException If newPass is null or empty
     */
    public void changePass(Long id, String oldPass, String newPass) throws IllegalArgumentException, DAOException;
    
    /**
     * Returns true if the given ID has an associated password
     * @param id The id which is to be checked in the database.
     * @return True if the given id exists in the database.
     * @throws DAOException If something fails at database level.
     */
    public boolean existID(Long id) throws DAOException;
    
    /**
     * returns the password of the given ID
     * @param id The id whose password is being checked
     * @return The password of the id
     * @throws DAOException if something fails at the database level.
     */
    public String getPass(Long id) throws DAOException;
}
