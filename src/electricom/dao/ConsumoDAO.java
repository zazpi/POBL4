/**
 * 
 */
package electricom.dao;

import java.util.List;

import electricom.daoexception.DAOException;
import electricom.dominio.Consumo;

/**
 * @author Lucas
 *
 */
public interface ConsumoDAO {
	
	 public Consumo find(Long id) throws DAOException;
	 public Consumo findByUserId(Long userID) throws DAOException;
	 public List<Consumo> list (Long id) throws DAOException;
	 public void create(Consumo consumo) throws IllegalArgumentException, DAOException;
	 public void create(List<Consumo> consumo) throws IllegalArgumentException, DAOException;

}
