
package electricom.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import electricom.dominio.Precio;
import electricom.dominio.Tarifa;
import electricom.presentacion.anadirCompania.VistaAnadirTarifa;
import electricom.presentacion.anadirCompania.VistaAnadirTramo;

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
            	CtrlAnadirPrecio ctrl = new CtrlAnadirPrecio();
            	Precio precio = ctrl.getPrecio();
            	if(precio!= null)
            		tarifa.getPrecios().add(precio);
            	vista.actualizarListaPrecios();
                break;
            default:
            case "cancelar":
                vista.dispose();
                break;
            }

    }

	public Tarifa getTarifa() {
		return tarifa;
}

}
