package pobl4.Utils;

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
