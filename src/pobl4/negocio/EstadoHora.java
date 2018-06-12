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
public class EstadoHora implements Estados {
	
	private int HORAS = 0;

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getDatosGraficos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
		Map<String,Double> datosGrafico = new HashMap<>();
		int año = params [0];
		int mes = params [1];
		int dia = params [2];
		for(Consumo c: listaConsumos) {
			if(c.getAño() == año && c.getMes() == mes && c.getDia() == dia)
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
		datosEstadisticos.put("consumoMedio", getConsumoMedioPorHora(lista,dia,mes,ano));
		datosEstadisticos.put("periodoPunta", Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroPunta())/HORAS);
		double periodoValle = ((Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroValle())+
				Utils.calcularConsumoPeriodo(lista, ConsumoFactory.getFiltroSuperValle()))/HORAS);
		datosEstadisticos.put("periodoValle", periodoValle);
		
		return datosEstadisticos;
	}
	
	private double getConsumoMedioPorHora(List<Consumo> listaConsumos,int dia, int mes, int año) {
		double consumoMedioPorHora = 0;
		List<Integer> listaHora = new ArrayList<>();
		for(Consumo c: listaConsumos) {
			if(c.getDia() == dia && c.getAño() == año && c.getMes() == mes) {
				consumoMedioPorHora+= c.getConsumo();
			}
			if(!listaHora.contains(c.getHora()))
				listaHora.add(c.getHora());
		}
		HORAS = listaHora.size();
		return consumoMedioPorHora/HORAS;
	}

}
