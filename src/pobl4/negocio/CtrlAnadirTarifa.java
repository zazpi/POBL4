package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pobl4.dominio.Precio;
import pobl4.dominio.Tarifa;
import pobl4.presentacion.anadirCompania.VistaAnadirTarifa;
import pobl4.presentacion.anadirCompania.VistaAnadirTramo;


public class CtrlAnadirTarifa implements ActionListener {
    VistaAnadirTarifa vista;
    Tarifa tarifa;
    
    public CtrlAnadirTarifa(Tarifa tarifa) {
            this.tarifa = tarifa;
    }

    public void setVista(VistaAnadirTarifa vista) {
            this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()) {
            case "guardar":
                tarifa.setDescripcion(vista.getDescripcionTarifa());
                vista.dispose();
                break;
            case "anadir":
            	Precio precio = new Precio();
            	CtrlAnadirPrecio ctrl = new CtrlAnadirPrecio(precio);
            	VistaAnadirTramo vis = new VistaAnadirTramo(vista,true,ctrl);
            	if(precio!= null)
            		tarifa.getPrecios().add(precio);
            	vista.actualizarListaPrecios();
                break;
            case "cancelar":
                vista.dispose();
                break;
            }

    }

	public Tarifa getTarifa() {
		return tarifa;
	}

}
