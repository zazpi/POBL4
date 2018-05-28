package pobl4.negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import pobl4.serial.SerialListener;


public class CtrlTiempoReal implements ActionListener, SerialListener {
	double consumo;
	int horas;
	int minutos;
	int segundos;
	double maxConsumo;
	
	Timer timer;
	
	/*VistaTiempoReal dialogo;
		
	public CtrlTiempoReal () {
		this.consumo = 0;
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
		this.maxConsumo = 0;
	}
	
	public void setDialogo (TiempoReal dialogo) {
		this.dialogo = dialogo;
	}
	
	public void setConsumo(double consumo) {
		this.consumo += consumo;
	}
	public void setMaxConsumo(double maxConsumo) {
		this.maxConsumo = maxConsumo;
	}	
	public Timer getTimer() {
		return timer;
	}

	public void setTiempoTranscurrido () {
		segundos++;
		if (segundos == 60) {
			minutos++;
			segundos = 0;
		}
		if (minutos == 60) {
			horas++;
			minutos = 0;
		}
	}

	@Override
	public void recibirConsumo(double consumo) {
		setConsumo(consumo);
		if (consumo > maxConsumo) setMaxConsumo(consumo);		
		
		dialogo.consumo(consumo, this.consumo, maxConsumo);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			setTiempoTranscurrido();
			dialogo.tiempo(horas, minutos, segundos);
		} else if (e.getActionCommand().equals("start/stop")) {				
			if (timer == null) {
				horas = 0;
				minutos = 0;
				segundos = 0;
				dialogo.tiempo(horas, minutos, segundos);
				timer = new Timer (1000, this);
				timer.start();
			} else {
				dialogo.setVelocimetro(0.0);
				timer.stop();
				timer = null;
			}
		}		
	}	*/

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirConsumo(double consumo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
