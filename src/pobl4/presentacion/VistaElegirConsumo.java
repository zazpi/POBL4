/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

import pobl4.dominio.Consumo;
import pobl4.utils.Utils;


public class VistaElegirConsumo extends JDialog implements ActionListener {
	List<Consumo> consumos;
	int consumoPunta, consumoValle, consumoSuperValle, numDias;
	
    public VistaElegirConsumo(JDialog parent, boolean modal, List<Consumo> consumos) {
        super(parent, modal);
        this.consumos = consumos;
        initComponents();
        setComboBoxes();
        setListeners();
        this.setVisible(true);
    }
    
    
    public void setListeners() {
    	btAceptar.addActionListener(this);
    }
    
    public void setComboBoxes() {
        DefaultComboBoxModel modeloAno = new DefaultComboBoxModel(Utils.getListaAnos(consumos).toArray(new Integer[0]));
        comboAño.setModel(modeloAno);
        DefaultComboBoxModel modeloMes = new DefaultComboBoxModel(Utils.getListaMeses(consumos).toArray(new String[0]));
        comboMes.setModel(modeloMes); 
    }
    
    public int getPunta() { 
    	return consumoPunta;
    }
    
    public int getValle() { 
    	return consumoValle;
    }
    
    public int getSuperValle() { 
    	return consumoSuperValle;
    }
    
    public int getDias() {
    	return numDias;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboAño = new JComboBox<>();
        comboMes = new JComboBox<>();
        btAceptar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        btAceptar.setText("jButton1");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btAceptar)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(comboMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboAño, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(comboAño, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(comboMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btAceptar)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton btAceptar;
    JComboBox<String> comboAño;
    JComboBox<String> comboMes;
    // End of variables declaration//GEN-END:variables
}
