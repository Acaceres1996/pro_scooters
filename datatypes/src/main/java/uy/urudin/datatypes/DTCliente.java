package uy.urudin.datatypes;

import java.io.Serializable;

public class DTCliente implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private int saldo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getApellido() {
		return apellido;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
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
	/**
	 * 
	 */
	public DTCliente() {
		super();
	}
	

	
}
