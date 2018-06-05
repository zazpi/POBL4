/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pobl4.dominio;

import java.util.List;

public class SimulacionAno extends Simulacion{
    
    List<Consumo> listaConsumos;
    int año;
    
    public SimulacionAno(List<Consumo> listaConsumos,Compania compania,Tarifa tarifa, int año){
        this.listaConsumos = listaConsumos;
        this.tarifa = tarifa;
        this.compania = compania;
        this.año = año;
        calcularCoste();
    }

    @Override
    public void calcularCoste() {
       
        for (Consumo consumo : listaConsumos){
            if(consumo.getAño() == año){
                porEnergia += getCoste(tarifa, consumo);
            }
        }
        total = porEnergia;
        
    }
    
}
