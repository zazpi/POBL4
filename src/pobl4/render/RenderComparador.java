/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import pobl4.dominio.Simulacion;

/**
 *
 * @author asier
 */
public class RenderComparador implements ListCellRenderer<Simulacion>{

    public RenderComparador() {
        
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Simulacion> list, Simulacion value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        
		panel.add(new JLabel(new ImageIcon("Companias/"+ value.getCompania().getNombre().toLowerCase()+".png")),BorderLayout.WEST);
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10),BorderFactory.createLoweredBevelBorder()));
                
		panel.add(crearPanelInfo(value),BorderLayout.CENTER);
                panel.add(crearPanelPrecio(value),BorderLayout.EAST);
             
		return panel;
    }
    
    private Component crearPanelInfo(Simulacion value) {
		JPanel panelInfo = new JPanel(new GridLayout(3,1));
		
		JLabel nombre = new JLabel(value.getCompania().getNombre());
		nombre.setFont(new Font("arial",Font.BOLD,20));
		nombre.setForeground(Color.BLACK);
		panelInfo.add(nombre);
                
    
		JLabel tarifa = new JLabel("Tarifa:  " + value.getTarifa().getDescripcion());
		tarifa.setFont(new Font("arial",Font.PLAIN,15));
		panelInfo.add(tarifa);	
                
		
		JLabel renovable = new JLabel("Renovable:  " + (value.getTarifa().isRenovable()?"Si":"No"));
		renovable.setFont(new Font("arial",Font.ITALIC,15));
		panelInfo.add(renovable);	

		return panelInfo;
    }

    private Component crearPanelPrecio(Simulacion value) {
        JPanel panelInfo = new JPanel(new BorderLayout(0,10));
		
		JLabel precio = new JLabel(String.format ("%.5f", value.getTotal()));
                
                precio.setBorder(BorderFactory.createEmptyBorder(0,0,0,30));
                
		precio.setFont(new Font("arial",Font.BOLD,30));
		precio.setForeground(Color.BLACK);
		panelInfo.add(precio);
                
               return panelInfo;

    }
   
}
