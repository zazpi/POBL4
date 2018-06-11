package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import pobl4.dominio.Compania;
import pobl4.dominio.Consumo;
import pobl4.dominio.SimulacionEstatica;
import pobl4.dominio.Tarifa;
import pobl4.presentacion.VistaElegirConsumo;
import pobl4.presentacion.VistaSimulador;
import pobl4.presentacion.anadirCompania.VistaAnadirTarifa;

public class CtrlSimulador implements ActionListener{
    VistaSimulador vista;
    SimulacionEstatica modeloSimulacion;
    List<Compania> listaCompanias;
    List<Consumo> listaConsumos;
    
    public CtrlSimulador(SimulacionEstatica modeloSimulacion, List<Compania> listaCompanias,List<Consumo> listaConsumos){
        this.modeloSimulacion = modeloSimulacion;
        this.listaCompanias = listaCompanias;
    }
    
    public void setVista(VistaSimulador vista){
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("simular")){
        	try {
                    modeloSimulacion.setValle(vista.getValle());
                    modeloSimulacion.setSupervalle(vista.getSuperValle());
                    modeloSimulacion.setPunta(vista.getPunta());
                    modeloSimulacion.setPotencia(vista.getPotencia());
                    modeloSimulacion.setTarifa(vista.getTarifa());
                    modeloSimulacion.setDias(vista.getDias());
                    modeloSimulacion.setCompania(vista.getCompania());
                    modeloSimulacion.calcularCoste();
                    vista.actualizarTabla();
        	}catch (NumberFormatException ex) {
        		System.out.println("INPUT ERROR");
        		vista.mostrarError();
        	}

        }else if(actionCommand.equals("anadir")) {
        	Tarifa tarifa = new Tarifa();
        	CtrlAnadirTarifa controlTarifa = new CtrlAnadirTarifa(tarifa);
        	VistaAnadirTarifa añadirTarifa = new VistaAnadirTarifa(vista,true,controlTarifa,tarifa); 
        	if(tarifa.isValid())
        		vista.getCompania().getTarifas().add(tarifa);
        	vista.actualizarComboBox();
        }else if(actionCommand.equals("cargar")) {
        	VistaElegirConsumo elegir = new VistaElegirConsumo(vista,true,listaConsumos);
            modeloSimulacion.setValle(elegir.getValle());
            modeloSimulacion.setSupervalle(elegir.getSuperValle());
            modeloSimulacion.setPunta(elegir.getPunta());
            modeloSimulacion.setDias(elegir.getDias());
            vista.actualizarTabla();
        }
    }
    
    
}
