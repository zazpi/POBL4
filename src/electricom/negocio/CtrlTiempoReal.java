package electricom.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import electricom.dominio.TiempoReal;
import electricom.presentacion.VistaTiempoReal;
import electricom.serial.Serial;
import electricom.serial.SerialListener;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class CtrlTiempoReal implements ActionListener, SerialListener, SerialPortEventListener {	
	Timer timer;
	
	VistaTiempoReal dialogo;
	TiempoReal modelo;
	
	Serial seriala;
	int byteKopurua;
	byte [] bytes;
		
	public CtrlTiempoReal (TiempoReal modelo, Serial seriala) {
		this.modelo = modelo;
		this.seriala = seriala;
		byteKopurua = 0;
		bytes = new byte[] {0, 0};
	}
	
	public void setDialogo (VistaTiempoReal dialogo) {
		this.dialogo = dialogo;
	}
	
	@Override
	public void serialEvent(SerialPortEvent arg0) {		
		double balioa = (double) seriala.leer();
		bytes[byteKopurua] = (byte) balioa;
		
		if (byteKopurua == 1) {
			int temp = ((int)bytes[1] << 8) + ((int)bytes[0]);
			double voltaje = temp*3.3/4095;
			double consumo = (((voltaje-1.65)*3) / 1.65);
			recibirConsumo(consumo);
			System.out.println(voltaje + "/" + consumo);
			byteKopurua = 0;
		}else {
			byteKopurua++;
		}
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
				seriala.escribir((byte) 255);
			} else {
				dialogo.setVelocimetro(0.0);
				timer.stop();
				timer = null;
				seriala.escribir((byte) 0);
			}
		}
	}
}
