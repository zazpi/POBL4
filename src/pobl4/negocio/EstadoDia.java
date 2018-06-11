/**
 * 
 */
package pobl4.negocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pobl4.dominio.Consumo;
import pobl4.utils.Utils;

/**
 * @author root
 *
 */
public class EstadoDia implements Estados{

	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
	Map<String,Double> datosGrafico = new HashMap<>();
	
	int año = params [0];
	int mes = params [1];
		for(Consumo c: listaConsumos) {
			if (c.getAño() == año && c.getMes() == mes)
				datosGrafico.put(String.valueOf(c.getDia()), c.getConsumo());
		}
		return Utils.sortByValue(datosGrafico,false);
	}

	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		// TODO Auto-generated method stub
		return null;
	}

}
