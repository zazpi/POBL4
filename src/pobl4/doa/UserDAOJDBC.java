package pobl4.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pobl4.daoexception.DAOException;
import pobl4.user.User;

public class UserDAOJDBC implements UserDAO {

    private static final String SQL_FIND_BY_ID =
        "SELECT id, username FROM usuario WHERE id = ?";
    private static final String SQL_FIND_BY_USERNAME_AND_PASSWORD =
        "SELECT id, username FROM usuario WHERE username = ? AND password = MD5(?)";
    private static final String SQL_INSERT =
        "INSERT INTO usuario (username, password) VALUES (?, MD5(?))";

    
    
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
	
	private User map(ResultSet resultSet) throws SQLException {
		 User user = new User();
	     user.setId(resultSet.getInt("id"));
	     user.setUsername(resultSet.getString("username"));
	     
	     return user;
	}

}
