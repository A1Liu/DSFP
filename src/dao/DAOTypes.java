package dao;

/**
 * The interface that specifies all the types of DAO's that need to be implemented in the DAOFactories
 * @author Alyer
 *
 */
public interface DAOTypes {

	/**
	 * UserDAO for handing simple User data
	 * @return
	 */
	UserDAO getUserDAO();
	
	/**
	 * PassDAO for handling user passwords and salts
	 * @return
	 */
	PassDAO getPassDAO();
	
}
