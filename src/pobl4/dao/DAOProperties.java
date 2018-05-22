/**
 * 
 */
package pobl4.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import pobl4.daoexception.DAOConfigException;

/**
 * @author Lucas Sousa
 *
 */
public class DAOProperties {

	private static final String PROPERTIES_FILE = "database.properties";
    private static final Properties PROPERTIES = new Properties();
    
    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            throw new DAOConfigException(
                "Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
        }

        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            throw new DAOConfigException(
                "Cannot load properties file '" + PROPERTIES_FILE + "'.");
        }
    }
    
    private String dbName;
    
   
    
    public DAOProperties(String dbName) throws DAOConfigException {
		this.dbName = dbName;
	}



	public String getProperty(String key) throws DAOConfigException {
        String fullKey = dbName + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.trim().length() == 0) {
        	    property = null;
                throw new DAOConfigException("Required property '" + fullKey + "'"
                    + " is missing in properties file '" + PROPERTIES_FILE + "'.");
            
        }

        return property;
    }
}
