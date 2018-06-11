package pobl4.dominio;


public class SimulacionEstatica extends Simulacion {
    double punta, valle, supervalle; // Consumos
    double porPunta, porValle, porSuperValle; // Coste

	@Override
    public void calcularCoste() {
        Consumo consumoPunta = new Consumo(7,16, punta);
        Consumo consumoValle = new Consumo(7,12, valle);
        Consumo consumoSuperValle = new Consumo(7,3, supervalle);
        
        porPunta = getCoste(tarifa,consumoPunta);
        porValle = getCoste(tarifa,consumoValle);
        porSuperValle = getCoste(tarifa,consumoSuperValle);
        
        porEnergia = porPunta + porValle + porSuperValle;
        
        porPotencia = 38 * potencia * ((double)dias/365);
        porImpuestos = (porEnergia + porPotencia) * 0.0511269 ;
        porIva = (porEnergia + porImpuestos + porPotencia) * 0.21;
        total = porEnergia + porPotencia + porImpuestos + porIva;
    }


    public void setPunta(double punta) {
        this.punta = punta;
    }

    public void setValle(double valle) {
        this.valle = valle;
    }

    public void setSupervalle(double supervalle) {
        this.supervalle = supervalle;
    }
    
    public double getPorPunta() {
		return porPunta;
	}

	public double getPorValle() {
		return porValle;
	}

	public double getPorSuperValle() {
		return porSuperValle;
	}
    
}
