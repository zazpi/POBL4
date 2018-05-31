/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.presentacion;

import java.util.List;
import pobl4.dominio.Consumo;
import pobl4.negocio.CtrlConsumo;

/**
 *
 * @author asier
 */
public class VistaConsumo extends javax.swing.JDialog {
    
    CtrlConsumo controlador;
    /**
     * Creates new form VistaConsumo
     */
    public VistaConsumo(java.awt.Frame parent, boolean modal,List<Consumo> listConsumo) {
        super(parent, modal);
        initComponents();
        controlador = new CtrlConsumo(this,listConsumo);
        addBtListeners();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelNombre = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        panelArriba = new javax.swing.JPanel();
        btAno = new javax.swing.JButton();
        btHora = new javax.swing.JButton();
        btDia = new javax.swing.JButton();
        btMes = new javax.swing.JButton();
        btAnadir = new javax.swing.JButton();
        panelDerecha = new javax.swing.JPanel();
        datosEstadisticos = new javax.swing.JLabel();
        periodoTiempo1 = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JComboBox<>();
        fechaFin = new javax.swing.JComboBox<>();
        labelConsumo = new javax.swing.JLabel();
        labelPunta = new javax.swing.JLabel();
        labelValle = new javax.swing.JLabel();
        labelMedia = new javax.swing.JLabel();
        consumo = new javax.swing.JLabel();
        punta = new javax.swing.JLabel();
        valle = new javax.swing.JLabel();
        mediaDia = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(905, 565));
        jPanel1.setMinimumSize(new java.awt.Dimension(905, 565));

        panelNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        labelNombre.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(16, 103, 218));
        labelNombre.setText("CONSUMO HISTÓRICO");

        javax.swing.GroupLayout panelNombreLayout = new javax.swing.GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(labelNombre)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        panelNombreLayout.setVerticalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNombreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNombre)
                .addContainerGap())
        );

        panelArriba.setBackground(new java.awt.Color(190, 191, 190));
        panelArriba.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btAno.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btAno.setText("Año");
        btAno.setActionCommand("Ano");
        btAno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btHora.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btHora.setText("Hora");
        btHora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btDia.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btDia.setText("Día");
        btDia.setActionCommand("Dia");
        btDia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btMes.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btMes.setText("Mes");
        btMes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btAnadir.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        btAnadir.setText("+");
        btAnadir.setActionCommand("Anadir");
        btAnadir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelArribaLayout = new javax.swing.GroupLayout(panelArriba);
        panelArriba.setLayout(panelArribaLayout);
        panelArribaLayout.setHorizontalGroup(
            panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btAno, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btMes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDia, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btHora, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        panelArribaLayout.setVerticalGroup(
            panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btHora)
                    .addComponent(btDia)
                    .addComponent(btMes)
                    .addComponent(btAno)
                    .addComponent(btAnadir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDerecha.setBackground(new java.awt.Color(190, 191, 190));
        panelDerecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        datosEstadisticos.setBackground(new java.awt.Color(1, 1, 1));
        datosEstadisticos.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        datosEstadisticos.setForeground(new java.awt.Color(1, 1, 1));
        datosEstadisticos.setText("DATOS ESTADÍSTICOS");

        periodoTiempo1.setBackground(new java.awt.Color(1, 1, 1));
        periodoTiempo1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        periodoTiempo1.setForeground(new java.awt.Color(1, 1, 1));
        periodoTiempo1.setText("Periodo de tiempo");

        fechaInicio.setMaximumRowCount(24);
        fechaInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fechaFin.setMaximumRowCount(24);
        fechaFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelConsumo.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        labelConsumo.setForeground(new java.awt.Color(1, 1, 1));
        labelConsumo.setText("Consumo: ");

        labelPunta.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        labelPunta.setForeground(new java.awt.Color(1, 1, 1));
        labelPunta.setText("Periodo Punta: ");

        labelValle.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        labelValle.setForeground(new java.awt.Color(1, 1, 1));
        labelValle.setText("Periodo Valle: ");

        labelMedia.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        labelMedia.setForeground(new java.awt.Color(1, 1, 1));
        labelMedia.setText("Media por día: ");

        consumo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        consumo.setText("0");

        punta.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        punta.setText("0");

        valle.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        valle.setText("0");

        mediaDia.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        mediaDia.setText("0");

        javax.swing.GroupLayout panelDerechaLayout = new javax.swing.GroupLayout(panelDerecha);
        panelDerecha.setLayout(panelDerechaLayout);
        panelDerechaLayout.setHorizontalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelDerechaLayout.createSequentialGroup()
                            .addComponent(labelValle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechaLayout.createSequentialGroup()
                            .addComponent(labelMedia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mediaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelDerechaLayout.createSequentialGroup()
                            .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelPunta)
                                .addComponent(labelConsumo))
                            .addGap(42, 42, 42)
                            .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(punta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(periodoTiempo1)
                            .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDerechaLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(datosEstadisticos)))
                        .addGap(11, 11, 11)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelDerechaLayout.setVerticalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(periodoTiempo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datosEstadisticos)
                .addGap(23, 23, 23)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConsumo)
                    .addComponent(consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPunta)
                    .addComponent(punta, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValle)
                    .addComponent(valle, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMedia)
                    .addComponent(mediaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelArriba, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addBtListeners(){
        btAnadir.addActionListener(controlador);
        btAno.addActionListener(controlador);
        btDia.addActionListener(controlador);
        btHora.addActionListener(controlador);
        btMes.addActionListener(controlador);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnadir;
    private javax.swing.JButton btAno;
    private javax.swing.JButton btDia;
    private javax.swing.JButton btHora;
    private javax.swing.JButton btMes;
    private javax.swing.JLabel consumo;
    private javax.swing.JLabel datosEstadisticos;
    private javax.swing.JComboBox<String> fechaFin;
    private javax.swing.JComboBox<String> fechaInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelConsumo;
    private javax.swing.JLabel labelMedia;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPunta;
    private javax.swing.JLabel labelValle;
    private javax.swing.JLabel mediaDia;
    private javax.swing.JPanel panelArriba;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JLabel periodoTiempo1;
    private javax.swing.JLabel punta;
    private javax.swing.JLabel valle;
    // End of variables declaration//GEN-END:variables
}
