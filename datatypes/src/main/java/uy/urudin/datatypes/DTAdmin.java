package uy.urudin.datatypes;

import java.io.Serializable;

public class DTAdmin implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String usuario;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public DTAdmin(int id, String usuario, String password) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}
	/**
	 * 
	 */
	public DTAdmin() {
		super();
	}
	

	
}
