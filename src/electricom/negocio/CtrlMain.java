/**
 * 
 */
package electricom.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import electricom.dao.CompaniaDAO;
import electricom.dao.ConsumoDAO;
import electricom.dao.DAOFactory;
import electricom.dao.PrecioDAO;
import electricom.dao.TarifaDAO;
import electricom.dao.UserDAO;
import electricom.dominio.Compania;
import electricom.dominio.SimulacionEstatica;
import electricom.dominio.Tarifa;
import electricom.dominio.User;
import electricom.presentacion.VistaComparador;
import electricom.presentacion.VistaConsumo;
import electricom.presentacion.VistaLogin;
import electricom.presentacion.VistaMain;
import electricom.presentacion.VistaSimulador;
import electricom.presentacion.VistaTiempoReal;

/**
 * @author root
 *
 */
public class CtrlMain implements ActionListener {
	
	VistaMain vista;
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
	CtrlMain controlador;
	Compania compania;
	
	public CtrlMain(VistaMain vista) {
		this.vista = vista;
		startApp();
	}
	
	private void login() {
		login = new VistaLogin(vista, true, userDAO,listaCompania,listaTarifas);
		user = login.getUser();
	}
	
	public void loadUserData() {
		user.setConsumos(consumoDAO.list((long) user.getId()));
		user.setTarifa(tarifaDAO.find((long) user.getTafiraID()));
		tarifa = user.getTarifa();
		tarifa.setCompania(companiaDAO.find((long) tarifa.getCompaniaID()));
		tarifa.setPrecios(precioDAO.list((long) tarifa.getTarifaID()));
		VistaMain.USERID = user.getId();
	}
	
	private void loadAppData() {
		listaCompania = companiaDAO.list();
		listaTarifas = tarifaDAO.list();
		
		
		for(Compania c : listaCompania) {
			List<Tarifa> tList = new ArrayList<>();
			for(Tarifa t : listaTarifas) {
				t.setPrecios(precioDAO.list((long) t.getTarifaID()));
				t.setCompania(companiaDAO.find((long) t.getCompaniaID()));
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
	
	private void startApp() {
		setupDBConnAndDAOs();
		loadAppData();
		login();
		loadUserData();
		vista.setUserLabel(user.getUsername());
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("consumo")) {
			System.out.println("hey");
			new VistaConsumo(vista, true, user.getConsumos(), consumoDAO,userDAO,this);
		}else if(e.getActionCommand().equals("simulador")) {
			SimulacionEstatica modelo = new SimulacionEstatica();
			CtrlSimulador controlador = new CtrlSimulador(modelo,listaCompania,user.getConsumos());
			new VistaSimulador(vista,true,controlador,modelo,listaCompania);
		}else if(e.getActionCommand().equals("tiempoReal")) {
			new VistaTiempoReal(vista);
		}else if(e.getActionCommand().equals("comparador")) {
			CtrlComparador controlador = new CtrlComparador(listaCompania,user.getConsumos());
			new VistaComparador(vista,true,controlador,user.getConsumos());
		}
		

	}

}
