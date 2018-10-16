/**
 * 
 */
package electricom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Lucas Sousa
 *
 */
public class DAOUtil {

	
	public static PreparedStatement prepareStatement (Connection connection, String sql, Object... values) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		setValues(statement, values);
		return statement;
	}	

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException
	{
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
    	}
	}
}
