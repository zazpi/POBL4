package pobl4.dao;

import java.util.List;

import pobl4.daoexception.DAOException;
import pobl4.dominio.Tarifa;

public interface TarifaDAO {
	
	public Tarifa find(Long id) throws DAOException;
	public Tarifa findByCompany(Long id) throws DAOException;
	public void create(Tarifa tarifa) throws IllegalArgumentException,DAOException;
	public List<Tarifa> list();

}
