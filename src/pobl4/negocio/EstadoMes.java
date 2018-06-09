/**
 * 
 */
package pobl4.negocio;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pobl4.dominio.Consumo;
import pobl4.utils.Utils;

/**
 * @author root
 *
 */
public class EstadoMes implements Estados {

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getDatosGraficos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
		Map<String,Double> datosGrafico = new HashMap<>();
		int año = params [0];		
		for(Consumo c: listaConsumos) {
			if(c.getAño() == año)
				datosGrafico.put(String.valueOf(String.valueOf((c.getMes()))), c.getConsumo());
		}
		
		return Utils.sortByValue(datosGrafico,true);
	}

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getEstadisticos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		// TODO Auto-generated method stub
		return null;
	}

}
