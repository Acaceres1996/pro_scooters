package uy.urudin.datatypes.datatypes;

import java.io.Serializable;
import java.util.Date;

public class DTCliente implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param id
	 * @param email
	 */
	public DTCliente(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	

	
}
