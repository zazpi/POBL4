/**
 * 
 */
package electricom.dominio;

import java.io.Serializable;

/**
 * @author Lucas
 *
 */
public class Consumo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int año;
	private int mes;
	private int dia;
	private int hora;
	private double consumo;
	private int usuarioID;
        
        public Consumo(){
            
        }
        public Consumo(int mes, int hora, double consumo){
            this.mes = mes;
            this.hora = hora;
            this.consumo = consumo;
        }
	

	public int getConsumoID() {
		return id;
	}
	public void setConsumoID(int consumoID) {
		this.id = consumoID;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof User) && ((Integer) id != null)
	             ? ((Integer) id).equals(((Consumo) obj).id)
	             : (obj == this);
	}
	@Override
	public int hashCode() {
		return ((Integer) id != null) 
	             ? (this.getClass().hashCode() + ((Integer)id).hashCode()) 
	             : super.hashCode();
	}
}
