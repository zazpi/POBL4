
package pobl4.dominio;

import java.util.List;

public class SimulacionMes extends Simulacion{   
    List<Consumo> listaConsumos;
    int año;
    int mes;
    
    public SimulacionMes(List<Consumo> listaConsumos,Compania compania,Tarifa tarifa, int año, int mes){
        this.listaConsumos = listaConsumos;
        this.tarifa = tarifa;
        this.compania = compania;
        this.año = año;
        this.mes = mes;
    }

    @Override
    public void calcularCoste() {
        
        for (Consumo consumo : listaConsumos){
            if(consumo.getAño() == año && consumo.getMes() == mes){
                porEnergia = porEnergia + getCoste(tarifa, consumo);
            }
        }
       
    }
    
}
