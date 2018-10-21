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
 * @author Lucas
 *
 */
public class EstadoAno implements Estados {
	
	private int anos = 0;

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getDatosGraficos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
		Map<String,Double> datosGrafico = new HashMap<>();
		
		for(Consumo c: listaConsumos) {
			if(!datosGrafico.containsKey(String.valueOf(c.getAno())))
				datosGrafico.put(String.valueOf(c.getAno()), getConsumoAnual(listaConsumos, c.getAno()));
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
		double mediaDiario = consumoTotal / anos / 365;
		datosEstadisticos.put("periodoPunta", (consumoTotal!=0)?(periodoPunta*100/consumoTotal):0);

		datosEstadisticos.put("periodoValle", (consumoTotal!=0)?((consumoTotal - periodoPunta)*100/consumoTotal):0);
		datosEstadisticos.put("consumoMedio", consumoTotal / anos);
		datosEstadisticos.put("mediaPorDia", mediaDiario);
		
		return datosEstadisticos;
	}
	
	private double getConsumoAnuales(List<Consumo> lista) {
		double consumoAnualTotal = 0;
		List<Integer> listaAnos = new ArrayList<>();
		for(Consumo c: lista) {
				consumoAnualTotal += c.getConsumo();
				if(!listaAnos.contains(c.getAno()))
					listaAnos.add(c.getAno());
		}
		anos = listaAnos.size();
		return consumoAnualTotal;
	}
	
	private double getConsumoAnual(List<Consumo> lista, int ano) {
		double consumoMedioAnualTotal = 0;
		for(Consumo c: lista) {
			if(c.getAno() == ano)
				consumoMedioAnualTotal += c.getConsumo();
		}
		return consumoMedioAnualTotal;
	}
	
}
