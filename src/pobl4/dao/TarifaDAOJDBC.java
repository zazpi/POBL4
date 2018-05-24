/**
 * 
 */
package pobl4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pobl4.daoexception.DAOException;
import pobl4.generalobjectclasses.Tarifa;

/**
 * @author root
 *
 */
public class TarifaDAOJDBC implements TarifaDAO{
	
	private static final String FIND_BY_ID = 
			"SELECT tarifaID,descripcion,renovable,compañiaID FROM tarifa WHERE tarifaID = ?";
	private static final String FIND_BY_COMPANY_ID =
			"SELECT tarifaID,descripcion,renovable,compañiaID FROM tarifa WHERE compañiaID = ?";
	private static final String SQL_INSERT = 
			"INSERT INTO tarifa(descripcion,renovable,compañia) VALUES(?,?,?)";
	
	private DAOFactory daoFactory;
	
	TarifaDAOJDBC(DAOFactory daoFactory){
		
		this.daoFactory = daoFactory;
	}

	@Override
	public Tarifa find(Long id) throws DAOException {
		return find(FIND_BY_ID,id);
	}
	
	@Override
	public Tarifa findByCompany(Long id) throws DAOException {
		return find(FIND_BY_COMPANY_ID,id);
	}
	
	private Tarifa find(String sql, Object...values) {
		Tarifa tarifa = null;

	      
		try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = DAOUtil.prepareStatement(connection, sql, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                tarifa = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return tarifa;
		
	}

	@Override
	public void create(Tarifa tarifa) throws IllegalArgumentException, DAOException {
		
		if((Integer)tarifa.getTarifaID() != null) {
			 throw new IllegalArgumentException("Tarifa already exists.");
		}
		
		Object[] values = {
	            tarifa.getDescripcion(),
	            tarifa.isRenovable(),
	            tarifa.getCompaniaID()
		};
		
	    try (
	        	Connection connection = daoFactory.getConnection();
				PreparedStatement statement = DAOUtil.prepareStatement(connection, SQL_INSERT, values);){
				int affectedRows = statement.executeUpdate();
	            if (affectedRows == 0) {
	                throw new DAOException("Creating user failed, no rows affected.");
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private Tarifa map(ResultSet resultSet) throws SQLException {
		Tarifa tarifa = new Tarifa();
		tarifa.setTarifaID(resultSet.getInt("tarifaID"));
		tarifa.setDescripcion(resultSet.getString("descripcion"));
		tarifa.setRenovable(resultSet.getBoolean("renovable"));
		tarifa.setCompaniaID(resultSet.getInt("compañiaID"));
		return tarifa;
	}




}
