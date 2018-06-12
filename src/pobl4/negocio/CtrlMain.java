/**
 * 
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import pobl4.dao.CompaniaDAO;
import pobl4.dao.ConsumoDAO;
import pobl4.dao.DAOFactory;
import pobl4.dao.PrecioDAO;
import pobl4.dao.TarifaDAO;
import pobl4.dao.UserDAO;
import pobl4.dominio.Compania;
import pobl4.dominio.Consumo;
import pobl4.dominio.SimulacionEstatica;
import pobl4.dominio.Tarifa;
import pobl4.dominio.User;
import pobl4.presentacion.VistaComparador;
import pobl4.presentacion.VistaConsumo;
import pobl4.presentacion.VistaLogin;
import pobl4.presentacion.VistaMain;
import pobl4.presentacion.VistaSimulador;
import pobl4.presentacion.VistaTiempoReal;

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
		user.setConsumos(consumoDAO.list(new Long(user.getId())));
		user.setTarifa(tarifaDAO.find(new Long(user.getTafiraID())));
		tarifa = user.getTarifa();
		tarifa.setCompania(companiaDAO.find(new Long(tarifa.getCompaniaID())));
		tarifa.setPrecios(precioDAO.list(new Long(tarifa.getTarifaID())));
		VistaMain.USERID = user.getId();
	}
	
	private void loadAppData() {
		listaCompania = companiaDAO.list();
		listaTarifas = tarifaDAO.list();
		
		
		for(Compania c : listaCompania) {
			List<Tarifa> tList = new ArrayList<>();
			for(Tarifa t : listaTarifas) {
				t.setPrecios(precioDAO.list(new Long(t.getTarifaID())));
				t.setCompania(companiaDAO.find(new Long(t.getCompaniaID())));
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
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("consumo")) {
			System.out.println("hey");
			VistaConsumo consumo = new VistaConsumo(vista, true, user.getConsumos(), consumoDAO,userDAO,this);
		}else if(e.getActionCommand().equals("simulador")) {
			SimulacionEstatica modelo = new SimulacionEstatica();
			CtrlSimulador controlador = new CtrlSimulador(modelo,listaCompania,user.getConsumos());
			VistaSimulador simulador = new VistaSimulador(vista,true,controlador,modelo,listaCompania);
		}else if(e.getActionCommand().equals("tiempoReal")) {
			VistaTiempoReal tiemporeal = new VistaTiempoReal(vista);
		}else if(e.getActionCommand().equals("comparador")) {
			CtrlComparador controlador = new CtrlComparador(listaCompania,user.getConsumos());
			VistaComparador comparador = new VistaComparador(vista,true,controlador,user.getConsumos());
		}
		

	}

}
