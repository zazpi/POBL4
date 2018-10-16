/**
 * 
 */
package electricom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import electricom.daoexception.DAOException;
import electricom.dominio.Compania;
import electricom.dominio.Consumo;

/**
 * @author Lucas
 *
 */
public class CompaniaDAOJDBC implements CompaniaDAO {
	
	
	private static final String SQL_LIST_COMPANYS = 
			"SELECT compañiaID,nombre FROM compañia";
	private static final String FIND_BY_ID =
			"SELECT compañiaID,nombre FROM compañia WHERE compañiaID = ?";
	
	private DAOFactory daoFactory;
	
	CompaniaDAOJDBC(DAOFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	/* (non-Javadoc)
	 * @see pobl4.dao.CompañiaDAO#find(java.lang.Long)
	 */
	@Override
	public Compania find(Long id) throws DAOException {
		return find(FIND_BY_ID,id);
	}

	@Override
	public List<Compania> list() throws DAOException {
		return list(SQL_LIST_COMPANYS);
	}
	
	private Compania find(String sql,Object...values) {
		Compania compañia = null;

	      
		try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = DAOUtil.prepareStatement(connection, sql, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                compañia = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return compañia;
	}
	
	private List<Compania> list(String sql){
		List<Compania> compañias = new ArrayList<>();
		
	    try (
	            Connection connection = daoFactory.getConnection();
	            PreparedStatement statement = connection.prepareStatement(SQL_LIST_COMPANYS);
	            ResultSet resultSet = statement.executeQuery();
	        ) {
	            while (resultSet.next()) {
	                compañias.add(map(resultSet));
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	    return compañias;
	}

	private Compania map(ResultSet resultSet) throws SQLException {
		Compania compañia = new Compania();
		compañia.setId(resultSet.getInt("compañiaID"));
		compañia.setNombre(resultSet.getString("nombre"));
		return compañia;
	}

}
