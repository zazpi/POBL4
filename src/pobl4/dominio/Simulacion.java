package pobl4.dominio;

import java.util.List;

/**
 *
 * @author galaipa
 */
public class Simulacion {
    // Datos introducidos por el usuario
    Compania compania;
    private Tarifa tarifa;
    private double potencia;
    double punta,valle,supervalle;
    int dias;
    
    // Datos calculados
    double porEnergia, porPotencia, porImpuestos, porIva;
    
    public Simulacion(){
        
    }
    
    public void actualizarCalculos(){
        if(tarifa == null){
            resetCalculos();
            return;
        }
        Consumo consumoPunta = new Consumo();
        Consumo consumoValle = new Consumo();
        Consumo consumoSuperValle = new Consumo();
        
        porEnergia = punta * getPrecio(tarifa,consumoPunta).getPrecio();
        porEnergia += valle * getPrecio(tarifa,consumoValle).getPrecio();
        porEnergia += supervalle * getPrecio(tarifa,consumoSuperValle).getPrecio();
        
        porPotencia = 38 * potencia;
        porImpuestos = porEnergia + porPotencia * 0.0511269;
        porIva = (porEnergia + porImpuestos + porPotencia) * 0.21;
    }
    
    public void resetCalculos(){
        porEnergia = 0;
        porPotencia = 0;
        porImpuestos = 0;
        porIva = 0;
    }
    
    public Precio getPrecio(Tarifa tarifa, Consumo consumo){
        List<Precio> precios = null;
        Precio precio = null;
        for(Precio pr : precios){
            if(!checkPeriodo(consumo.getMes(),pr.getMes_inicio(),pr.getMes_fin())) continue;
            if(!checkPeriodo(consumo.getHora(),pr.getHora_inicio(),pr.getHora_fin())) continue;
            precio = pr;
        }
        return precio;
    }
    
    public boolean checkPeriodo(int valor, int inicio, int fin){
        if(fin > inicio){
            return (valor > inicio && valor < fin);
        }else{
            return (valor > inicio || valor < fin);
        }
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
        actualizarCalculos();
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
        actualizarCalculos();
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
        actualizarCalculos();
    }

    public double getPunta() {
        return punta;
    }

    public void setPunta(double punta) {
        this.punta = punta;
        actualizarCalculos();
    }

    public double getValle() {
        return valle;
    }

    public void setValle(double valle) {
        this.valle = valle;
        actualizarCalculos();
    }

    public double getSupervalle() {
        return supervalle;
    }

    public void setSupervalle(double supervalle) {
        this.supervalle = supervalle;
        actualizarCalculos();
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
        actualizarCalculos();
    }

    public double getPorEnergia() {
        return porEnergia;
    }

    public double getPorPotencia() {
        return porPotencia;
    }

    public double getPorImpuestos() {
        return porImpuestos;
    }

    public double getPorIva() {
        return porIva;
    }
    
    
    
    
}
