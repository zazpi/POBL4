/**
 * 
 */
package pobl4.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pobl4.dao.CompaniaDAO;
import pobl4.dao.ConsumoDAO;
import pobl4.dao.DAOFactory;
import pobl4.dao.PrecioDAO;
import pobl4.dao.TarifaDAO;
import pobl4.dao.UserDAO;
import pobl4.dominio.Compania;
import pobl4.dominio.Tarifa;
import pobl4.dominio.User;
import pobl4.negocio.CtrlMain;
import pobl4.presentacion.VistaLogin;
/**
 * @author Lucas
 *
 */
public class Main extends JFrame{
	
	public static int USERID = 0;

	public static final long serialVersionUID = 1L;
	
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
		controlador = new CtrlMain(this, user.getConsumos(), consumoDAO);
		this.setTitle("Zazpi");
		this.setSize(1000,768);
		this.setLocation(500, 500);
		this.setContentPane(mainPane());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Main main = new Main();
		main.setupDBConnAndDAOs();
		main.loadAppData();
		main.login();
		main.loadUserData();
		main.mainFrameSetup();
		System.err.println("Everything ok chief!");
                
	}
	
	public Container mainPane() {
		JPanel pane = new JPanel(new BorderLayout());
		JButton consumo = new JButton("Mi Consumo");
		consumo.setActionCommand("consumo");
		consumo.addActionListener(controlador);
		pane.add(consumo, BorderLayout.CENTER);
		
		
		return pane;
	}
}
	
