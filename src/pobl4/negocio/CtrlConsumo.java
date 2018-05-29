/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import pobl4.dominio.Consumo;
import pobl4.presentacion.VistaConsumo;

/**
 *
 * @author Lucas
 */
public class CtrlConsumo implements ActionListener{
    
    List<Consumo> listConsumo;
    VistaConsumo vista;
    
    public CtrlConsumo(VistaConsumo vista, List<Consumo> listConsumo){
        this.vista = vista;
        this.listConsumo = listConsumo;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Ano":
            case "Mes":
            case "Dia":
            case "Hora":
            case "Anadir":
            default:
                break;
        }
    }
    
}
