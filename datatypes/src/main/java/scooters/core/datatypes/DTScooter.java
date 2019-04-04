package scooters.core.datatypes;

import java.io.Serializable;

public class DTScooter implements Serializable {
	private static final long serialVersionUID = 6128016096756071380L;	
	private Integer Id;
	private String Lat;
	private String Long;
	private Integer Battery;
	
	public DTScooter() {
		super();
	}
	
	public DTScooter(Integer Id, String Lat, String Long, Integer Battery) {
		super();
		this.setId(Id);
		this.setLat(Lat);
		this.setLong(Long);
		this.setBattery(Battery);
	}

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
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

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}
}
