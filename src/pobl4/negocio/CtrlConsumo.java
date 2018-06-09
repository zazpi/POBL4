/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import pobl4.dao.ConsumoDAO;
import pobl4.dominio.Consumo;
import pobl4.presentacion.VistaAnadirConsumo;
import pobl4.presentacion.VistaConsumo;
import pobl4.utils.Utils;

/**
 *
 * @author Lucas
 */
public class CtrlConsumo implements ActionListener{
    
    List<Consumo> listConsumo;
    VistaConsumo vista;
    ConsumoDAO consumoDAO;
    
    public CtrlConsumo(VistaConsumo vista, List<Consumo> listConsumo, ConsumoDAO consumoDAO){
        this.vista = vista;
        this.listConsumo = listConsumo;
        this.consumoDAO = consumoDAO;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("Ano")) {
    		Estados estado = new EstadoAño();
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, null));
    	}
    	
    	if (e.getActionCommand().equals("Mes")) {
    		Estados estado = new EstadoMes();
    		int params [] = {vista.getAño()};
    		Map<String,Double> datosGrafico = estado.getDatosGraficos(listConsumo, params);
    		vista.setGrafico(datosGrafico);
    	}
    	if(e.getActionCommand().equals("Anadir")) {
    		VistaAnadirConsumo vistaAñadirConsumo = new VistaAnadirConsumo(vista, true,consumoDAO);
    	}
    }
    
    
}
