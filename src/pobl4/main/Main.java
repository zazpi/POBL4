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
import pobl4.dominio.Precio;
import pobl4.dominio.SimulacionEstatica;
import pobl4.dominio.Tarifa;
import pobl4.dominio.User;
<<<<<<< HEAD
import pobl4.negocio.CtrlSimulador;
=======
import pobl4.presentacion.VistaConsumo;
>>>>>>> master
import pobl4.presentacion.VistaLogin;
import pobl4.presentacion.VistaSimulador;

/**
 * @author Lucas
 *
 */
public class Main extends JFrame{
	
	private static int USERID = 0;
	
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
<<<<<<< HEAD
    List<Tarifa> listaTarifas;
=======
	List<Tarifa> listaTarifas;
>>>>>>> master
	
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
<<<<<<< HEAD
		VistaLogin login = new VistaLogin(this, true, userDAO);
		user = login.getSuccess();
		if(user != null) {
			user.setTarifa(tarifaDAO.find(new Long(user.getTafiraID())));
			tarifa = user.getTarifa();
			tarifa.setPrecios(precioDAO.list(new Long(tarifa.getTarifaID())));
			compania = companiaDAO.find(new Long(tarifa.getCompaniaID()));
			compania.setTarifas(tarifaDAO.list());
			listaCompania = companiaDAO.list();
            listaTarifas = tarifaDAO.list();
                        for(Compania comp : listaCompania){
                            List<Tarifa> tarifas = new ArrayList<>();
                            for(Tarifa tarifa : listaTarifas){
                                if(tarifa.getCompaniaID() == comp.getId())
                                    tarifas.add(tarifa);
                                tarifa.setPrecios(precioDAO.list(new Long(tarifa.getTarifaID())));
                            }
                            comp.setTarifas(tarifas);
                            
                        }
                        
                        SimulacionEstatica modelo = new SimulacionEstatica();
                        CtrlSimulador controlador = new CtrlSimulador(modelo);     
                        VistaSimulador vista = new VistaSimulador(this,true,controlador,user,modelo,listaCompania);
		}
		
		System.err.println(user.toString());
		System.err.println(tarifa.toString());
		System.err.println(tarifa.getPrecios().toString());
		System.err.println(compania.toString());
		System.err.println(listaCompania.toString());
		System.err.println(compania.getTarifas().toString());
		
=======
	}
	
	private void mainFrameSetup() {
		this.setTitle("Zazpi");
		this.setSize(1000,768);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		VistaConsumo consumo = new VistaConsumo(this, true, user.getConsumos());
	}
	
	public DAOFactory getDAO() {
		return dbInstance;
>>>>>>> master
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

<<<<<<< HEAD
}
=======
	
}
>>>>>>> master
