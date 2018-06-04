/**
 * 
 */
package pobl4.negocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pobl4.dominio.Consumo;

/**
 * @author Lucas
 *
 */
public class EstadoAño implements Estados {

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getDatosGraficos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getDatosGraficos(List<Consumo> listaConsumos, int... params) {
		Map<String,Double> datosGrafico = new HashMap<>();
		
		for(Consumo c: listaConsumos) {
			datosGrafico.put(String.valueOf(c.getAño()), c.getConsumo());
		}
		
		return datosGrafico;
	}

	/* (non-Javadoc)
	 * @see pobl4.negocio.Estados#getEstadisticos(java.util.List, int[])
	 */
	@Override
	public Map<String, Double> getEstadisticos(List<Consumo> listaConsumos, int... values) {
		return null;
	}

}
