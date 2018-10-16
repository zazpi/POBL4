/**
 * 
 */
package electricom.dao;

import java.sql.Connection;
import java.sql.SQLException;

import electricom.daoexception.DAOConfigException;

/**
 * @author Lucas Sousa
 *
 */
public abstract class DAOFactory {
	
	private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";
    
    public static DAOFactory getInstance(String name) throws DAOConfigException {
        if (name == null) {
            throw new DAOConfigException("Database name is null.");
        }

        DAOProperties properties = new DAOProperties(name);
        String url = properties.getProperty(PROPERTY_URL);
        String driverClassName = properties.getProperty(PROPERTY_DRIVER);
        String password = properties.getProperty(PROPERTY_PASSWORD);
        String username = properties.getProperty(PROPERTY_USERNAME);
        DAOFactory instance = null;
        
       if (driverClassName != null) {
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                throw new DAOConfigException(
                    "Driver class '" + driverClassName + "' is missing in classpath.");
            }
            instance = new DriverManagerDAOFactory(url, username, password);
        }
        return instance;
    }
    
    abstract Connection getConnection() throws SQLException;
   
	public UserDAO getUserDAO() {
		return new UserDAOJDBC(this);
	}
	
	public ConsumoDAO getConsumoDAO() {
		return new ConsumoDAOJDBC(this);
	}
	
	public PrecioDAO getPrecioDAO() {
		return new PrecioDAOJDBC(this);
	}
	
	public TarifaDAO getTarifaDAO() {
		return new TarifaDAOJDBC(this);
	}
	
	public CompaniaDAO getCompaniaDAO() {
		return new CompaniaDAOJDBC(this);
	}

}
