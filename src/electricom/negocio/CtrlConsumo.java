/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricom.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import electricom.dao.ConsumoDAO;
import electricom.dao.UserDAO;
import electricom.dominio.Consumo;
import electricom.presentacion.VistaAnadirConsumo;
import electricom.presentacion.VistaConsumo;

/**
 *
 * @author Lucas
 */
public class CtrlConsumo implements ActionListener{
    
    List<Consumo> listConsumo;
    VistaConsumo vista;
    ConsumoDAO consumoDAO;
    UserDAO userDAO;
    CtrlMain main;
    Estados estado;
    
    public CtrlConsumo(VistaConsumo vista, List<Consumo> listConsumo, ConsumoDAO consumoDAO,UserDAO userDAO, CtrlMain main){
        this.vista = vista;
        this.listConsumo = listConsumo;
        this.consumoDAO = consumoDAO;
        this.userDAO = userDAO;
        this.main = main;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("Ano")) {
    		estado = new EstadoAno();
    		int [] values = {vista.getAño()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, values));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, null));
    		vista.getFechaAno().setEnabled(false);
    		vista.getFechaMes().setEnabled(false);
    		vista.getFechaDia().setEnabled(false);
    	}
    	
    	if (e.getActionCommand().equals("Mes")) {
    		estado = new EstadoMes();
    		int params [] = {vista.getAño(),vista.getMes()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, params));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, params));
    		vista.getFechaAno().setEnabled(true);
    		vista.getFechaMes().setEnabled(false);
    		vista.getFechaDia().setEnabled(false);
    	}
    	
    	if(e.getActionCommand().equals("Dia")) {
    		 estado = new EstadoDia();
    		int params [] = {vista.getAño(),vista.getMes(),vista.getDia()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, params));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, params));
    		vista.getFechaAno().setEnabled(true);
    		vista.getFechaMes().setEnabled(true);
    		vista.getFechaDia().setEnabled(false);
    	}
    	
    	if(e.getActionCommand().equals("Hora")) {
    	    estado = new EstadoHora();
    		int params [] = {vista.getAño(),vista.getMes(),vista.getDia()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, params));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, params));
    		vista.getFechaAno().setEnabled(true);
    		vista.getFechaMes().setEnabled(true);
    		vista.getFechaDia().setEnabled(true);
    	}
    	if(e.getActionCommand().equals("Anadir")) {
    		new VistaAnadirConsumo(vista, true,consumoDAO,userDAO);
    		main.loadUserData();
    	}
    	if(e.getActionCommand().equals("Calcular")) {
    		int params [] = {vista.getAño(),vista.getMes(),vista.getDia()};
    		vista.setEstadisticos(estado.getEstadisticos(listConsumo, params));
    		vista.setGrafico(estado.getDatosGraficos(listConsumo, params));
    	}
    }
    
    
    
}
