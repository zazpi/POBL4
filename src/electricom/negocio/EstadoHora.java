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
public class EstadoHora implements Estados {
	
	private int hora = 0;

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getDatosGraficos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
		Map<String,Double> datosGrafico = new HashMap<>();
		int ano = params [0];
		int mes = params [1];
		int dia = params [2];
		for(Consumo c: listaConsumos) {
			if(c.getAno() == ano && c.getMes() == mes && c.getDia() == dia)
				datosGrafico.put(String.valueOf(String.valueOf((c.getHora()))), c.getConsumo());
		}
		
		return Utils.sortByValue(datosGrafico,false);
	}

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getEstadisticos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		Map<String,Double> datosEstadisticos = new HashMap<>();
		int ano = values[0];
		int mes = values[1];
		int dia = values[2];
		int [] periodosReferencia = {ano,mes,dia};
		List<Consumo> lista = Utils.filtraConsumoPorPeriodo(listaConsumos, "hora", periodosReferencia);
		double consumoTotal =  getConsumoMedioPorHora(lista,dia,mes,ano);
		datosEstadisticos.put("consumoMedio",consumoTotal / hora);
		double consumoPunta = Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroPunta());
		datosEstadisticos.put("consumoMedio", consumoTotal / hora);
		datosEstadisticos.put("periodoPunta", (consumoTotal!=0)?(consumoPunta * 100 /consumoTotal):0);
		datosEstadisticos.put("periodoValle", (consumoTotal!=0)?((consumoTotal - consumoPunta) * 100 /consumoTotal):0);
		
		return datosEstadisticos;
	}
	
	private double getConsumoMedioPorHora(List<Consumo> listaConsumos,int dia, int mes, int ano) {
		double consumoMedioPorHora = 0;
		List<Integer> listaHora = new ArrayList<>();
		for(Consumo c: listaConsumos) {
			if(c.getDia() == dia && c.getAno() == ano && c.getMes() == mes) {
				consumoMedioPorHora+= c.getConsumo();
			}
			if(!listaHora.contains(c.getHora()))
				listaHora.add(c.getHora());
		}
		hora = listaHora.size();
		return consumoMedioPorHora;
	}

}