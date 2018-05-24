package simulador;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Simulador extends JDialog{

	public Simulador(JFrame ventana) {
		super(ventana,"Simulador de facturas",true);
		
		
		this.setSize(600,500);
		this.setLocation(300,100);
		this.setContentPane(crearPanelVentana());
		this.setUndecorated(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private Container crearPanelVentana() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new PanelSimulador());
		
		return panel;
	}
	


	public static void main (String[] args) {
		
		
                try { 
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); 
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) { 
                    ex.printStackTrace(); 
                }
                JFrame frame = new JFrame("PROBA");
                new Simulador(frame);
	}
	

	
}
