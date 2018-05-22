package pobl4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pobl4.daoexception.DAOException;
import pobl4.user.User;

public class UserDAOJDBC implements UserDAO {

    private static final String SQL_FIND_BY_ID =
        "SELECT id,nombre,apellido,nombre_usuario,contraseña,potencia_contratada,tarifaID"
        + " FROM usuario WHERE id = ?";
    private static final String SQL_FIND_BY_USERNAME_AND_PASSWORD =
        "SELECT id FROM usuario WHERE nombre_usuario = ? AND contraseña = MD5(?)";
    private static final String SQL_INSERT =
        "INSERT INTO usuario (nombre, apellido,nombre_usuario,contraseña,potencia_contratada,tarifaID) "
        + "VALUES (?,?,?,MD5(?),?,?)";

    
    
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
		Object[] values = {
	            user.getUsername(),
	            user.getPassword()
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
	


	@Override
	public void update(User user) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> userList() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private User map(ResultSet resultSet) throws SQLException {
		 User user = new User();
	     user.setId(resultSet.getInt("id"));
	     user.setUsername(resultSet.getString("username"));
	     
	     return user;
	}

}
