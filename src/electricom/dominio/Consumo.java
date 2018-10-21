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
	private int ano;
	private int mes;
	private int dia;
	private int hora;
	private double consumoKW;
	private int usuarioID;
        
        public Consumo(){
            
        }
        public Consumo(int mes, int hora, double consumo){
            this.mes = mes;
            this.hora = hora;
            this.consumoKW = consumo;
        }
	

	public int getConsumoID() {
		return id;
	}
	public void setConsumoID(int consumoID) {
		this.id = consumoID;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
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
		return consumoKW;
	}
	public void setConsumo(double consumo) {
		this.consumoKW = consumo;
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
