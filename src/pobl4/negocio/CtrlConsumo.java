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
import pobl4.dao.UserDAO;
import pobl4.dominio.Consumo;
import pobl4.presentacion.VistaAnadirConsumo;
import pobl4.presentacion.VistaConsumo;

/**
 *
 * @author Lucas
 */
public class CtrlConsumo implements ActionListener{
    
    List<Consumo> listConsumo;
    VistaConsumo vista;
    ConsumoDAO consumoDAO;
    UserDAO userDAO;
    
    public CtrlConsumo(VistaConsumo vista, List<Consumo> listConsumo, ConsumoDAO consumoDAO,UserDAO userDAO){
        this.vista = vista;
        this.listConsumo = listConsumo;
        this.consumoDAO = consumoDAO;
        this.userDAO = userDAO;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("Ano")) {
    		Estados estado = new EstadoAño();
    		int [] values = {vista.getAño()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, values));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, null));
    	}
    	
    	if (e.getActionCommand().equals("Mes")) {
    		Estados estado = new EstadoMes();
    		int params [] = {vista.getAño(),vista.getMes()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, params));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, params));
    	}
    	
    	if(e.getActionCommand().equals("Dia")) {
    		Estados estado = new EstadoDia();
    		int params [] = {vista.getAño(),vista.getMes(),vista.getDia()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, params));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, params));
    	}
    	
    	if(e.getActionCommand().equals("Hora")) {
    		Estados estado = new EstadoHora();
    		int params [] = {vista.getAño(),vista.getMes(),vista.getDia()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, params));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, params));
    	}
    	if(e.getActionCommand().equals("Anadir")) {
    		VistaAnadirConsumo vistaAñadirConsumo = new VistaAnadirConsumo(vista, true,consumoDAO,userDAO);
    	}
    }
    
    
}
