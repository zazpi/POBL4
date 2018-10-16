/**
 * 
 */
package electricom.dao;

import java.util.List;

import electricom.daoexception.DAOException;
import electricom.dominio.Compania;

/**
 * @author Lucas
 *
 */
public interface CompaniaDAO {
	
	public List<Compania> list() throws DAOException;
	public Compania find(Long id) throws DAOException;

}
