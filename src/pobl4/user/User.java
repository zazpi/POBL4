/**
 * 
 */
package pobl4.user;

import java.io.Serializable;

/**
 * @author Lucas Sousa
 *
 */
public class User implements Serializable{ //Test class. Esta clase hay que cambiar.
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username; //email
	private String password; //md5 ecryption
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		return ((Integer) id != null) 
	             ? (this.getClass().hashCode() + ((Integer)id).hashCode()) 
	             : super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof User) && ((Integer) id != null)
	             ? ((Integer) id).equals(((User) obj).id)
	             : (obj == this);
	}

	@Override
	public String toString() {
		 return String.format("User[id=%d,username=%s]", 
		            id, username);
	}
	
}
