/**
 * 
 */
package electricom.dao;

import electricom.daoexception.DAOException;
import electricom.dominio.User;

/**
 * @author Lucas Sousa
 *
 */
public interface UserDAO {
	
	public User find(Long id) throws DAOException;
	public User find(String username, String password) throws DAOException;
	public void create(User user) throws IllegalArgumentException, DAOException;
	public void update(Long id) throws IllegalArgumentException,DAOException;

}
