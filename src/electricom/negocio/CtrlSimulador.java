package electricom.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import electricom.dominio.Compania;
import electricom.dominio.Consumo;
import electricom.dominio.SimulacionEstatica;
import electricom.dominio.Tarifa;
import electricom.presentacion.VistaElegirConsumo;
import electricom.presentacion.VistaSimulador;
import electricom.presentacion.anadirCompania.VistaAnadirTarifa;

public class CtrlSimulador implements ActionListener{
    VistaSimulador vista;
    SimulacionEstatica modeloSimulacion;
    List<Compania> listaCompanias;
    List<Consumo> listaConsumos;
    
    public CtrlSimulador(SimulacionEstatica modeloSimulacion, List<Compania> listaCompanias,List<Consumo> listaConsumos){
        this.modeloSimulacion = modeloSimulacion;
        this.listaCompanias = listaCompanias;
        this.listaConsumos = listaConsumos;
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
        		vista.mostrarError();
        	}

        }else if(actionCommand.equals("anadir")) {
        	Tarifa tarifa = new Tarifa();
        	CtrlAnadirTarifa controlTarifa = new CtrlAnadirTarifa(tarifa);
        	if(tarifa.isValid())
        		vista.getCompania().getTarifas().add(tarifa);
        	vista.actualizarComboBox();
        }else if(actionCommand.equals("cargar")) {
        	VistaElegirConsumo elegir = new VistaElegirConsumo(vista,true,listaConsumos);
            vista.setValle((int) Math.round(elegir.getValle()));
            vista.setPunta((int) Math.round(elegir.getPunta()));
            vista.setSuperValle((int) Math.round(elegir.getSuperValle()));
            vista.setDias(elegir.getDias());
        }
    }
    
    
}
