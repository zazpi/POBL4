package pobl4.utils;

import pobl4.dao.UserDAO;
import pobl4.dominio.User;

/**
 * 
 * @author Lucas
 *
 */

public class Utils {

	
	public static User validateUser(UserDAO userDAO,String username,String password) {
		User user = userDAO.find(username, password);
		if(user!=null)
			return user;
		
		return null;
			
	}
	
	
}
