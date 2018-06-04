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
	
	public static String translateMonthToString(int mes) {
		switch(mes) {
		case 1:
			return "Enero";
		case 2:
			return "Febrero";
		case 3:
			return "Marzo";
		case 4:
			return "Abril";
		case 5:
			return "Mayo";
		case 6:
			return "Junio";
		case 7:
			return "Julio";
		case 8:
			return "Agosto";
		case 9:
			return "Septiembre";
		case 10:
			return "Octubre";
		case 11:
			return "Noviembre";
		case 12:
			return "Deciembre";
		default:
			return "Not assigned";
		}
	}
	
}
