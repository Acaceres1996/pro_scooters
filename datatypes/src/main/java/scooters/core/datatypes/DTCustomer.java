package scooters.core.datatypes;

import java.io.Serializable;

public class DTCustomer implements Serializable {
	private static final long serialVersionUID = 6128016096756071380L;	
	private Integer Id;
	private String Email;
	
	public DTCustomer() {
		super();
	}
	
	public DTCustomer(Integer Id, String Email) {
		this.setId(Id);
		this.setEmail(Email);
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
