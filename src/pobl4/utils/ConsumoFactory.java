package pobl4.utils;

import pobl4.dominio.Consumo;

interface Filtro {
	
	public boolean filtrar(Consumo consumo);

}

public class ConsumoFactory {
	
	public static Filtro getFiltroPunta(){
		return new FiltroPunta();
	}
	public static Filtro getFiltroValle(){
		return new FiltroValle();
	}
	public static Filtro getFiltroSuperValle(){
		return new FiltroSuperValle();
	}

	
	public static class FiltroPunta implements Filtro{
		@Override
		public boolean filtrar(Consumo consumo) {
			int hora = consumo.getHora();
			return ((hora >= Utils.PUNTA_INICIO) && (hora < Utils.PUNTA_FIN));
		}
	}
	
	public static class FiltroValle implements Filtro{
		@Override
		public boolean filtrar(Consumo consumo) {
			int hora = consumo.getHora();
			return (((hora >= Utils.VALLE_1_INICIO) && (hora < Utils.VALLE_1_FIN)) ||((hora >= Utils.VALLE_2_INICIO) && (hora <=Utils.VALLE_2_FIN)));
		}
	}
	
	public static class FiltroSuperValle implements Filtro{
		@Override
		public boolean filtrar(Consumo consumo) {
			int hora = consumo.getHora();
			return ((hora >= Utils.SUPERVALLE_INICIO) && (hora < Utils.SUPERVALLE_FIN));
		}
	}
	
	

	
	
}
