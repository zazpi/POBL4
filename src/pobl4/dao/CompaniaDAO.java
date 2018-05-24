/**
 * 
 */
package pobl4.dao;

import java.util.List;

import pobl4.daoexception.DAOException;
import pobl4.generalobjectclasses.Compania;

/**
 * @author Lucas
 *
 */
public interface CompaniaDAO {
	
	public List<Compania> find() throws DAOException;
	public Compania find(Long id) throws DAOException;

}
