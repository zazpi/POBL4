package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import pobl4.dominio.TiempoReal;
import pobl4.presentacion.VistaTiempoReal;
import pobl4.serial.Serial;
import pobl4.serial.SerialListener;

public class CtrlTiempoReal implements ActionListener, SerialListener, SerialPortEventListener {	
	Timer timer;
	
	VistaTiempoReal dialogo;
	TiempoReal modelo;
	
	Serial seriala;
		
	public CtrlTiempoReal (TiempoReal modelo, Serial seriala) {
		this.modelo = modelo;
		//this.seriala = seriala;
	}
	
	public void setDialogo (VistaTiempoReal dialogo) {
		this.dialogo = dialogo;
	}
	
	@Override
	public void serialEvent(SerialPortEvent arg0) {		
		double balioa = (double) seriala.leer();
		
		recibirConsumo(balioa);
	}

	@Override
	public void recibirConsumo(double consumo) {
		modelo.setConsumo(consumo);
		if (consumo > modelo.getMaxConsumo()) modelo.setMaxConsumo(consumo);		
		
		dialogo.consumo(consumo, modelo.getConsumo(), modelo.getMaxConsumo());
		
		modelo.setSegundosLeido();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			modelo.setTiempoTranscurrido();
			dialogo.tiempo(modelo.getHoras(), modelo.getMinutos(), modelo.getSegundos());
		} else if (e.getActionCommand().equals("start/stop")) {				
			if (timer == null) {
				modelo.inicializar();
				dialogo.inicializar();
				timer = new Timer (1000, this);
				timer.start();
				//byte bytes = (byte) 255;
				//seriala.escribir(bytes);
			} else {
				dialogo.setVelocimetro(0.0);
				timer.stop();
				timer = null;
				//byte bytes = (byte) 0;
				//seriala.escribir(bytes);
			}
		}
	}
}
