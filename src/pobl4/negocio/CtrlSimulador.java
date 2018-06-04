package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import pobl4.dominio.Compania;
import pobl4.dominio.SimulacionEstatica;
import pobl4.presentacion.VistaSimulador;

/**
 *
 * @author galaipa
 */
public class CtrlSimulador implements ItemListener, ActionListener{
    VistaSimulador vista;
    SimulacionEstatica modelo;
    
    public CtrlSimulador(SimulacionEstatica modelo){
        this.modelo = modelo;
        
    }
    
    public void setVista(VistaSimulador vista){
        this.vista = vista;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Compania compania = (Compania) e.getItem();
        modelo.setCompania(compania);
        vista.actualizarComboBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("ayuda")){
        	try {
                modelo.setValle(vista.getValle());
                modelo.setSupervalle(vista.getSuperValle());
                modelo.setPunta(vista.getPunta());
                modelo.setPotencia(vista.getPotencia());
                modelo.setTarifa(vista.getTarifa());
                modelo.setDias(vista.getDias());
                modelo.setCompania(vista.getCompania());
                modelo.calcularCoste();
                vista.actualizarTabla();
        	}catch (NumberFormatException ex) {
        		System.out.println("INPUT ERROR");
        	}

        }
    }
    
}
