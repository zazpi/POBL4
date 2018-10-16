/**
 * 
 */
package electricom.negocio;

import java.util.List;
import java.util.Map;

import electricom.dominio.Consumo;

/**
 * @author Lucas
 *
 */
public interface Estados {
	
	
	public Map<String,Double> getDatosGraficos(List<Consumo> listaConsumos,int...params);
	public Map<String,Double> getEstadisticos(List<Consumo> listaConsumos,int...values);
}
