package scooters.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import scooters.core.datatypes.DTScooter;

@Embeddable
public class Scooter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="ScooterId", insertable=true, updatable=false)
	private Integer ScooterId;	
	
	public Scooter() {
		
	}
	
	public Scooter(DTScooter scooter) {
		super();
		this.ScooterId = scooter.getScooterId();
	}
	
	public Scooter(Integer ScooterId){
		this.ScooterId = ScooterId;
	}

	public Integer getScooterId() {
		return ScooterId;
	}

	public void setScooterId(Integer scooterId) {
		ScooterId = scooterId;
	}
	
	public DTScooter toDataType() {
		return new DTScooter(this.getScooterId());
	}
}
