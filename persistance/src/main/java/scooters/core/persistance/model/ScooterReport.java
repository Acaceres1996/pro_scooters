package scooters.core.persistance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ScooterReport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private Integer ScooterId;
	private Date timestamp;
	private String Lat;
	private String Long;
	private Integer Battery;	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getScooterId() {
		return ScooterId;
	}

	public void setScooterId(Integer scooterId) {
		ScooterId = scooterId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
