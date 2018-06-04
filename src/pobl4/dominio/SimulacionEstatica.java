package pobl4.dominio;

/**
 *
 * @author galaipa
 */

public class SimulacionEstatica extends Simulacion {
    double punta, valle, supervalle;
    
    @Override
    public void calcularCoste() {
        if(tarifa == null){
            resetCalculos();
            return;
        }
        Consumo consumoPunta = new Consumo(7,16, punta);
        Consumo consumoValle = new Consumo(7,12, valle);
        Consumo consumoSuperValle = new Consumo(7,3, supervalle);
        
        porEnergia = getCoste(tarifa,consumoPunta);
        porEnergia += getCoste(tarifa,consumoValle);
        porEnergia += getCoste(tarifa,consumoSuperValle);
        
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
    
}
