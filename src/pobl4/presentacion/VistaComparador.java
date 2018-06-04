/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.presentacion;

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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import pobl4.dominio.Simulacion;
import pobl4.negocio.CtrlComparador;
import popbl4.render.RenderComparador;

/**
 *
 * @author asier
 */
public class VistaComparador extends javax.swing.JDialog {

    final static public String BT_ANO = "btAno";
    final static public String BT_MES = "btMes";
    
    JList <Simulacion> listaSimulaciones;
    RenderComparador render;
    CtrlComparador controlador;
    
    public VistaComparador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        render = new RenderComparador();
        initComponents();
        addListeners();
    }
    
    public void addListeners(){
        fechaAño.addItemListener(controlador);
        fechaMes.addItemListener(controlador);
        sinDiscriminacion.addItemListener(controlador);
        discriminacion1.addItemListener(controlador);  
        discriminacion2.addItemListener(controlador);
        soloRenovable.addItemListener(controlador);
        addListener(btAno,BT_ANO);
        addListener(btMes,BT_MES);
    }
    
    public void addListener(JButton bt, String actionCommand){
        bt.addActionListener(controlador);
        bt.setActionCommand(actionCommand);
    }

    public JComboBox<String> getFechaAño() {
        return fechaAño;
    }

    public JComboBox<String> getFechaMes() {
        return fechaMes;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel panelArriba = new JPanel();
        btMes = new JButton();
        JButton btAnadir = new JButton();
        btAno = new JButton();
        JPanel panelDerecha = new JPanel();
        JLabel lbTiempo = new JLabel();
        fechaAño = new JComboBox<>();
        fechaMes = new JComboBox<>();
        JLabel tipoTarifa = new JLabel();
        sinDiscriminacion = new JCheckBox();
        discriminacion1 = new JCheckBox();
        discriminacion2 = new JCheckBox();
        JLabel renovable = new JLabel();
        soloRenovable = new JCheckBox();
        JPanel panelNombre = new JPanel();
        JLabel labelNombre = new JLabel();
        panelLista = new JScrollPane();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new Dimension(905, 565));
        jPanel1.setMinimumSize(new Dimension(905, 565));

        panelArriba.setBackground(new Color(190, 191, 190));
        panelArriba.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        btMes.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        btMes.setText("Mes");
        btMes.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        btAnadir.setFont(new Font("Ubuntu", 1, 20)); // NOI18N
        btAnadir.setText("+");
        btAnadir.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        btAno.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        btAno.setText("Año");
        btAno.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        GroupLayout panelArribaLayout = new GroupLayout(panelArriba);
        panelArriba.setLayout(panelArribaLayout);
        panelArribaLayout.setHorizontalGroup(panelArribaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btAno, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btMes, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAnadir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        panelArribaLayout.setVerticalGroup(panelArribaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArribaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelArribaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelArribaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btAno)
                            .addComponent(btMes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btAnadir))
                .addContainerGap())
        );

        panelDerecha.setBackground(new Color(190, 191, 190));
        panelDerecha.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        lbTiempo.setBackground(new Color(1, 1, 1));
        lbTiempo.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        lbTiempo.setForeground(new Color(1, 1, 1));
        lbTiempo.setText("Tiempo");

        fechaAño.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        fechaAño.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fechaMes.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        fechaMes.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tipoTarifa.setBackground(new Color(1, 1, 1));
        tipoTarifa.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        tipoTarifa.setForeground(new Color(1, 1, 1));
        tipoTarifa.setText("Tipo de tarifa");

        sinDiscriminacion.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        sinDiscriminacion.setText("Sin discriminación");

        discriminacion1.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        discriminacion1.setText("Discriminación 2");

        discriminacion2.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        discriminacion2.setText("Discriminación 1");

        renovable.setBackground(new Color(1, 1, 1));
        renovable.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        renovable.setForeground(new Color(1, 1, 1));
        renovable.setText("Renovable");

        soloRenovable.setFont(new Font("Ubuntu", 0, 18)); // NOI18N
        soloRenovable.setText("Solo renovables");

        GroupLayout panelDerechaLayout = new GroupLayout(panelDerecha);
        panelDerecha.setLayout(panelDerechaLayout);
        panelDerechaLayout.setHorizontalGroup(panelDerechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelDerechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(renovable)
                    .addComponent(tipoTarifa)
                    .addComponent(lbTiempo)
                    .addComponent(fechaMes, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaAño, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDerechaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelDerechaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(sinDiscriminacion)
                            .addComponent(discriminacion2, GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.LEADING, panelDerechaLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(soloRenovable))
                            .addComponent(discriminacion1, GroupLayout.Alignment.LEADING))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelDerechaLayout.setVerticalGroup(panelDerechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lbTiempo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaAño, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoTarifa)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sinDiscriminacion)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(discriminacion2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(discriminacion1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(renovable)
                .addGap(18, 18, 18)
                .addComponent(soloRenovable)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        panelNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        labelNombre.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        labelNombre.setForeground(new Color(16, 103, 218));
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setText("COMPARADOR DE TARIFAS");

        GroupLayout panelNombreLayout = new GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(labelNombre)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        panelNombreLayout.setVerticalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombre)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelLista)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDerecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(panelArriba, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelArriba, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelDerecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLista)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton btAno;
    JButton btMes;
    JCheckBox discriminacion1;
    JCheckBox discriminacion2;
    private JComboBox<String> fechaAño;
    private JComboBox<String> fechaMes;
    JScrollPane panelLista;
    JCheckBox sinDiscriminacion;
    JCheckBox soloRenovable;
    // End of variables declaration//GEN-END:variables

    public void actualizarLista(List<Simulacion> listaSimulacion) {
        listaSimulaciones = new JList(listaSimulacion.toArray(new Simulacion[0]));
        listaSimulaciones.setCellRenderer(render);
        panelLista.setViewportView(listaSimulaciones);
    }
}
