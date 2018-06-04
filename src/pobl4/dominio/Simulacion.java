package pobl4.dominio;

import java.util.List;

public abstract class Simulacion {
    // Datos del usuario
    Compania compania;
    Tarifa tarifa;
    double potencia;
    int dias;
    
    // Datos calculados
    double porEnergia, porPotencia, porImpuestos, porIva;
    
    public abstract void calcularCoste();
    
    public void resetCalculos(){
        porEnergia = 0;
        porPotencia = 0;
        porImpuestos = 0;
        porIva = 0;
    }
    
    public double getCoste(Tarifa tarifa, Consumo consumo){
        List<Precio> precios = tarifa.getPrecios();
        Precio precio = null;
        for(Precio pr : precios){
            if(!checkPeriodo(consumo.getMes(),pr.getMes_inicio(),pr.getMes_fin())) continue;
            if(!checkPeriodo(consumo.getHora(),pr.getHora_inicio(),pr.getHora_fin())) continue;
            precio = pr;
        }
        return precio.getPrecio() * consumo.getConsumo();
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
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
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
