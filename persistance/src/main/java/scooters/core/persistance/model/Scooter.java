package scooters.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import scooters.core.datatypes.DTScooter;

@Embeddable
public class Scooter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="Id", insertable=true, updatable=false)
	private Integer Id;	
		
	public Scooter() {
		
	}
	
	public Scooter(DTScooter s) {
		super();
		this.Id = s.getId();
	}
	
	public Scooter(Integer Id){
		this.Id = Id;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}
	
	public DTScooter toDataType() {
		return new DTScooter(this.getId());
	}

}
