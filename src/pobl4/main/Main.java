/**
 * 
 */
package pobl4.main;

import java.util.ArrayList;
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
import pobl4.presentacion.VistaConsumo;
import pobl4.presentacion.VistaLogin;

/**
 * @author Lucas
 *
 */
public class Main extends JFrame{
	
	public static int USERID = 0;
	
	DAOFactory dbInstance;
	UserDAO userDAO;
	TarifaDAO tarifaDAO;
	ConsumoDAO consumoDAO;
	PrecioDAO precioDAO;
	CompaniaDAO companiaDAO;
	VistaLogin login;
	User user;
	Tarifa tarifa;
	List<Compania> listaCompania;
	List<Tarifa> listaTarifas;
	
	Compania compania;
	
	public Main(){
	}
	
	private void login() {
		login = new VistaLogin(this, true, userDAO,listaCompania,listaTarifas);
		user = login.getUser();
	}
	
	private void loadUserData() {
		user.setConsumos(consumoDAO.list(new Long(user.getId())));
		user.setTarifa(tarifaDAO.find(new Long(user.getTafiraID())));
		tarifa = user.getTarifa();
		tarifa.setCompania(companiaDAO.find(new Long(tarifa.getCompaniaID())));
		tarifa.setPrecios(precioDAO.list(new Long(tarifa.getTarifaID())));
		USERID = user.getId();
	}
	
	private void loadAppData() {
		listaCompania = companiaDAO.list();
		listaTarifas = tarifaDAO.list();
		
		
		for(Compania c : listaCompania) {
			List<Tarifa> tList = new ArrayList<>();
			for(Tarifa t : listaTarifas) {
				if(t.getCompaniaID() == c.getId())
					tList.add(t);
			}
			
			c.setTarifas(tList);
		}
	}
	
	private void setupDBConnAndDAOs() {
		dbInstance = DAOFactory.getInstance("Consumo.jdbc");
		userDAO = dbInstance.getUserDAO();
		consumoDAO = dbInstance.getConsumoDAO();
		tarifaDAO = dbInstance.getTarifaDAO();
		companiaDAO = dbInstance.getCompaniaDAO();
		precioDAO = dbInstance.getPrecioDAO();
	}
	
	private void mainFrameSetup() {
		this.setTitle("Zazpi");
		this.setSize(1000,768);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		VistaConsumo consumo = new VistaConsumo(this, true, user.getConsumos(),consumoDAO);
	}
	
	public DAOFactory getDAO() {
		return dbInstance;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.setupDBConnAndDAOs();
		main.loadAppData();
		main.login();
		main.loadUserData();
		main.mainFrameSetup();
		System.err.println("Everything ok chief!");
	}

	
}
