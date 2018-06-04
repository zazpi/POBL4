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
import pobl4.negocio.CtrlSimulador;
import pobl4.presentacion.VistaLogin;
import pobl4.presentacion.VistaSimulador;

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
    List<Tarifa> listaTarifas;
	
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
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
	}

}