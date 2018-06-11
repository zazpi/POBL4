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
	CtrlMain controlador;
	
	public Main() {
		controlador = new CtrlMain(this);
		this.setTitle("Zazpi");
		this.setSize(1280, 768);
		this.setLocation(500, 0);
		this.setContentPane(mainPane());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
