/**
 * 
 */
package electricom.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import electricom.dominio.Consumo;
import electricom.utils.ConsumoFactory;
import electricom.utils.Utils;

/**
 * @author root
 *
 */
public class EstadoDia implements Estados{
	
	private int dias = 0;

	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
	Map<String,Double> datosGrafico = new HashMap<>();
	
	int ano = params [0];
	int mes = params [1];
		for(Consumo c: listaConsumos) {
			if (c.getAno() == ano && c.getMes() == mes && !datosGrafico.containsKey(String.valueOf(c.getDia())))
				datosGrafico.put(String.valueOf(c.getDia()), getConsumoDiario(listaConsumos, c.getDia(),c.getMes(),c.getAno()));
		}
		return Utils.sortByValue(datosGrafico,false);
	}

	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		Map<String,Double> datosEstadisticos = new HashMap<>();
		int ano = values[0];
		int mes = values[1];
		int [] periodosReferencia = {ano,mes};
		List<Consumo> lista = Utils.filtraConsumoPorPeriodo(listaConsumos, "dia", periodosReferencia);
		double consumoTotal = getConsumoMensual(lista,ano,mes);
		
		datosEstadisticos.put("consumoMedio", consumoTotal / dias);
		double consumoPunta = Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroPunta());
		datosEstadisticos.put("periodoPunta", (consumoTotal!=0)?(consumoPunta * 100 /consumoTotal):0);
		datosEstadisticos.put("periodoValle", (consumoTotal!=0)?((consumoTotal - consumoPunta) * 100 /consumoTotal):0);
		
		
		return datosEstadisticos;
	}
	
	private double getConsumoMensual(List<Consumo> lista, int ano, int mes) {
		double consumoMensual = 0;
		List<Integer> listaDias = new ArrayList<>();
		for(Consumo c: lista) {
			if(c.getAno() == ano && c.getMes() == mes) {
				consumoMensual+= c.getConsumo();
			}
			if(!listaDias.contains(c.getDia()))
				listaDias.add(c.getDia());
		}
		dias = listaDias.size();
		return consumoMensual;
	}
	
	private double getConsumoDiario(List<Consumo> lista, int dia,int mes, int ano) {
		double consumoDiario = 0;
		for(Consumo c: lista) {
			if(c.getDia() == dia && c.getAno() == ano && c.getMes() == mes) {
				consumoDiario+= c.getConsumo();
			}
		}
		return consumoDiario;
	}

}
