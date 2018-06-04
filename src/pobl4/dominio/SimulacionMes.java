/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.dominio;

import java.util.List;

public class SimulacionMes extends Simulacion{
    
    
    List<Consumo> listaConsumos;
    Tarifa tarifa;
    int año;
    int mes;
    
    public SimulacionMes(List<Consumo> listaConsumos,Tarifa tarifa, int año, int mes){
        this.listaConsumos = listaConsumos;
        this.tarifa = tarifa;
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
