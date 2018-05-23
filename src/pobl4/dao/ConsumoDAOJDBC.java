/**
 * 
 */
package pobl4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pobl4.daoexception.DAOException;
import pobl4.generalobjectclasses.Consumo;

/**
 * @author Lucas
 *
 */
public class ConsumoDAOJDBC implements ConsumoDAO{
	
	private static final String FIND_BY_ID = 
			"SELECT consumoID,año,mes,dia,hora,consumo,usuarioID FROM consumo WHERE consumoID = ?";
	private static final String FIND_BY_USER_ID = 
			"SELECT SELECT consumoID,año,mes,dia,hora,consumo,usuarioID FROM consumo WHERE usuarioID = ?";
	private static final String SQL_INSERT = 
			"INSERT INTO consumo (año,mes,dia,hora,consumo,usuarioID) VALUES(?,?,?,?,?)";

	private DAOFactory daoFactory;
	
	 ConsumoDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public Consumo find(Long id) throws DAOException {
		return find(FIND_BY_ID,id);
	}

	@Override
	public Consumo findByUserId(Long userID) throws DAOException {
		return find(FIND_BY_USER_ID,userID);
	}

	@Override
	public void create(Consumo consumo) throws IllegalArgumentException, DAOException {
		Object[] values = {
	            consumo.getAño(),
	            consumo.getMes(),
	            consumo.getDia(),
	            consumo.getHora(),
	            consumo.getConsumo(),
	            consumo.getUsuarioID()
		};
		
         try {
        	Connection connection = daoFactory.getConnection();
			PreparedStatement statement = DAOUtil.prepareStatement(connection, SQL_INSERT, values);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Consumo find(String sql,Object...values) {
		Consumo consumo = null;

	      
		try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = DAOUtil.prepareStatement(connection, sql, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                consumo = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return consumo;
	}

	private Consumo map(ResultSet resultSet) throws SQLException {
		Consumo consumo = new Consumo();
		consumo.setConsumoID(resultSet.getInt("consumoID"));
		consumo.setAño(resultSet.getInt("año"));
		consumo.setMes(resultSet.getInt("mes"));
		consumo.setDia(resultSet.getInt("dia"));
		consumo.setHora(resultSet.getInt("hora"));
		consumo.setConsumo(resultSet.getDouble("consumo"));
		consumo.setUsuarioID(resultSet.getInt("usuarioID"));
		return consumo;
	}

}
