package uy.urudin.datatypes.datatypes;

import java.io.Serializable;


public class DTParametro implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String name;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public DTParametro() {
		super();
	}
	public DTParametro(int Id, String Name, String Value) {
		this.id = Id;
		this.name = Name;
		this.value = Value;
	}

	
}
