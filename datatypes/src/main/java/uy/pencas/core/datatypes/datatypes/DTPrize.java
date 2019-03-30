package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;

import uy.pencas.core.datatypes.enumerated.TypePrize;
import uy.pencas.core.datatypes.enumerated.TypeSport;


public class DTPrize implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;

	private Integer id;
	private Boolean enabled;
	private String name;
	private TypePrize typePrize;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypePrize getTypePrize() {
		return this.typePrize;
	}

	public void setTypePrize(TypePrize typePrize) {
		this.typePrize = typePrize;
	}

	public DTPrize (Integer id, Boolean enabled, String name, TypePrize typePrize) {
		super();
		this.id = id;
		this.enabled = enabled;
		this.name = name;
		this.typePrize = typePrize;
	}
	

	public DTPrize() {
		super();
	}

}
