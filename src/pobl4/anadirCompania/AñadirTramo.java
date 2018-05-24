/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.anadirCompania;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author asier
 */
public class AñadirTramo extends javax.swing.JPanel {

    /**
     * Creates new form AñadirTramo
     */
    public AñadirTramo() {
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

        JPanel panelNombre = new JPanel();
        JLabel labelNombre = new JLabel();
        JPanel panelDatos = new JPanel();
        JLabel labelHoraInicio = new JLabel();
        JLabel labelMesInicio = new JLabel();
        JLabel labelHoraFin = new JLabel();
        JLabel labelMesFin = new JLabel();
        JLabel labelPrecio = new JLabel();
        JTextField txHoraInicio = new JTextField();
        JTextField txHoraFin = new JTextField();
        JTextField txMesInicio = new JTextField();
        JTextField txMesFin = new JTextField();
        JTextField txPrecio = new JTextField();
        JButton btCancelar = new JButton();
        JButton btGuardar = new JButton();

        setMaximumSize(new Dimension(400, 418));
        setMinimumSize(new Dimension(400, 418));
        setPreferredSize(new Dimension(400, 418));

        panelNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        labelNombre.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        labelNombre.setForeground(new Color(16, 103, 218));
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setText("AÑADIR TRAMO");

        GroupLayout panelNombreLayout = new GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelNombreLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNombre)
                .addGap(134, 134, 134))
        );
        panelNombreLayout.setVerticalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelNombreLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNombre)
                .addContainerGap())
        );

        panelDatos.setBackground(new Color(190, 191, 190));
        panelDatos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        labelHoraInicio.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelHoraInicio.setForeground(new Color(1, 1, 1));
        labelHoraInicio.setText("Hora inicio: ");

        labelMesInicio.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelMesInicio.setForeground(new Color(1, 1, 1));
        labelMesInicio.setText("Mes inicio: ");

        labelHoraFin.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelHoraFin.setForeground(new Color(1, 1, 1));
        labelHoraFin.setText("Hora fin: ");

        labelMesFin.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelMesFin.setForeground(new Color(1, 1, 1));
        labelMesFin.setText("Mes fin: ");

        labelPrecio.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelPrecio.setForeground(new Color(1, 1, 1));
        labelPrecio.setText("Precio: ");

        txHoraInicio.setText("horaInicio");

        txHoraFin.setText("horaFin");
        txHoraFin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txHoraFinActionPerformed(evt);
            }
        });

        txMesInicio.setText("mesInicio");

        txMesFin.setText("mesFin");

        txPrecio.setText("precio");

        btCancelar.setText("Cancelar");
        btCancelar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        btGuardar.setText("Guardar");
        btGuardar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        GroupLayout panelDatosLayout = new GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrecio)
                    .addComponent(labelMesFin)
                    .addComponent(labelMesInicio)
                    .addComponent(labelHoraFin)
                    .addComponent(labelHoraInicio))
                .addGap(40, 40, 40)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txHoraInicio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txHoraFin, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMesInicio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMesFin, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPrecio, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btGuardar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCancelar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHoraInicio)
                    .addComponent(txHoraInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHoraFin)
                    .addComponent(txHoraFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMesInicio)
                    .addComponent(txMesInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMesFin)
                    .addComponent(txMesFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecio)
                    .addComponent(txPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btGuardar))
                .addGap(25, 25, 25))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDatos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txHoraFinActionPerformed(ActionEvent evt) {//GEN-FIRST:event_txHoraFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHoraFinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
