package pobl4.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.xswingx.PromptSupport;

import org.jfree.chart.ChartPanel;

import pobl4.dominio.Compania;
import pobl4.negocio.CtrlSimulador;
import pobl4.negocio.GraficoFactory;
import pobl4.dominio.SimulacionEstatica;
import pobl4.dominio.Tarifa;

public class VistaSimulador extends JDialog implements ItemListener{
    CtrlSimulador controlador;
    List<Compania> listaCompanias;
    SimulacionEstatica modelo;
    
    public VistaSimulador(JFrame parent, boolean modal,CtrlSimulador controlador,SimulacionEstatica modelo,List<Compania> listaCompanias) {
        super(parent, modal);
        this.controlador = controlador;
        this.modelo = modelo;
        this.listaCompanias = listaCompanias;   
        controlador.setVista(this);
        initComponents();
        addPromptText();
        addListeners();
        actualizarComboBox();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void addListeners(){
        compania.addItemListener(this);
        setListener(btAyuda,"ayuda");
        setListener(btAnadir,"anadir");
        setListener(btSimularFactura,"simular");
        setListener(btCargar,"cargar");
    }
    
    public void setListener(JButton boton, String actionCommand) {
    	boton.setActionCommand(actionCommand);
    	boton.addActionListener(controlador);
    }
    
    public void actualizarTabla(){
        tablaFactura.getModel().setValueAt(modelo.getPorEnergia(), 0, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorPunta(), 1, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorValle(), 2, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorSuperValle(), 3, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorPotencia(), 4, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorImpuestos(), 5, 1);
        tablaFactura.getModel().setValueAt(modelo.getPorIva(), 6, 1);
        tablaFactura.getModel().setValueAt(modelo.getTotal(), 7, 1);
        actualizarGrafico();
    }
    
    public void actualizarGrafico() {
    	ChartPanel chartPanel = GraficoFactory.getGraficoTarta(mapear());
    	chartPanel.setSize(panelGrafico.getSize());
    	panelGrafico.removeAll();
    	panelGrafico.add(chartPanel,BorderLayout.CENTER);
    	this.repaint();
    }
    public Map<String, Double> mapear(){
    	Map<String,Double> map = new LinkedHashMap<>();
    	map.put("Consumo Valle", modelo.getPorValle());
    	map.put("Consumo Punta", modelo.getPorPunta());
    	map.put("Consumo SuperValle", modelo.getPorSuperValle());
    	map.put("Potencia", modelo.getPorPotencia());
    	map.put("Impuesto eléctrico", modelo.getPorImpuestos());
    	map.put("IVA", modelo.getPorIva());
    	return map;
    }
    
	@Override // ACTUALIZAR COMBO BOX
	public void itemStateChanged(ItemEvent e) {
		actualizarComboBox();
	}
	
    public void actualizarComboBox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel(((Compania)compania.getSelectedItem()).getTarifas().toArray(new Tarifa[0]) );
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
    
	public void mostrarError() {
		JOptionPane.showMessageDialog(this, "Debes introducir todos los valores correctamente","ERROR",JOptionPane.WARNING_MESSAGE);
	}
	
	public void setValle(int val) {
		txValle.setText(String.valueOf(val));
	}
	public void setPunta(int val) {
		txPunta.setText(String.valueOf(val));
	}
	public void setSuperValle(int val) {
		txSuperValle.setText(String.valueOf(val));
	}
	public void setDias(int val) {
		txDias.setText(String.valueOf(val));
	}
        
        public void addPromptText() {
		PromptSupport.setPrompt("potencia", txPotenciaContratada);
		PromptSupport.setPrompt("días", txDias);
		PromptSupport.setPrompt("punta", txPunta);
		PromptSupport.setPrompt("valle", txValle);
		PromptSupport.setPrompt("supervalle", txSuperValle);
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
        JPanel panelNombre = new JPanel();
        JLabel labelNombre = new JLabel();
        JPanel panelDatos = new JPanel();
        JLabel labelCompania = new JLabel();
        compania = new JComboBox<>(listaCompanias.toArray(new Compania[0]));
        JLabel labelTarifa = new JLabel();
        tarifa = new JComboBox<>();
        JLabel labelPContratada = new JLabel();
        txPotenciaContratada = new JTextField();
        JLabel labelConsumo = new JLabel();
        txPunta = new JTextField();
        txValle = new JTextField();
        txSuperValle = new JTextField();
        btCargar = new JButton();
        JLabel labelDias = new JLabel();
        txDias = new JTextField();
        btAyuda = new JButton();
        btAnadir = new JButton();
        btSimularFactura = new JButton();
        panelGrafico = new JPanel();
        JScrollPane panelTabla = new JScrollPane();
        tablaFactura = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new Dimension(905, 565));
        jPanel1.setMinimumSize(new Dimension(905, 565));

        panelNombre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        labelNombre.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        labelNombre.setForeground(new Color(16, 103, 218));
        labelNombre.setText("SIMULADOR DE FACTURAS");

        GroupLayout panelNombreLayout = new GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(labelNombre)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNombreLayout.setVerticalGroup(panelNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelNombreLayout.createSequentialGroup()
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

        btSimularFactura.setText("Simular Factura");

        GroupLayout panelDatosLayout = new GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(labelCompania)
                        .addGap(18, 18, 18)
                        .addComponent(compania, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(labelTarifa)
                        .addGap(18, 18, 18)
                        .addComponent(tarifa, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btAnadir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(labelPContratada)
                                .addGap(18, 18, 18)
                                .addComponent(txPotenciaContratada, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(labelDias)
                                .addGap(31, 31, 31)
                                .addComponent(txDias, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addComponent(labelConsumo)
                                        .addGap(18, 18, 18)
                                        .addComponent(txPunta, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txValle, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                                        .addComponent(btSimularFactura, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)))
                                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(btAyuda, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addComponent(txSuperValle, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(btCargar, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(92, 92, 92))))
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
                    .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txPotenciaContratada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDias)
                        .addComponent(txDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConsumo)
                    .addComponent(txPunta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txValle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSuperValle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCargar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btSimularFactura)
                    .addComponent(btAyuda))
                .addGap(20, 20, 20))
        );

        panelGrafico.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        GroupLayout panelGraficoLayout = new GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(panelGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(panelGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tablaFactura.setBackground(new Color(190, 191, 190));
        tablaFactura.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        tablaFactura.setFont(new Font("Ubuntu", 1, 15)); // NOI18N
        tablaFactura.setForeground(new Color(1, 1, 1));
        tablaFactura.setModel(new DefaultTableModel(
            new Object [][] {
                {"  Por energía utilizada", null},
                {"  -  Valle  ", null},
                {"  -  Punta", null},
                {"  -  Supervalle    ", null},
                {"  Por potencia contratada", null},
                {"  Impuesto electricidad", null},
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
        tablaFactura.setRowHeight(33);
        panelTabla.setViewportView(tablaFactura);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panelNombre, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDatos, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelTabla, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGrafico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(panelGrafico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addGap(0, 578, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton btAnadir;
    JButton btAyuda;
    JButton btCargar;
    JButton btSimularFactura;
    JComboBox<Compania> compania;
    JPanel panelGrafico;
    JTable tablaFactura;
    JComboBox<Tarifa> tarifa;
    JTextField txDias;
    JTextField txPotenciaContratada;
    JTextField txPunta;
    JTextField txSuperValle;
    JTextField txValle;
    // End of variables declaration//GEN-END:variables



}
