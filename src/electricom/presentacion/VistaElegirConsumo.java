/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricom.presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import electricom.dominio.Consumo;
import electricom.utils.ConsumoFactory;
import electricom.utils.Utils;


public class VistaElegirConsumo extends JDialog implements ActionListener {
	List<Consumo> consumos;
	double consumoPunta, consumoValle, consumoSuperValle;
	int numDias;
	
    public VistaElegirConsumo(JDialog parent, boolean modal, List<Consumo> consumos) {
        super(parent, modal);
        this.consumos = consumos;
        initComponents();
        setComboBoxes();
        setListeners();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    public void setListeners() {
    	btAceptar.addActionListener(this);
    }
    
    public void setComboBoxes() {
        DefaultComboBoxModel modeloAno = new DefaultComboBoxModel(Utils.getListaAnos(consumos).toArray(new Integer[0]));
        comboAño.setModel(modeloAno);
        DefaultComboBoxModel modeloMes = new DefaultComboBoxModel(Utils.getListaMeses(consumos,(int)modeloAno.getSelectedItem()).toArray(new String[0]));
        comboMes.setModel(modeloMes); 
    }
    
    public double getPunta() { 
    	return consumoPunta;
    }
    
    public double getValle() { 
    	return consumoValle;
    }
    
    public double getSuperValle() { 
    	return consumoSuperValle;
    }
    
    public int getDias() {
    	return numDias;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		int año = (int) comboAño.getSelectedItem();
		int mes = Utils.translateStringToMonth((String)comboMes.getSelectedItem());
		List<Consumo>  consumosElegidos = Utils.filtrarConsumo(consumos,año, mes);
		
		consumoPunta = Utils.calcularConsumoPeriodo(consumosElegidos,ConsumoFactory.getFiltroPunta());
		consumoValle = Utils.calcularConsumoPeriodo(consumosElegidos,ConsumoFactory.getFiltroValle());
		consumoSuperValle = Utils.calcularConsumoPeriodo(consumosElegidos,ConsumoFactory.getFiltroSuperValle());
		numDias = consumosElegidos.size() / 24;
		this.dispose();
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel panelNombre = new JPanel();
        JLabel labelNombre = new JLabel();
        JPanel jPanel1 = new JPanel();
        comboAño = new JComboBox<>();
        comboMes = new JComboBox<>();
        btAceptar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new Dimension(324, 250));
        setMinimumSize(new Dimension(324, 250));

        panelNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        labelNombre.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        labelNombre.setForeground(new Color(16, 103, 218));
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setText("ELEGIR CONSUMO");

        GroupLayout panelNombreLayout = new GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(labelNombre)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNombreLayout.setVerticalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelNombreLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNombre)
                .addContainerGap())
        );

        jPanel1.setBackground(new Color(190, 191, 190));
        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        btAceptar.setText("Aceptar");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboAño, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMes, 0, 177, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btAceptar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(comboAño, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btAceptar)
                .addGap(27, 27, 27))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton btAceptar;
    JComboBox<String> comboAño;
    JComboBox<String> comboMes;
    // End of variables declaration//GEN-END:variables
}
