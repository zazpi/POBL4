/**
 * 
 */
package pobl4.main;

import java.util.List;

import javax.swing.JFrame;

import pobl4.dao.CompaniaDAO;
import pobl4.dao.ConsumoDAO;
import pobl4.dao.DAOFactory;
import pobl4.dao.PrecioDAO;
import pobl4.dao.TarifaDAO;
import pobl4.dao.UserDAO;
import pobl4.dominio.Compania;
import pobl4.dominio.Tarifa;
import pobl4.dominio.User;
import pobl4.presentacion.VistaLogin;

/**
 * @author Lucas
 *
 */
public class Main extends JFrame{

	
	DAOFactory dbInstance;
	UserDAO userDAO;
	TarifaDAO tarifaDAO;
	ConsumoDAO consumoDAO;
	PrecioDAO precioDAO;
	CompaniaDAO companiaDAO;
	User user;
	Tarifa tarifa;
	List<Compania> listaCompania;
	
	Compania compania;
	
	Main(){
		dbInstance = DAOFactory.getInstance("Consumo.jdbc");
		userDAO = dbInstance.getUserDAO();
		tarifaDAO = dbInstance.getTarifaDAO();
		companiaDAO = dbInstance.getCompaniaDAO();
		precioDAO = dbInstance.getPrecioDAO();
		VistaLogin login = new VistaLogin(this, true, userDAO);
		user = login.getSuccess();
		if(user != null) {
			user.setTarifa(tarifaDAO.find(new Long(user.getTafiraID())));
			tarifa = user.getTarifa();
			tarifa.setPrecios(precioDAO.list(new Long(tarifa.getTarifaID())));
			compania = companiaDAO.find(new Long(tarifa.getCompaniaID()));
			compania.setTarifas(tarifaDAO.list());
			listaCompania = companiaDAO.list();
		}
		
		System.err.println(user.toString());
		System.err.println(tarifa.toString());
		System.err.println(tarifa.getPrecios().toString());
		System.err.println(compania.toString());
		System.err.println(listaCompania.toString());
		System.err.println(compania.getTarifas().toString());
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
	}

}
