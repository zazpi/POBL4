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
 * @author Lucas
 *
 */
public class EstadoAño implements Estados {
	
	private int AÑOS = 0;

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getDatosGraficos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
		Map<String,Double> datosGrafico = new HashMap<>();
		
		for(Consumo c: listaConsumos) {
			if(!datosGrafico.containsKey(String.valueOf(c.getAño())))
				datosGrafico.put(String.valueOf(c.getAño()), getConsumoAnual(listaConsumos, c.getAño()));
		}
		return Utils.sortByValue(datosGrafico,false);
	}

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getEstadisticos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		Map<String,Double> datosEstadisticos = new HashMap<>();
		double consumoTotal = getConsumoAnuales(listaConsumos);
		double periodoPunta = Utils.calcularConsumoPeriodo(listaConsumos, ConsumoFactory.getFiltroPunta());
		double mediaDiario = consumoTotal / AÑOS / 365;
		datosEstadisticos.put("periodoPunta", (consumoTotal!=0)?(periodoPunta*100/consumoTotal):0);

		datosEstadisticos.put("periodoValle", (consumoTotal!=0)?((consumoTotal - periodoPunta)*100/consumoTotal):0);
		datosEstadisticos.put("consumoMedio", consumoTotal / AÑOS);
		datosEstadisticos.put("mediaPorDia", mediaDiario);
		
		return datosEstadisticos;
	}
	
	private double getConsumoAnuales(List<Consumo> lista) {
		double consumoAnualTotal = 0;
		List<Integer> listaAños = new ArrayList<>();
		for(Consumo c: lista) {
				consumoAnualTotal += c.getConsumo();
				if(!listaAños.contains(c.getAño()))
					listaAños.add(c.getAño());
		}
		AÑOS = listaAños.size();
		return consumoAnualTotal;
	}
	
	private double getConsumoAnual(List<Consumo> lista, int año) {
		double consumoMedioAnualTotal = 0;
		for(Consumo c: lista) {
			if(c.getAño() == año)
				consumoMedioAnualTotal += c.getConsumo();
		}
		return consumoMedioAnualTotal;
	}
	
}
