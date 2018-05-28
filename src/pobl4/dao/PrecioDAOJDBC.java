/**
 * 
 */
package pobl4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pobl4.daoexception.DAOException;
import pobl4.dominio.Consumo;
import pobl4.dominio.Precio;
/**
 * @author Lucas
 *
 */
public class PrecioDAOJDBC implements PrecioDAO{
	
	private static final String FIND_BY_ID = 
			"SELECT precioID,hora_inicio,hora_fin,mes_inicio,mes_fin,precio,tarifaID FROM precio WHERE precioID = ?";
	private static final String FIND_BY_TARIFA_ID = 
			"SELECT precioID,hora_inicio,hora_fin,mes_inicio,mes_fin,precio,tarifaID FROM precio WHERE tarifaID = ?";
	private static final String SQL_LIST_PRICES = 
			"SELECT precioID,hora_inicio,hora_fin,mes_inicio,mes_fin,precio,tarifaID FROM precio";
	
	private DAOFactory daoFactory;
	
	PrecioDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public Precio find(Long id) throws DAOException {
		return find(FIND_BY_ID,id);
	}
	
	@Override
	public List<Precio> find() throws DAOException {
		return find(SQL_LIST_PRICES);
	}

	@Override
	public Precio findByTarifa(Long id) throws DAOException {
		return find(FIND_BY_TARIFA_ID,id);
	}
	
	private Precio find(String sql,Object...values) {
		Precio precio = null;

	      
		try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = DAOUtil.prepareStatement(connection, sql, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                precio = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return precio;
	}
	
	private List<Precio> find(String sql){
		List<Precio> precio = new ArrayList<>();
		
	    try (
	            Connection connection = daoFactory.getConnection();
	            PreparedStatement statement = connection.prepareStatement(SQL_LIST_PRICES);
	            ResultSet resultSet = statement.executeQuery();
	        ) {
	            while (resultSet.next()) {
	                precio.add(map(resultSet));
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	    return precio;
	}

	private Precio map(ResultSet resultSet) throws SQLException {
		Precio precio = new Precio();
		precio.setId(resultSet.getInt("precioID"));
		precio.setHora_inicio(resultSet.getInt("hora_inicio"));
		precio.setHora_fin(resultSet.getInt("hora_fin"));
		precio.setMes_inicio(resultSet.getInt("mes_inicio"));
		precio.setMes_fin(resultSet.getInt("mes_fin"));
		precio.setPrecio(resultSet.getDouble("precio"));
		precio.setTarifaID(resultSet.getInt("tarifaID"));
		
		return precio;
	}

}
