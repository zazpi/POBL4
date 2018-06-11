package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pobl4.dominio.Precio;
import pobl4.presentacion.anadirCompania.VistaAnadirTramo;


public class CtrlAnadirPrecio implements ActionListener {

	Precio precio = null;
	VistaAnadirTramo vista;
	
	@Override
	public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("anadir")){
        	try {
        		precio = new Precio();
        		precio.setHora_inicio(vista.getHoraInicio());
        		precio.setHora_fin(vista.getHoraFin());
        		precio.setMes_inicio(vista.getMesInicio());
        		precio.setMes_fin(vista.getMesFin());
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
