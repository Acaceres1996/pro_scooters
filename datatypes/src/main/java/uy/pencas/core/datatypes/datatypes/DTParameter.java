package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;
import uy.pencas.core.datatypes.enumerated.TypeSport;


public class DTParameter implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private String name;
	private String value;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	public DTParameter() {
		super();
	}
	public DTParameter(Integer id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	
}
