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
        Consumo consumoPunta = new Consumo(1,16,punta);
        Consumo consumoValle = new Consumo(1,12,valle);
        Consumo consumoSuperValle = new Consumo(1,3,supervalle);
        
        porEnergia = getCoste(tarifa,consumoPunta);
        porEnergia += getCoste(tarifa,consumoValle);
        porEnergia += getCoste(tarifa,consumoSuperValle);
        
        porPotencia = 38 * potencia;
        porImpuestos = porEnergia + porPotencia * 0.0511269;
        porIva = (porEnergia + porImpuestos + porPotencia) * 0.21;
    }
    
    
    
}
