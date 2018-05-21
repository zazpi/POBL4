/**
 * 
 */
package pobl4.daoexception;

/**
 * Esta clase es simplemente para manejar las excepciones del DataAccessObject
 * @author Lucas Sousa
 * 
 */
public class DAOException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DAOException(String message) {
	        super(message);
	    }
	  
	 public DAOException(Throwable cause) {
	        super(cause);
	    }
}
