package sql;

/**
 * TODO: start and finish this
 * 
 * @author aliu
 *
 */
public class RatingDAO implements dao.RatingDAO {

	private DAOFactory daoFactory;
	
	public RatingDAO(DAOFactory daoFactory) {
		this.setDaoFactory(daoFactory);
	}

	public DAOFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

}
