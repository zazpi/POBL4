package pobl4.dao;
/**
 * @author Lucas
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pobl4.daoexception.DAOException;
import pobl4.dominio.User;

public class UserDAOJDBC implements UserDAO {

    private static final String SQL_FIND_BY_ID =
        "SELECT usuarioID,nombre,apellido,nombre_usuario,contraseña,potencia_contratada,tarifaID"
        + " FROM usuario WHERE id = ?";
    private static final String SQL_FIND_BY_USERNAME_AND_PASSWORD =
        "SELECT usuarioID,nombre,apellido,nombre_usuario,contraseña,potencia_contratada,tarifaID FROM usuario WHERE nombre_usuario = ? AND contraseña = MD5(?)";
    private static final String SQL_INSERT =
        "INSERT INTO usuario (nombre, apellido,nombre_usuario,contraseña,potencia_contratada,tarifaID) "
        + "VALUES (?,?,?,MD5(?),?,?)";
    private static final String SQL_UPDATE_TARIFA_ID = 
    		"UPDATE usuario SET tarifaID = ? WHERE usuarioID = ?";
    
    private DAOFactory daoFactory;
    
    UserDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
	@Override
	public User find(Long id) throws DAOException {
		return find(SQL_FIND_BY_ID, id);
	}

	@Override
	public User find(String username, String password) throws DAOException {
        return find(SQL_FIND_BY_USERNAME_AND_PASSWORD, username, password);
	}
	
	@Override
	public void update(Long id) throws IllegalArgumentException, DAOException {
		if (id == null) {
            throw new IllegalArgumentException("User not found.");
		}
		
		 Object[] values = {id};

		    try (
		            Connection connection = daoFactory.getConnection();
		            PreparedStatement statement = DAOUtil.prepareStatement(connection, SQL_UPDATE_TARIFA_ID, values);
		       ) {
		            int affectedRows = statement.executeUpdate();
		            if (affectedRows == 0) {
		                throw new DAOException("Updating user failed, no rows affected.");
		            }
		            } catch (SQLException e) {
		            throw new DAOException(e);
		      }
		
	}
	
	private User find(String sql, Object... values) throws DAOException {
		User user = null;

      
		try (
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = DAOUtil.prepareStatement(connection, sql, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return user;
	}



	@Override
	public void create(User user) throws IllegalArgumentException, DAOException {
		/*if ((Integer)user.getId() != null) {
            throw new IllegalArgumentException("User is already created, the user ID is not null.");
		}*/
            
		Object[] values = {
	            user.getNombre(),
	            user.getApellido(),
				user.getUsername(),
	            user.getPassword(),
	            user.getPotencia_contratada(),
	            user.getTafiraID()
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
	
	private User map(ResultSet resultSet) throws SQLException {
		 User user = new User();
	     user.setId(resultSet.getInt("usuarioID"));
	     user.setNombre(resultSet.getString("nombre"));
	     user.setApellido(resultSet.getString("apellido"));
	     user.setUsername(resultSet.getString("nombre_usuario"));
	     user.setPassword(resultSet.getString("contraseña"));
	     user.setPotencia_contratada(resultSet.getDouble("potencia_contratada"));
	     user.setTafiraID(resultSet.getInt("tarifaID"));
	     
	     return user;
	}

}
