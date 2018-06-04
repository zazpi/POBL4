/**
 * 
 */
package pobl4.dao;

import java.util.List;

import pobl4.daoexception.DAOException;
import pobl4.dominio.Consumo;

/**
 * @author Lucas
 *
 */
public interface ConsumoDAO {
	
	 public Consumo find(Long id) throws DAOException;
	 public Consumo findByUserId(Long userID) throws DAOException;
	 public List<Consumo> list (Long id) throws DAOException;
	 public void create(Consumo consumo) throws IllegalArgumentException, DAOException;

}
