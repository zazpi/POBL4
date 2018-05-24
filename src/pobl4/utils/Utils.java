package pobl4.utils;

import pobl4.dao.UserDAO;

/**
 * 
 * @author Lucas
 *
 */

public class Utils {

	
	public static boolean validateUser(UserDAO userDAO,String username,String password) {
		if(userDAO.find(username, password)!=null)
			return true;
		
		return false;
			
	}
	
	
}
