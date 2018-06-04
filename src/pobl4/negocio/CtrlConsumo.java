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
    Estados estado;
    
    public CtrlConsumo(VistaConsumo vista, List<Consumo> listConsumo){
        this.vista = vista;
        this.listConsumo = listConsumo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("Ano")) {
    		estado = new EstadoAño();
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, null));
    	}
    	
    	else if (e.getActionCommand().equals("Mes")) {
    		estado = new EstadoMes();
    		int [] params = {2010,1};
    		vista.setGrafico(estado.getDatosGraficos(listConsumo,params));
    	}
    }
    
}
