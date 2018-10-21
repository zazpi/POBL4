package electricom.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import electricom.dominio.Precio;
import electricom.presentacion.anadirCompania.VistaAnadirTramo;


public class CtrlAnadirPrecio implements ActionListener, Serializable {

	Precio precio = null;
	VistaAnadirTramo vista;
	
	@Override
	public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("anadir")){
        	try {
        		precio = new Precio();
        		precio.setHoraInicio(vista.getHoraInicio());
        		precio.setHoraFin(vista.getHoraFin());
        		precio.setMesInicio(vista.getMesInicio());
        		precio.setMesFin(vista.getMesFin());
        		precio.setPrecio(vista.getPrecio());
        		vista.dispose();
        	}catch (NumberFormatException ex) {
        		System.out.println("INPUT ERROR");
        		precio = null;
        		vista.mostrarError();
        	}
        }else {
        	vista.dispose();
        }
	}
	
	public Precio getPrecio() {
		return precio;
	}

	public void setVista(VistaAnadirTramo vista) {
		this.vista = vista;	
	}

}
