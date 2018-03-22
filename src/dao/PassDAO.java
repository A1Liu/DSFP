package dao;

import java.util.List;

import users.User;

public interface PassDAO {

    /**
     * Returns a list of all usernames from the database ordered by user ID. The list is never null and
     * is empty when the database does not contain any user.
     * @return A list of all users from the database ordered by user ID.
     * @throws DAOException If something fails at database level.
     */
    public List<Long> list() throws DAOException;

    /**
     * Create the given user in the database. The user ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given user.
     * @param user The user to be created in the database.
     * @throws IllegalArgumentException If the user ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void createPass(User user, String pass) throws IllegalArgumentException, DAOException;
    
    /**
     * Create the given user in the database. The user ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given user.
     * @param user The user to be created in the database.
     * @throws IllegalArgumentException If the user ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void createPass(Long id, String pass) throws IllegalArgumentException, DAOException;

    /**
     * Create the given user in the database. The user ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given user.
     * @param user The user to be created in the database.
     * @throws IllegalArgumentException If the user ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void deletePass(User user, String pass) throws IllegalArgumentException, DAOException;
    
    /**
     * Create the given user in the database. The user ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given user.
     * @param user The user to be created in the database.
     * @throws IllegalArgumentException If the user ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void deletePass(Long id, String pass) throws IllegalArgumentException, DAOException;
    
    public default Long getSalt(User user) {
    	return getSalt(user.getID());
    }
    
    public Long getSalt(Long id);
    
    /**
     * Update the password of a user. After deleting, the DAO will set the ID of the given
     * user to null.
     * @param user The user to be deleted from the database.
     * @throws DAOException If something fails at database level.
     */
    public void changePass(User user, String oldPass, String newPass) throws DAOException;
    
    /** Returns true if the given email address exists in the database.
    * @param email The email address which is to be checked in the database.
    * @return True if the given email address exist in the database.
    * @throws DAOException If something fails at database level.
    */
   public default boolean existID(User user) throws DAOException {
	   return existID(user.getID());
   }
    
    /**
     * Returns true if the given email address exists in the database.
     * @param email The email address which is to be checked in the database.
     * @return True if the given email address exist in the database.
     * @throws DAOException If something fails at database level.
     */
    public boolean existID(Long id) throws DAOException;

    public default boolean getPass(User user) {
    	return getPass(user.getID());
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public boolean getPass(Long id);
}
