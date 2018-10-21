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
import electricom.dominio.Precio;
/**
 * @author Lucas
 *
 */
public class PrecioDAOJDBC implements PrecioDAO{

	private static final String FIND_BY_ID =
			"SELECT precioID,hora_inicio,hora_fin,mes_inicio,mes_fin,precio,tarifaID FROM precio WHERE precioID = ?";
	private static final String FIND_BY_TARIFA_ID =
			"SELECT precioID,hora_inicio,hora_fin,mes_inicio,mes_fin,precio,tarifaID FROM precio WHERE tarifaID = ?";
	private static final String SQL_LIST_PRICES_BY_TARIFA =
			"SELECT precioID,hora_inicio,hora_fin,mes_inicio,mes_fin,precio,tarifaID FROM precio WHERE tarifaID = ?";

	private DAOFactory daoFactory;

	PrecioDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public Precio find(Long id) throws DAOException {
		return find(FIND_BY_ID,id);
	}

	@Override
	public List<Precio> list(Long id) throws DAOException {
		return list(SQL_LIST_PRICES_BY_TARIFA,id);
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

	private List<Precio> list(String sql,Object...values){
		List<Precio> precio = new ArrayList<>();

	    try (
	            Connection connection = daoFactory.getConnection();
	            PreparedStatement statement = DAOUtil.prepareStatement(connection,sql,values);
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
		precio.setHoraInicio(resultSet.getInt("hora_inicio"));
		precio.setHoraFin(resultSet.getInt("hora_fin"));
		precio.setMesInicio(resultSet.getInt("mes_inicio"));
		precio.setMesFin(resultSet.getInt("mes_fin"));
		precio.setPrecio(resultSet.getDouble("precio"));
		precio.setTarifaID(resultSet.getInt("tarifaID"));

		return precio;
	}

}
