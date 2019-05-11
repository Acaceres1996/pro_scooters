package uy.urudin.datatypes;

import java.io.Serializable;

public class DTAdmin implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String email;
	private String password;
	
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
	public DTAdmin(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	/**
	 * 
	 */
	public DTAdmin() {
		super();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
