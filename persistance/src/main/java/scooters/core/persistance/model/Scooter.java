package scooters.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;
import scooters.core.datatypes.DTScooter;

@Embeddable
public class Scooter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="Id", insertable=true, updatable=false)
	private Integer Id;	
	
	@Column(name="Lat", insertable=true, updatable=true)
	private String Lat;
	
	@Column(name="Long", insertable=true, updatable=true)
	private String Long;
	
	@Column(name="Battery", insertable=true, updatable=true)
	private Integer Battery;
	
	public Scooter() {
		
	}
	
	public Scooter(DTScooter s) {
		super();
		this.Id = s.getId();
		this.Lat = s.getLat();
		this.Long = s.getLong();
		this.Battery = s.getBattery();
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
		return new DTScooter(this.getId(),this.getLat(),this.getLong(),this.getBattery());
	}

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}

	public String getLong() {
		return Long;
	}

	public void setLong(String l) {
		Long = l;
	}

	public Integer getBattery() {
		return Battery;
	}

	public void setBattery(Integer battery) {
		Battery = battery;
	}
}
