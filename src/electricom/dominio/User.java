/**
 * 
 */
package electricom.dominio;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lucas Sousa
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	private double potencia_contratada;
	private int tafiraID;
	
	private List<Consumo> consumos;
	private Tarifa tarifa;
	
	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPotencia_contratada() {
		return potencia_contratada;
	}

	public void setPotencia_contratada(double potencia_contratada) {
		this.potencia_contratada = potencia_contratada;
	}

	public int getTafiraID() {
		return tafiraID;
	}

	public void setTafiraID(int tafiraID) {
		this.tafiraID = tafiraID;
	}

	@Override
	public int hashCode() {
		return ((Integer) id != null) 
	             ? (this.getClass().hashCode() + ((Integer)id).hashCode()) 
	             : super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof User) && ((Integer) id != null)
	             ? ((Integer) id).equals(((User) obj).id)
	             : (obj == this);
	}
	
}
