
package electricom.dominio;

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
        calcularCoste();
    }

    @Override
    public void calcularCoste() {
        
        porEnergia = 0;
        
        for (Consumo consumo : listaConsumos){
            if(consumo.getAno() == año && consumo.getMes() == mes){
                porEnergia += getCoste(tarifa, consumo);
            }
        }
        total = porEnergia; 
    }
    
}
