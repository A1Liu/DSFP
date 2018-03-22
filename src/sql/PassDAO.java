package sql;

import java.util.List;

import dao.DAOException;
import users.User;

public class PassDAO implements dao.PassDAO {

    private DAOFactory daoFactory;
    
    /**
     * Construct a Password DAO for the given DAOFactory. Package private so that it can be constructed
     * inside the DAO package only.
     * @param daoFactory The DAOFactory to construct this User DAO for.
     */
    PassDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

}
