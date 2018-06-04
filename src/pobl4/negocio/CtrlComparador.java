/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import pobl4.dominio.Compania;
import pobl4.dominio.Consumo;
import pobl4.dominio.Simulacion;
import pobl4.dominio.SimulacionAno;
import pobl4.dominio.SimulacionMes;
import pobl4.dominio.Tarifa;
import pobl4.dominio.User;
import pobl4.presentacion.VistaComparador;

/**
 *
 * @author asier
 */
public class CtrlComparador implements ItemListener, ActionListener{
    
    VistaComparador vista;
    List<Simulacion> listaSimulaciones;
    List<Compania> listaCompanias;
    List<Consumo> listaConsumos;
    
    public CtrlComparador( List<Compania> listaCompanias, List<Consumo> listaConsumos){
        this.listaCompanias = listaCompanias;
        this.listaConsumos = listaConsumos;
    }
    
    
    public void generarSimulaciones(){
        listaSimulaciones = new ArrayList<>();
        for(Compania c : listaCompanias){
            for(Tarifa t : c.getTarifas()){
                if(vista.getFechaMes().isEnabled()){
                    listaSimulaciones.add(new SimulacionMes(listaConsumos,c, t, 2017, 6));
                }else{
                    listaSimulaciones.add(new SimulacionAno(listaConsumos,c, t, 2017));
                }
            }
        }
        vista.actualizarLista(listaSimulaciones);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       if(e.getStateChange() == ItemEvent.SELECTED){
            Object item = e.getItem();
            
                
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case VistaComparador.BT_ANO:
                vista.getFechaMes().setEnabled(false);
                break;
            case VistaComparador.BT_MES:
                vista.getFechaMes().setEnabled(true);
                break;
            default:
                break;
        }
        generarSimulaciones();
       
    }

    public void setVista(VistaComparador vista) {
        this.vista = vista;
    }
    
    
    
  
    
}
