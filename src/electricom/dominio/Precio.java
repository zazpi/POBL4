/**
 * 
 */
package electricom.dominio;

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
	private int horaInicio;
	private int horaFin;
	private int mesInicio;
	private int mesFin;
	private double precioEUR;
	private int tarifaID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	public int setMesInicio() {
		return mesInicio;
	}
	public void setMesInicio(int mesInicio) {
		this.mesInicio = mesInicio;
	}
	public int getMesFin() {
		return mesFin;
	}
	public void setMesFin(int mesFin) {
		this.mesFin = mesFin;
	}
	public double getPrecio() {
		return precioEUR;
	}
	public void setPrecio(double precio) {
		this.precioEUR = precio;
	}
	public int getTarifaID() {
		return tarifaID;
	}
	public void setTarifaID(int tarifaID) {
		this.tarifaID = tarifaID;
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public String toString() {
		return "Precio [id=" + id + ", hora_inicio=" + horaInicio + ", hora_fin=" + horaFin + ", mes_inicio="
				+ mesInicio + ", mes_fin=" + mesFin + ", precio=" + precioEUR + ", tarifaID=" + tarifaID + "]";
	}
	
	public boolean isValid() {
		return (precioEUR != 0);
	}
	
	

}
