/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import pobl4.dao.ConsumoDAO;
import pobl4.dominio.Consumo;
import pobl4.presentacion.VistaAñadirConsumo;
import pobl4.presentacion.VistaConsumo;

/**
 *
 * @author Lucas
 */
public class CtrlConsumo implements ActionListener{
    
    List<Consumo> listConsumo;
    VistaConsumo vista;
    Estados estado;
    ConsumoDAO consumoDAO;
    
    public CtrlConsumo(VistaConsumo vista, List<Consumo> listConsumo, ConsumoDAO consumoDAO){
        this.vista = vista;
        this.listConsumo = listConsumo;
        this.consumoDAO = consumoDAO;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("Ano")) {
    		estado = new EstadoAño();
    		vista.disbaleFiltro("año");
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, null));
    	}
    	
    	if (e.getActionCommand().equals("Mes")) {
    		estado = new EstadoMes();
    		int params [] = {vista.getAño()};
    		vista.disbaleFiltro("mes");
    		vista.setGrafico(estado.getDatosGraficos(listConsumo,params));
    	}
    	if(e.getActionCommand().equals("Anadir")) {
    		VistaAñadirConsumo vistaAñadirConsumo = new VistaAñadirConsumo(vista, true,consumoDAO);
    	}
    }
    
}
