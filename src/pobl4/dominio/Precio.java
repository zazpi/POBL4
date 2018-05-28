/**
 * 
 */
package pobl4.dominio;

import java.io.Serializable;

/**
 * @author root
 *
 */
public class Precio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int hora_inicio;
	private int hora_fin;
	private int mes_inicio;
	private int mes_fin;
	private double precio;
	private int tarifaID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public int getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(int hora_fin) {
		this.hora_fin = hora_fin;
	}
	public int getMes_inicio() {
		return mes_inicio;
	}
	public void setMes_inicio(int mes_inicio) {
		this.mes_inicio = mes_inicio;
	}
	public int getMes_fin() {
		return mes_fin;
	}
	public void setMes_fin(int mes_fin) {
		this.mes_fin = mes_fin;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getTarifaID() {
		return tarifaID;
	}
	public void setTarifaID(int tarifaID) {
		this.tarifaID = tarifaID;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
