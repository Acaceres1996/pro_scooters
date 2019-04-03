package scooters.core.datatypes;

import java.io.Serializable;

public class DTScooter implements Serializable {
	private static final long serialVersionUID = 6128016096756071380L;	
	private Integer ScooterId;
	
	public DTScooter() {
		super();
	}
	
	public DTScooter(Integer ScooterId) {
		super();
		this.setScooterId(ScooterId);
	}

	public Integer getScooterId() {
		return this.ScooterId;
	}

	public void setScooterId(Integer scooterId) {
		this.ScooterId = scooterId;
	}
}
