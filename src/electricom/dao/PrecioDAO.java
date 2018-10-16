/**
 * 
 */
package electricom.dao;

import java.util.List;

import electricom.daoexception.DAOException;
import electricom.dominio.Precio;

/**
 * @author Lucas
 *
 */
public interface PrecioDAO {
	
	public Precio find(Long id) throws DAOException;
	public Precio findByTarifa(Long id) throws DAOException;
	public List<Precio> list(Long id) throws DAOException;
	
}
