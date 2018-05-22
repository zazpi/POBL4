/**
 * 
 */
package pobl4.dao;

import java.util.List;

import pobl4.daoexception.DAOException;
import pobl4.user.User;

/**
 * @author Lucas Sousa
 *
 */
public interface UserDAO {
	
	public User find(Long id) throws DAOException;
	public User find(String username, String password) throws DAOException;
	public void create(User user) throws IllegalArgumentException, DAOException;
	public void update(User user) throws IllegalArgumentException, DAOException;
	public void delete(User user) throws IllegalArgumentException, DAOException;
	public List<User> userList() throws DAOException;

}
