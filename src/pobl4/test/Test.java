/**
 * 
 */
package pobl4.test;

import pobl4.doa.DAOFactory;
import pobl4.doa.UserDAO;
import pobl4.user.User;

/**
 * @author Lucas Sousa
 *
 */
public class Test {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		    DAOFactory testbase = DAOFactory.getInstance("testbase2.jdbc");
	        System.out.println("DAOFactory successfully obtained: " + testbase);

	        // Obtain UserDAO.
	        UserDAO userDAO = testbase.getUserDAO();
	        System.out.println("UserDAO successfully obtained: " + userDAO);
	        
	        User user = new User();
	        user.setUsername("foo@bar.com");
	        user.setPassword("password");
	        userDAO.create(user);
	        System.out.println("User successfully created: " + user);
	        

	}

}
