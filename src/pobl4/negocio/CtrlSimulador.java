package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import pobl4.dominio.Compania;
import pobl4.dominio.Simulacion;
import pobl4.dominio.Tarifa;
import pobl4.presentacion.VistaSimulador;

/**
 *
 * @author galaipa
 */
public class CtrlSimulador implements ItemListener, ActionListener{
    VistaSimulador vista;
    Simulacion modelo;
    
    public CtrlSimulador(VistaSimulador vista, Simulacion modelo){
        this.vista = vista;
        this.modelo = modelo;
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            Object item = e.getItem();
            if(item instanceof Tarifa)
                modelo.setTarifa((Tarifa)item);
            else if(item instanceof Compania)
                modelo.setCompania((Compania) item);
        }
        vista.actualizarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case VistaSimulador.TXT_POTENCIA:
                modelo.setPotencia(vista.getPotencia());
                break;
            case VistaSimulador.TXT_DIAS:
                modelo.setDias(vista.getDias());
                break;
            case VistaSimulador.TXT_VALLE:
               // modelo.setValle(vista.getValle());
                break;
            case VistaSimulador.TXT_SUPERVALLE:
               // modelo.setSupervalle(vista.getSuperValle());
                break;
            case VistaSimulador.TXT_PUNTA:
              //  modelo.setPunta(vista.getPunta());
                break;
            default:
                break;
        }
        vista.actualizarTabla();
    }
    
    
    
}
