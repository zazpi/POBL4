/**
 * 
 */
package pobl4.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pobl4.dominio.Consumo;
import pobl4.utils.ConsumoFactory;
import pobl4.utils.Utils;

/**
 * @author root
 *
 */
public class EstadoMes implements Estados {
	
	private int MESES = 0;

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getDatosGraficos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
		Map<String,Double> datosGrafico = new HashMap<>();
		int año = params [0];		
		for(Consumo c: listaConsumos) {
			if(c.getAño() == año && !datosGrafico.containsKey(String.valueOf(c.getMes())))
				datosGrafico.put(String.valueOf(String.valueOf((c.getMes()))), getConsumoMensual(listaConsumos, c.getMes(),c.getAño()));
		}
		
		return Utils.sortByValue(datosGrafico,true);
	}

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getEstadisticos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		Map<String,Double> datosEstadisticos = new HashMap<>();
		int ano = values[0];
		int mes = values[1];
		int [] periodosReferencia = {ano};
		List<Consumo> lista = Utils.filtraConsumoPorPeriodo(listaConsumos, "mes", periodosReferencia);
		datosEstadisticos.put("consumoMedio", getConsumoAnual(lista,ano));
		datosEstadisticos.put("periodoPunta", Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroPunta())/MESES);
		double periodoValle = ((Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroValle())+
				Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroSuperValle()))/MESES);
		datosEstadisticos.put("periodoValle", periodoValle);
		
		return datosEstadisticos;
	}
	
	private double getConsumoAnual(List<Consumo> lista,int ano) {
		double consumoAnual = 0;
		List<Integer> listaMeses = new ArrayList<>();
		for(Consumo c: lista) {
			if(c.getAño() == ano) {
				consumoAnual+= c.getConsumo();
			}
			if(!listaMeses.contains(c.getMes()))
				listaMeses.add(c.getMes());
		}
		MESES = listaMeses.size();
		return consumoAnual/MESES;
	}
	
	private double getConsumoMensual(List<Consumo> lista, int mes,int ano) {
		double consumoMensual = 0;
		for(Consumo c: lista) {
			if(c.getMes() == mes && c.getAño() == ano) {
				consumoMensual+= c.getConsumo();
			}
		}
		return consumoMensual;
	}

}
