package scooters.core.persistance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import scooters.core.datatypes.DTCustomer;

@Embeddable
public class Customer implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Column(name="Id", insertable=true, updatable=false)
	private Integer Id;	
	
	@Column(name="Email", insertable=true, updatable=true)
	private String Email;

	public Customer() {
		
	}
	
	public Customer(DTCustomer c) {
		
	}
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer Id) {
		this.Id = Id;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
	
	public DTCustomer toDataType() {
		return new DTCustomer( this.getId(), this.getEmail());
	}
}
