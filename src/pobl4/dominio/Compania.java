/**
 * 
 */
package pobl4.dominio;

import java.io.Serializable;
import java.util.List;

/**
 * @author root
 *
 */
public class Compania implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	
	private List<Tarifa> tarifas;
	
	public List<Tarifa> getTarifas() {
		return tarifas;
	}
	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public boolean equals(Object arg0) {
		if(!(arg0 instanceof Compania)) return false;
		Compania comp = (Compania) arg0;
		return nombre.equals(comp.getNombre());
	}
	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	@Override
	public String toString() {
		return nombre;
	}
	
	
	

}
