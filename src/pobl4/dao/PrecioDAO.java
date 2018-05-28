/**
 * 
 */
package pobl4.dao;

import java.util.List;

import pobl4.daoexception.DAOException;
import pobl4.dominio.Precio;

/**
 * @author Lucas
 *
 */
public interface PrecioDAO {
	
	public Precio find(Long id) throws DAOException;
	public Precio findByTarifa(Long id) throws DAOException;
	public List<Precio> find() throws DAOException;
	
}
