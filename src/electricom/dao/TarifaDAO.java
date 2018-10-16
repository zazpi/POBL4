package electricom.dao;

import java.util.List;

import electricom.daoexception.DAOException;
import electricom.dominio.Tarifa;

public interface TarifaDAO {
	
	public Tarifa find(Long id) throws DAOException;
	public Tarifa findByCompany(Long id) throws DAOException;
	public void create(Tarifa tarifa) throws IllegalArgumentException,DAOException;
	public List<Tarifa> list();

}
