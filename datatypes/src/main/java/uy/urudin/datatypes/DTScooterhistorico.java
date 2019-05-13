package uy.urudin.datatypes;

import java.io.Serializable;
import java.sql.Timestamp;


public class DTScooterhistorico implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private Timestamp fecha;
	private String latitud;
	private String longitud;
	private int bateria;
	private DTScooter scooter;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public int getBateria() {
		return bateria;
	}
	public void setBateria(int bateria) {
		this.bateria = bateria;
	}
	public DTScooter getScooter() {
		return scooter;
	}
	public void setScooter(DTScooter scooter) {
		this.scooter = scooter;
	}

	public DTScooterhistorico(int id, Timestamp fecha, String latitud, String longitud, int bateria,
			DTScooter scooter) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.latitud = latitud;
		this.longitud = longitud;
		this.bateria = bateria;
		this.scooter = scooter;
	}
	
	public DTScooterhistorico() {
		super();
	}
}
