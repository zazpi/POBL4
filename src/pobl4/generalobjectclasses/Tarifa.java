/**
 * 
 */
package pobl4.generalobjectclasses;

/**
 * @author Lucas
 *
 */
public class Tarifa {
	
	private int id;
	private String descripcion;
	private boolean renovable;
	private int companiaID;
	

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
}
