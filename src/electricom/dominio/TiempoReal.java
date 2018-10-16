package electricom.dominio;

public class TiempoReal {
	double consumo;
	double consumoTotal;
	int horas;
	int minutos;
	int segundos;
	int segundosLeido;
	double maxConsumo;
	
	public TiempoReal () {
		inicializar();
	}
	
	public void inicializar () {
		horas = 0;
		minutos = 0;
		segundos = 0;
		segundosLeido = 0;
		consumo = 0.0;
		consumoTotal = 0.0;
		maxConsumo = 0.0;
	}
	
	public void setConsumo(double consumo) { // benetako ordu bat -> minutu bat
		if (segundos < segundosLeido) consumoTotal += consumo * (60+segundos-segundosLeido)/60;
		else consumoTotal += consumo * (segundos-segundosLeido)/60;
		
	}
	public double getConsumo () {
		return consumoTotal;
	}
	
	public void setMaxConsumo(double maxConsumo) {
		this.maxConsumo = maxConsumo;
	}
	public double getMaxConsumo () {
		return maxConsumo;
	}
	
	public void setSegundosLeido () {
		this.segundosLeido = this.segundos;
	}
	
	public int getHoras () {
		return horas;
	}
	public int getMinutos () {
		return minutos;
	}
	public int getSegundos () {
		return segundos;
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
}
