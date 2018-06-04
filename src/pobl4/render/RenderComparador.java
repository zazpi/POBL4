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
		panel.add(new JLabel(new ImageIcon("Companias/iberdrola.png")),BorderLayout.WEST);
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.red),
				BorderFactory.createEmptyBorder(10,10,10,10)));

		panel.add(crearPanelInfo(value),BorderLayout.CENTER);
                panel.add(crearPanelPrecio(value),BorderLayout.EAST);
		
		if(isSelected) {
			panel.setBackground(Color.blue);
			panel.setOpaque(true);
		}
		
		return panel;
    }
    
    private Component crearPanelInfo(Simulacion value) {
		JPanel panelInfo = new JPanel(new GridLayout(5,1));
		
		JLabel nombre = new JLabel(value.getCompania().getNombre());
		nombre.setFont(new Font("arial",Font.BOLD,15));
		nombre.setForeground(Color.PINK);
		panelInfo.add(nombre);
		
		JLabel tarifa = new JLabel(value.getTarifa().getDescripcion());
		tarifa.setFont(new Font("arial",Font.PLAIN,10));
		panelInfo.add(tarifa);	
		
		JLabel renovable = new JLabel("Si");
		renovable.setFont(new Font("arial",Font.ITALIC,10));
		panelInfo.add(renovable);	

		return panelInfo;
    }

    private Component crearPanelPrecio(Simulacion value) {
        JPanel panelInfo = new JPanel(new BorderLayout(0,10));
		
		JLabel nombre = new JLabel("0");
		nombre.setFont(new Font("arial",Font.BOLD,30));
		nombre.setForeground(Color.BLACK);
		panelInfo.add(nombre);
                
               return panelInfo;

    }
   
	
}
