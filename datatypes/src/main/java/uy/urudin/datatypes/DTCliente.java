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
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public DTCliente(int id,String nombre,String apellido,String email,int saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.saldo = saldo;
	}

	public DTCliente() {
		super();
	}
	

	
}
