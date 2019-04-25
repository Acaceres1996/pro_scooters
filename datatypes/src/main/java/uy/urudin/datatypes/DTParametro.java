package uy.urudin.datatypes;

import java.io.Serializable;


public class DTParametro implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String nombre;
	private String valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public DTParametro() {
		super();
	}
	public DTParametro(int Id, String Name, String Value) {
		this.id = Id;
		this.nombre = Name;
		this.valor = Value;
	}

	
}
