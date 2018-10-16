package electricom.utils;

import electricom.dominio.Consumo;

interface Filtro {
	
	public boolean filtrar(Consumo consumo);

}

public class ConsumoFactory {
	public final static int PUNTA_INICIO = 13;
	public final static int PUNTA_FIN= 23;
	public final static int VALLE_1_INICIO = 7;
	public final static int VALLE_1_FIN= 13;
	public final static int VALLE_2_INICIO = 23;
	public final static int VALLE_2_FIN= 1;
	public final static int SUPERVALLE_INICIO= 1;
	public final static int SUPERVALLE_FIN= 7;
	
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
			return ((hora > PUNTA_INICIO) && (hora <=PUNTA_FIN));
		}
	}
	
	public static class FiltroValle implements Filtro{
		@Override
		public boolean filtrar(Consumo consumo) {
			int hora = consumo.getHora();
			return (((hora > VALLE_1_INICIO) && (hora <= VALLE_1_FIN)) || (hora > VALLE_2_INICIO) || (hora <= VALLE_2_FIN));
		}
	}
	
	public static class FiltroSuperValle implements Filtro{
		@Override
		public boolean filtrar(Consumo consumo) {
			int hora = consumo.getHora();
			return ((hora > SUPERVALLE_INICIO) && (hora <= SUPERVALLE_FIN));
		}
	}
	
	

	
	
}
