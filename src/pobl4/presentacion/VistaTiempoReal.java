package pobl4.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;

import pobl4.dominio.TiempoReal;
import pobl4.negocio.CtrlTiempoReal;
import pobl4.serial.Serial;

public class VistaTiempoReal extends JDialog {
	CtrlTiempoReal controlador;
	TiempoReal modelo;
	
	public DefaultValueDataset dataset = new DefaultValueDataset(0);	
	int minimumValue = 0;
	int maximumValue = 100;
	int majorTickGap = 10;
	
	JLabel lvalorConsumo;
	JLabel lvalorTiempo;
	JLabel lvalorMaxConsumo;
	
	Serial seriala;
	
	public VistaTiempoReal (JFrame vista) {
		super (vista, "Tiempo real", true);
		
		modelo = new TiempoReal();
		
		//cargarSerial();
		
		controlador = new CtrlTiempoReal(modelo, seriala);
		this.controlador.setDialogo(this);
		
		/*if (seriala != null) {
			seriala.addListener(controlador);		
		}*/	
		
		this.add(crearPanelDialogo());
		this.setLocation(485, 252);
		this.setSize(950, 576);
			
		this.setVisible(true);
					
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public void cargarSerial() {
		seriala = new Serial();
		try {
			seriala.conectar(seriala.encontrarPuerto());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private Component crearPanelDialogo() {
		JPanel panel = new JPanel (new BorderLayout(10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));		
		
		panel.add(crearVelocimetro(), BorderLayout.CENTER);
		panel.add(crearPanelDerecha(), BorderLayout.EAST);
		
		return panel;
	}
	
	private Component crearVelocimetro() {		
		DialPlot plot = new DialPlot(dataset);
	    plot.setDialFrame(new StandardDialFrame());
	    
	    int redLine = 3 * maximumValue / 5;
	    double yellowLine = 1.5 * maximumValue / 5;
	    
	    plot.addLayer(new DialValueIndicator(0));
	    plot.addLayer(new DialPointer.Pointer());
	    plot.addLayer(new StandardDialRange(minimumValue, yellowLine, Color.green));
	    plot.addLayer(new StandardDialRange(yellowLine, redLine, Color.yellow));
	    plot.addLayer(new StandardDialRange(redLine, maximumValue, Color.red));
	    
	    StandardDialScale scale = new StandardDialScale(minimumValue, maximumValue,
	        -120, -300, majorTickGap, majorTickGap - 1);
	    scale.setTickRadius(0.88);
	    scale.setTickLabelOffset(0.20);
	    plot.addScale(0, scale);
		
	    return new ChartPanel(new JFreeChart(plot));
	}
	
	private Component crearPanelDerecha() {
		JPanel panel = new JPanel (new GridLayout(2,1,0,75));		
		
		panel.add(crearPanelDatos());
		panel.add(crearBoton());
		
		return panel;
	}	

	private Component crearPanelDatos () {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		JLabel titulo = new JLabel("DATOS ");
		titulo.setFont(new Font("arial", Font.BOLD, 20));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		
		panel.add(titulo);
		panel.add(crearDatos());
		
		return panel;	
	}	

	private Component crearDatos() {
		JPanel panelDatos = new JPanel(new GridLayout(3, 2, 10, 10));
		panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Font fontTitulo = new Font("arial", Font.BOLD, 16);
		Font fontDato = new Font("arial", Font.PLAIN, 16);
		
		JLabel lconsumo = crearLabel("Consumo total: ", fontTitulo, JLabel.RIGHT);		
		lvalorConsumo = crearLabel("0 kW", fontDato, JLabel.LEFT);				
		JLabel ltiempo = crearLabel("Tiempo transcurrido: ", fontTitulo, JLabel.RIGHT);		
		lvalorTiempo = crearLabel("0h 0m 0s", fontDato, JLabel.LEFT);				
		JLabel lmax = crearLabel("Pico del consumo: ", fontTitulo, JLabel.RIGHT);		
		lvalorMaxConsumo = crearLabel("0 kW", fontDato, JLabel.LEFT);
		
		panelDatos.add(lconsumo);
		panelDatos.add(lvalorConsumo);
		panelDatos.add(ltiempo);
		panelDatos.add(lvalorTiempo);
		panelDatos.add(lmax);
		panelDatos.add(lvalorMaxConsumo);
		
		return panelDatos;
	}
	
	private JLabel crearLabel (String izena, Font font, int alineacion) {
		JLabel label = new JLabel(izena);
		label.setFont(font);
		label.setHorizontalAlignment(alineacion);
		
		return label;
	}
	
	private Component crearBoton() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(20, 75, 150, 75));
		
		JButton boton = new JButton("Start/Stop");
		boton.setBorder(new LineBorder(Color.GRAY, 2));
		boton.setBackground(Color.LIGHT_GRAY);
		boton.setActionCommand("start/stop");
		boton.addActionListener(controlador);
		
		panel.add(boton, BorderLayout.CENTER);
		
		return panel;
	}
	
	public void setVelocimetro (double consumo) {
		dataset.setValue(consumo);
	}
	
	public void consumo (double consumo, double consumoTotal, double maxConsumo) {
		setVelocimetro(consumo);
		lvalorConsumo.setText(consumoTotal + " kW");
		lvalorMaxConsumo.setText(maxConsumo + " kW");
	}
	
	public void tiempo (int horas, int minutos, int segundos) {
		lvalorTiempo.setText(horas + "h " + minutos + "m " + segundos + "s");
	}
	
	public void inicializar () {
		lvalorConsumo.setText(0 + " kW");
		lvalorMaxConsumo.setText(0 + " kW");
		lvalorTiempo.setText(0 + "h " + 0 + "m " + 0 + "s");
	}
}
