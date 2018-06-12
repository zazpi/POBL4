/**
 * 
 */
package pobl4.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pobl4.dominio.Consumo;
import pobl4.utils.ConsumoFactory;
import pobl4.utils.Utils;

/**
 * @author root
 *
 */
public class EstadoDia implements Estados{
	
	private int DIAS = 0;

	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
	Map<String,Double> datosGrafico = new HashMap<>();
	
	int año = params [0];
	int mes = params [1];
		for(Consumo c: listaConsumos) {
			if (c.getAño() == año && c.getMes() == mes && !datosGrafico.containsKey(String.valueOf(c.getDia())))
				datosGrafico.put(String.valueOf(c.getDia()), getConsumoDiario(listaConsumos, c.getDia(),c.getMes(),c.getAño()));
		}
		return Utils.sortByValue(datosGrafico,false);
	}

	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		Map<String,Double> datosEstadisticos = new HashMap<>();
		int ano = values[0];
		int mes = values[1];
		int dia = values[2];
		int [] periodosReferencia = {ano,mes};
		List<Consumo> lista = Utils.filtraConsumoPorPeriodo(listaConsumos, "dia", periodosReferencia);
		datosEstadisticos.put("consumoMedio", getConsumoMensual(lista,ano,mes));
		datosEstadisticos.put("periodoPunta", Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroPunta())/DIAS);
		double periodoValle = ((Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroValle())+
				Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroSuperValle()))/DIAS);
		datosEstadisticos.put("periodoValle", periodoValle);
		
		return datosEstadisticos;
	}
	
	private double getConsumoMensual(List<Consumo> lista, int ano, int mes) {
		double consumoMensual = 0;
		List<Integer> listaDias = new ArrayList<>();
		for(Consumo c: lista) {
			if(c.getAño() == ano && c.getMes() == mes) {
				consumoMensual+= c.getConsumo();
				System.out.println("hey");
			}
			if(!listaDias.contains(c.getDia()))
				listaDias.add(c.getDia());
		}
		DIAS = listaDias.size();
		System.out.println(consumoMensual);
		System.out.println(DIAS);
		return consumoMensual/DIAS;
	}
	
	private double getConsumoDiario(List<Consumo> lista, int dia,int mes, int año) {
		double consumoDiario = 0;
		for(Consumo c: lista) {
			if(c.getDia() == dia && c.getAño() == año && c.getMes() == mes) {
				consumoDiario+= c.getConsumo();
			}
		}
		return consumoDiario;
	}

}
