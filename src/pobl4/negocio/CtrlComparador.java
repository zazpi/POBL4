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
import javax.swing.DefaultComboBoxModel;
import pobl4.dominio.Compania;
import pobl4.dominio.Consumo;
import pobl4.dominio.Simulacion;
import pobl4.dominio.SimulacionAno;
import pobl4.dominio.SimulacionMes;
import pobl4.dominio.Tarifa;
import pobl4.dominio.User;
import pobl4.presentacion.VistaComparador;
import pobl4.presentacion.anadirCompania.VistaAnadirTarifa;
import pobl4.utils.Utils;

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
        boolean renovable = vista.getSoloRenovable().isSelected();
        for(Compania c : listaCompanias){
            for(Tarifa t : c.getTarifas()){
                
                if(renovable){
                    if((vista.getFechaMes().isEnabled())&&(t.isRenovable())){
                    listaSimulaciones.add(new SimulacionMes(listaConsumos,c, t, (Integer)vista.getFechaAño().getSelectedItem(), 
                                                            Utils.translateStringToMonth((String)vista.getFechaMes().getSelectedItem())));
                    }else if ((!vista.getFechaMes().isEnabled())&&(t.isRenovable())){
                    listaSimulaciones.add(new SimulacionAno(listaConsumos,c, t,(Integer)vista.getFechaAño().getSelectedItem()));
                    }
                }else{
                    if(vista.getFechaMes().isEnabled()){
                    listaSimulaciones.add(new SimulacionMes(listaConsumos,c, t, (Integer)vista.getFechaAño().getSelectedItem(), 
                                                            Utils.translateStringToMonth((String)vista.getFechaMes().getSelectedItem())));
                    }else{
                    listaSimulaciones.add(new SimulacionAno(listaConsumos,c, t,(Integer)vista.getFechaAño().getSelectedItem()));
                    }
                }
                
            }
        }
        vista.actualizarLista(listaSimulaciones);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
         if(e.getSource().equals(vista.getFechaAño())){
            vista.actualizarComboBox();
         }
         generarSimulaciones();
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
            case VistaComparador.BT_ANADIR:
                Tarifa tarifa = new Tarifa();
        	CtrlAnadirTarifa controlTarifa = new CtrlAnadirTarifa(tarifa);
        	VistaAnadirTarifa añadirTarifa = new VistaAnadirTarifa(vista,true,controlTarifa,tarifa); 
        	if(tarifa.isValid()){
                    Compania personalizado = new Compania();
                    personalizado.setId(-1);
                    personalizado.setNombre("Personalizado");
                    List<Tarifa> listaTarifas = new ArrayList<>();
                    listaTarifas.add(tarifa);
                    personalizado.setTarifas(listaTarifas);
                    listaCompanias.add(personalizado);
                    
                }                
        	vista.actualizarComboBox();
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
