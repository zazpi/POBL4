/**
 * 
 */
package electricom.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 *
 */
public class Tarifa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descripcion;
	private boolean renovable = true;
	private int companiaID;
	
	private List<Precio> precios;
	private Compania compania;
	
	public Tarifa() {
		precios = new ArrayList<>();
	}

	public Compania getCompania() {
		return compania;
	}
	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	public List<Precio> getPrecios() {
		return precios;
	}
	public void setPrecios(List<Precio> precios) {
		this.precios = precios;
	}
	public int getTarifaID() {
		return id;
	}
	public void setTarifaID(int tarifaID) {
		this.id = tarifaID;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isRenovable() {
		return renovable;
	}
	public void setRenovable(boolean renovable) {
		this.renovable = renovable;
	}
	public int getCompaniaID() {
		return companiaID;
	}
	public void setCompaniaID(int companiaID) {
		this.companiaID = companiaID;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof User) && ((Integer) id != null)
	             ? ((Integer) id).equals(((Tarifa) obj).id)
	             : (obj == this);
	}
	@Override
	public int hashCode() {
		return ((Integer) id != null) 
	             ? (this.getClass().hashCode() + ((Integer)id).hashCode()) 
	             : super.hashCode();
	}
	@Override
	public String toString() {
		return descripcion;
	}

	public boolean isValid() {
		
		return !precios.isEmpty();
	}
	
	
}
