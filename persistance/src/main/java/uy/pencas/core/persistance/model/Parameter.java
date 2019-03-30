package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTParameter;


/**
 * The persistent class for the parameter database table.
 * 
 */
@Entity
@NamedQuery(name="Parameter.findAll", query="SELECT p FROM Parameter p")
public class Parameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String value;

	public Parameter() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Parameter(DTParameter dtParameter) {
		this.id = dtParameter.getId();
		this.name = dtParameter.getName();
		this.value = dtParameter.getValue();
	}
	
	public DTParameter getDTParameter() {
		return new DTParameter(this.getId(),this.getName(),this.getValue());
	}

}