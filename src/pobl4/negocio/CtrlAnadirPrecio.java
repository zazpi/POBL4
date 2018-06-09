/**
 * 
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pobl4.dominio.Precio;
import pobl4.presentacion.anadirCompania.VistaAnadirTramo;

/**
 * @author root
 *
 */
public class CtrlAnadirPrecio implements ActionListener {

	Precio precio;
	VistaAnadirTramo vista;
	
	public CtrlAnadirPrecio(Precio precio) {
		this.precio = precio;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("anadir")){
        	try {
        		precio.setHora_inicio(vista.getHoraInicio());
        		precio.setHora_fin(vista.getHoraFin());
        		precio.setMes_inicio(vista.getMesInicio());
        		precio.setMes_fin(vista.getMesFin());
        		precio.setPrecio(vista.getPrecio());
        		vista.dispose();
        	}catch (NumberFormatException ex) {
        		System.out.println("INPUT ERROR");
        	}
        }else {
        	vista.dispose();
        }
		
	}

	public void setVista(VistaAnadirTramo vista) {
		this.vista = vista;	
}

}
