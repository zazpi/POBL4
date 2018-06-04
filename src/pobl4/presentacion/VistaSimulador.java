package pobl4.presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import pobl4.dominio.Compania;
import pobl4.negocio.CtrlSimulador;
import pobl4.dominio.User;
import pobl4.dominio.Simulacion;
import pobl4.dominio.Tarifa;

public class VistaSimulador extends javax.swing.JDialog {
    final static public String TXT_DIAS = "txtDias";
    final static public String TXT_VALLE = "txtValle";
    final static public String TXT_PUNTA = "txtPunta";
    final static public String TXT_SUPERVALLE = "txtSuperValle";
    final static public String TXT_POTENCIA = "txtPotencia";
    
    CtrlSimulador controlador;
    User usuario;
    List<Compania> companias;
    Simulacion modelo;
    
    public VistaSimulador(JFrame parent, boolean modal,CtrlSimulador controlador,User usuario,Simulacion modelo,List<Compania> companias) {
        super(parent, modal);
        this.controlador = controlador;
        this.usuario = usuario;
        this.modelo = modelo;
        this.companias = companias;
        
        controlador.setVista(this);
        initComponents();
        addListeners();
        
      /*  modelo.setCompania(companias.get(0));
        actualizarComboBox();*/
        
        this.setVisible(true);
    }
    
    public void addListeners(){
        compania.addItemListener(controlador);
        btAyuda.addActionListener(controlador);
        btAyuda.setActionCommand("ayuda");
    }
    
    public void actualizarTabla(){
        tablaFactura.getModel().setValueAt(modelo.getPorEnergia(), 0, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorPotencia(), 1, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorImpuestos(), 2, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorIva(), 4, 1);
    }
    
    public void actualizarComboBox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel(modelo.getCompania().getTarifas().toArray(new Tarifa[0]) );
        tarifa.setModel(model);  
    }
    
    public double getPotencia(){
        return Double.parseDouble(txPotenciaContratada.getText());
    }
    public double getValle(){
        return Double.parseDouble(txValle.getText());
    }
    public double getPunta(){
        return Double.parseDouble(txPunta.getText());
    }
    public double getSuperValle(){
        return Double.parseDouble(txSuperValle.getText());
    }   
    public int getDias(){
        return Integer.parseInt(txDias.getText());
    }
    public Tarifa getTarifa(){
        return (Tarifa) tarifa.getSelectedItem();
    }
    public Compania getCompania(){
        return (Compania) compania.getSelectedItem();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel panelNombreç = new JPanel();
        JLabel labelNombre = new JLabel();
        JPanel panelDatos = new JPanel();
        JLabel labelCompania = new JLabel();
        compania = new JComboBox<>(companias.toArray(new Compania[0]));
        JLabel labelTarifa = new JLabel();
        tarifa = new JComboBox<>();
        JLabel labelPContratada = new JLabel();
        txPotenciaContratada = new JTextField();
        JLabel labelConsumo = new JLabel();
        txPunta = new JTextField();
        txValle = new JTextField();
        txSuperValle = new JTextField();
        JButton btCargar = new JButton();
        JLabel labelDias = new JLabel();
        txDias = new JTextField();
        btAyuda = new JButton();
        JButton btAnadir = new JButton();
        JPanel panelGrafico = new JPanel();
        JScrollPane panelTabla = new JScrollPane();
        tablaFactura = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new Dimension(905, 565));
        jPanel1.setMinimumSize(new Dimension(905, 565));

        panelNombreç.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        labelNombre.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        labelNombre.setForeground(new Color(16, 103, 218));
        labelNombre.setText("SIMULADOR DE FACTURAS");

        GroupLayout panelNombreçLayout = new GroupLayout(panelNombreç);
        panelNombreç.setLayout(panelNombreçLayout);
        panelNombreçLayout.setHorizontalGroup(panelNombreçLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreçLayout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(labelNombre)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNombreçLayout.setVerticalGroup(panelNombreçLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelNombreçLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelNombre)
                .addContainerGap())
        );

        panelDatos.setBackground(new Color(190, 191, 190));
        panelDatos.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        labelCompania.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelCompania.setForeground(new Color(1, 1, 1));
        labelCompania.setText("Compañía: ");

        labelTarifa.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelTarifa.setForeground(new Color(1, 1, 1));
        labelTarifa.setText("Tarifa: ");

        labelPContratada.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelPContratada.setForeground(new Color(1, 1, 1));
        labelPContratada.setText("Potencia contratada: ");

        labelConsumo.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelConsumo.setForeground(new Color(1, 1, 1));
        labelConsumo.setText("Consumo: ");

        btCargar.setText("Cargar desde  histórico");

        labelDias.setFont(new Font("Ubuntu", 1, 18)); // NOI18N
        labelDias.setForeground(new Color(1, 1, 1));
        labelDias.setText("Días: ");

        btAyuda.setText("Ayuda");

        btAnadir.setFont(new Font("Ubuntu", 1, 20)); // NOI18N
        btAnadir.setText("+");
        btAnadir.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        GroupLayout panelDatosLayout = new GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(labelDias)
                        .addGap(18, 18, 18)
                        .addComponent(txDias, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAyuda, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(labelPContratada)
                        .addGap(18, 18, 18)
                        .addComponent(txPotenciaContratada, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(labelConsumo)
                        .addGap(18, 18, 18)
                        .addComponent(txPunta, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txValle, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txSuperValle, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btCargar, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(labelCompania)
                        .addGap(18, 18, 18)
                        .addComponent(compania, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(labelTarifa)
                        .addGap(18, 18, 18)
                        .addComponent(tarifa, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btAnadir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGap(101, 101, 101))
        );
        panelDatosLayout.setVerticalGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCompania)
                    .addComponent(compania, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTarifa)
                    .addComponent(tarifa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAnadir))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labelPContratada)
                    .addComponent(txPotenciaContratada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConsumo)
                    .addComponent(txPunta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txValle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSuperValle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCargar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDias)
                    .addComponent(txDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAyuda))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        panelGrafico.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        GroupLayout panelGraficoLayout = new GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(panelGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(panelGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        tablaFactura.setBackground(new Color(190, 191, 190));
        tablaFactura.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        tablaFactura.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        tablaFactura.setForeground(new Color(1, 1, 1));
        tablaFactura.setModel(new DefaultTableModel(
            new Object [][] {
                {"  Por energía utilizada", null},
                {"  Por potencia contratada", null},
                {"  Impuesto electricidad", null},
                {"  Alquiler contador", null},
                {"  Otros conceptos", null},
                {"  IVA 21%", null},
                {"  Total", null}
            },
            new String [] {
                "Concepto", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                Object.class, Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFactura.setRowHeight(37);
        panelTabla.setViewportView(tablaFactura);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelNombreç, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDatos, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(panelTabla, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGrafico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelNombreç, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGrafico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTabla, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 577, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton btAyuda;
    JComboBox<Compania> compania;
    JTable tablaFactura;
    JComboBox<Tarifa> tarifa;
    JTextField txDias;
    JTextField txPotenciaContratada;
    JTextField txPunta;
    JTextField txSuperValle;
    JTextField txValle;
    // End of variables declaration//GEN-END:variables
}
