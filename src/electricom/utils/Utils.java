package electricom.utils;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import electricom.dao.ConsumoDAO;
import electricom.dao.UserDAO;
import electricom.dominio.Consumo;
import electricom.dominio.User;
import electricom.presentacion.VistaLogin;

/**
 * 
 * @author Lucas
 *
 */

public class Utils {
	public static User validateUser(UserDAO userDAO,String username,String password) {
		User user = userDAO.find(username, password);
		if(user!=null)
			return user;
		
		return null;
			
	}
	
	public static void createConsumes(ConsumoDAO consumoDAO, List<Consumo> consumos) {
		if(consumoDAO != null) {
			consumoDAO.create(consumos);
		}
	}
	
	public static String translateMonthToString(int mes) {
		switch(mes) {
		case 1:
			return "Enero";
		case 2:
			return "Febrero";
		case 3:
			return "Marzo";
		case 4:
			return "Abril";
		case 5:
			return "Mayo";
		case 6:
			return "Junio";
		case 7:
			return "Julio";
		case 8:
			return "Agosto";
		case 9:
			return "Septiembre";
		case 10:
			return "Octubre";
		case 11:
			return "Noviembre";
		case 12:
			return "Deciembre";
		default:
			return "Not assigned";
		}
	}
        
        public static int translateStringToMonth(String mes) {
		switch(mes) {
		case "Enero":
			return 1;
		case "Febrero":
			return 2;
		case "Marzo":
			return 3;
		case "Abril":
			return 4;
		case "Mayo":
			return 5;
		case "Junio":
			return 6;
		case "Julio":
			return 7;
		case "Agosto":
			return 8;
		case "Septiembre":
			return 9;
		case "Octubre":
			return 10;
		case "Noviembre":
			return 11;
		case "Deciembre":
			return 12;
		default:
			return 0;
		}
	}
        
        public static List<Integer>getListaAnos(List<Consumo>listaConsumos){
            
            List<Integer>listaAnos;
            listaAnos = new ArrayList<>();
            
            for(Consumo c : listaConsumos){
                if(!listaAnos.contains(c.getAno())){
                    listaAnos.add(c.getAno());
                }
            }
            return listaAnos;
        }
        
        public static List<String>getListaMeses(List<Consumo>listaConsumos, int año){
            
            List<String>listaMeses;
            listaMeses = new ArrayList<>();
            
            for(Consumo c : listaConsumos){
                if((!listaMeses.contains(translateMonthToString(c.getMes())) && (c.getAno() == año))){
                    listaMeses.add(translateMonthToString(c.getMes()));
                }
            }
            return listaMeses;
        }
        

        public static Map<String, Double> sortByValue(Map<String, Double> unsortMap, boolean mes) {

            List<Map.Entry<String, Double>> list =
                    new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
                public int compare(Map.Entry<String, Double> o1,
                                   Map.Entry<String, Double> o2) {
                    return Integer.valueOf(o1.getKey()).compareTo(Integer.valueOf(o2.getKey()));
                }
            });
            
            Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
            if(!mes)
            	for (Map.Entry<String, Double> entry : list) {
            		sortedMap.put(entry.getKey(), entry.getValue());
            	}
            else
            	for (Map.Entry<String, Double> entry : list) {
            		sortedMap.put(translateMonthToString(Integer.valueOf(entry.getKey())), entry.getValue());
            	}


            return sortedMap;
            
        }

    	public static double calcularConsumoPeriodo(List<Consumo> consumos,Filtro filtro){
    		double consumo = 0;
    		for(Consumo c : consumos) {
    			if(filtro.filtrar(c))
    				consumo += c.getConsumo();
    		}
    		return consumo;
    	}
    	
    	public static List<Consumo> filtrarConsumo(List<Consumo> consumos,int año, int mes){
    		List<Consumo> consumoFiltrado = new ArrayList<>();
    		for(Consumo c : consumos) {
    			if(c.getAno() == año && c.getMes() == mes)
    				consumoFiltrado.add(c);
    		}
    		return consumoFiltrado;
    	}

        public static AbstractAction getHandlerLoginKeyEvent(UserDAO userDAO, VistaLogin login) {
            AbstractAction buttonPressed = new AbstractAction() {
            	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			           User user = Utils.validateUser(userDAO, login.getTxUsuario(), login.getTxContraseña());
			            if(user != null){
			                JOptionPane.showMessageDialog(login, "Welcome, "+login.getTxUsuario()+"!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
			                login.closeDialog(user);
			            }
			            else{
			                JOptionPane.showMessageDialog(login, "ERROR: user doesn't exists!", "ERROR 404", JOptionPane.ERROR_MESSAGE);
			            }
			                
			        
				}
            };
            return buttonPressed;
        }

       public static List<Consumo> filtraConsumoPorPeriodo(List<Consumo>listaConsumos,String periodo, int...periodosReferencia){
    	   List<Consumo> lista = null;
    	   if(periodo.equals("mes")) {
    		   lista = new ArrayList<>();
    		   int ano = periodosReferencia[0];
    		   for(Consumo c: listaConsumos) {
    			   if(c.getAno() == ano && !lista.contains(c))
    				   lista.add(c);
    		   }
    	   }else if(periodo.equals("dia")) {
    		   lista = new ArrayList<>();
    		   int ano = periodosReferencia[0];
    		   int mes = periodosReferencia[1];
    		   for(Consumo c: listaConsumos) {
    			   if(c.getAno() == ano && c.getMes() == mes && !lista.contains(c))
    				   lista.add(c);
    		   }
    	   }else if(periodo.equals("hora")) {
    		   lista = new ArrayList<>();
    		   int ano = periodosReferencia[0];
    		   int mes = periodosReferencia[1];
    		   int dia = periodosReferencia[2];
    		   for(Consumo c: listaConsumos) {
    			   if(c.getAno() == ano && c.getMes() == mes && c.getDia() == dia)
    				   lista.add(c);
    		   }
    	   }
    	   
    	   return lista;
       }
       
       public static int getDiasPorPeriodo(List<Consumo> lista, String periodo, int peridoReferencia) {
    	   List<Integer> listaDias = new ArrayList<>();
    	   if(periodo.equals("ano")) {
    		   for(Consumo c: lista) {
    			   if(!listaDias.contains(c.getDia()))
    				   listaDias.add(c.getDia());
    		   }
    	   }else if(periodo.equals("mes")) {
    		   for(Consumo c: lista) {
    			   if(!listaDias.contains(c.getDia()) && c.getAno() == peridoReferencia)
    				   listaDias.add(c.getDia());
    		   }
    	   }
    	   
    	   return listaDias.size();
       }
}
