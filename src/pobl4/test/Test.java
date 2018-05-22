package pobl4.test;

import pobl4.doa.DAOFactory;
import pobl4.doa.UserDAO;
import pobl4.user.User;

public class Test {
    public static void main(String[] args) throws Exception {
    	
    	  DAOFactory javabase = DAOFactory.getInstance("testbase2.jdbc");
          System.out.println("DAOFactory successfully obtained: " + javabase);

          // Obtain UserDAO.
          UserDAO userDAO = javabase.getUserDAO();
          System.out.println("UserDAO successfully obtained: " + userDAO);

          // Create user.
          User user = new User();
          user.setUsername("foo@bar.com");
          user.setPassword("password");
          userDAO.create(user);
          System.out.println("User successfully created: " + user);
    	
    }

}
