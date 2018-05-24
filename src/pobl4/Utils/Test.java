package pobl4.Utils;

import pobl4.dao.DAOFactory;
import pobl4.dao.UserDAO;
import pobl4.generalobjectclasses.User;

public class Test {
	
	public static void main(String[] args) {
		DAOFactory db = DAOFactory.getInstance("Consumo.jdbc");
		UserDAO userDAO = db.getUserDAO();
		
		User user = new User();
		user.setNombre("Asier");
		user.setApellido("De la Natividad");
		user.setUsername("asier.delanatividad@alumni.mondragon.edu");
		user.setPassword("password");
		user.setPotencia_contratada(20.3);
		user.setTafiraID(1);
		
		userDAO.create(user);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result = Utils.validateUser(userDAO, "asier.delanatividad@alumni.mondragon.edu", "password");
		if(result)
			System.err.println("OK!!!!");
		else System.err.println("FUCKKK!!!!");
	}



}
