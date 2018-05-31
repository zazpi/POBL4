/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.presentacion;

/**
 *
 * @author asier
 */
public class VistaComparador extends javax.swing.JDialog {

    /**
     * Creates new form VistaComparador2
     */
    public VistaComparador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        panelArriba = new javax.swing.JPanel();
        btMes = new javax.swing.JButton();
        btDia = new javax.swing.JButton();
        btHora = new javax.swing.JButton();
        btAnadir = new javax.swing.JButton();
        btAno = new javax.swing.JButton();
        panelDerecha = new javax.swing.JPanel();
        periodoTiempo = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JComboBox<>();
        fechaFin = new javax.swing.JComboBox<>();
        tipoTarifa = new javax.swing.JLabel();
        sinDiscriminacion = new javax.swing.JCheckBox();
        discriminacion1 = new javax.swing.JCheckBox();
        discriminacion2 = new javax.swing.JCheckBox();
        renovable = new javax.swing.JLabel();
        soloRenovable = new javax.swing.JCheckBox();
        panelIzquierda = new javax.swing.JScrollPane();
        listaCompanias = new javax.swing.JList<>();
        panelNombre = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(905, 565));
        jPanel1.setMinimumSize(new java.awt.Dimension(905, 565));

        panelArriba.setBackground(new java.awt.Color(190, 191, 190));
        panelArriba.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btMes.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btMes.setText("Mes");
        btMes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMesActionPerformed(evt);
            }
        });

        btDia.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btDia.setText("Día");
        btDia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btHora.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btHora.setText("Hora");
        btHora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btAnadir.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        btAnadir.setText("+");
        btAnadir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btAno.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btAno.setText("Año");
        btAno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelArribaLayout = new javax.swing.GroupLayout(panelArriba);
        panelArriba.setLayout(panelArribaLayout);
        panelArribaLayout.setHorizontalGroup(
            panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btAno, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btMes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDia, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btHora, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        panelArribaLayout.setVerticalGroup(
            panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArribaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAno)
                            .addComponent(btMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btHora)))
                    .addComponent(btAnadir))
                .addContainerGap())
        );

        panelDerecha.setBackground(new java.awt.Color(190, 191, 190));
        panelDerecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        periodoTiempo.setBackground(new java.awt.Color(1, 1, 1));
        periodoTiempo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        periodoTiempo.setForeground(new java.awt.Color(1, 1, 1));
        periodoTiempo.setText("Periodo de tiempo");

        fechaInicio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        fechaInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaInicioActionPerformed(evt);
            }
        });

        fechaFin.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        fechaFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tipoTarifa.setBackground(new java.awt.Color(1, 1, 1));
        tipoTarifa.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        tipoTarifa.setForeground(new java.awt.Color(1, 1, 1));
        tipoTarifa.setText("Tipo de tarifa");

        sinDiscriminacion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        sinDiscriminacion.setText("Sin discriminación");
        sinDiscriminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinDiscriminacionActionPerformed(evt);
            }
        });

        discriminacion1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        discriminacion1.setText("Discriminación 2");

        discriminacion2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        discriminacion2.setText("Discriminación 1");

        renovable.setBackground(new java.awt.Color(1, 1, 1));
        renovable.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        renovable.setForeground(new java.awt.Color(1, 1, 1));
        renovable.setText("Renovable");

        soloRenovable.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        soloRenovable.setText("Solo renovables");
        soloRenovable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soloRenovableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDerechaLayout = new javax.swing.GroupLayout(panelDerecha);
        panelDerecha.setLayout(panelDerechaLayout);
        panelDerechaLayout.setHorizontalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(renovable)
                    .addComponent(tipoTarifa)
                    .addComponent(periodoTiempo)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDerechaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sinDiscriminacion)
                            .addComponent(discriminacion2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDerechaLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(soloRenovable))
                            .addComponent(discriminacion1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelDerechaLayout.setVerticalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(periodoTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoTarifa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sinDiscriminacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(discriminacion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(discriminacion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(renovable)
                .addGap(18, 18, 18)
                .addComponent(soloRenovable)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        listaCompanias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        listaCompanias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        panelIzquierda.setViewportView(listaCompanias);

        panelNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        labelNombre.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(16, 103, 218));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("COMPARADOR DE TARIFAS");

        javax.swing.GroupLayout panelNombreLayout = new javax.swing.GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(labelNombre)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        panelNombreLayout.setVerticalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelIzquierda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelArriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIzquierda)
                    .addComponent(panelDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void btMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMesActionPerformed

    private void btAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAnoActionPerformed

    private void fechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioActionPerformed

    private void sinDiscriminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinDiscriminacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sinDiscriminacionActionPerformed

    private void soloRenovableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soloRenovableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soloRenovableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaComparador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaComparador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaComparador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaComparador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaComparador dialog = new VistaComparador(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnadir;
    private javax.swing.JButton btAno;
    private javax.swing.JButton btDia;
    private javax.swing.JButton btHora;
    private javax.swing.JButton btMes;
    private javax.swing.JCheckBox discriminacion1;
    private javax.swing.JCheckBox discriminacion2;
    private javax.swing.JComboBox<String> fechaFin;
    private javax.swing.JComboBox<String> fechaInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JList<String> listaCompanias;
    private javax.swing.JPanel panelArriba;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JScrollPane panelIzquierda;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JLabel periodoTiempo;
    private javax.swing.JLabel renovable;
    private javax.swing.JCheckBox sinDiscriminacion;
    private javax.swing.JCheckBox soloRenovable;
    private javax.swing.JLabel tipoTarifa;
    // End of variables declaration//GEN-END:variables
}
