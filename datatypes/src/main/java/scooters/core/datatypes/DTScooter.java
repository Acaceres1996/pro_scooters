package scooters.core.datatypes;

import java.io.Serializable;

public class DTScooter implements Serializable {
	private static final long serialVersionUID = 6128016096756071380L;	
	private Integer Id;
	
	public DTScooter() {
		super();
	}
	
	public DTScooter(Integer Id) {
		super();
		this.setId(Id);
	}

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

}
