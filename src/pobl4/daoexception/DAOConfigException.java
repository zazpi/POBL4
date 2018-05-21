/**
 * 
 */
package pobl4.daoexception;

/**
 * Esta clase es simplemente para manejar las excepciones de la configuración del DataAccessObject
 * @author Lucas Sousa
 *
 */
public class DAOConfigException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 public DAOConfigException(String message) {
	        super(message);
	    }
	 
	public DAOConfigException(Throwable cause) {
	        super(cause);
	    }
}
