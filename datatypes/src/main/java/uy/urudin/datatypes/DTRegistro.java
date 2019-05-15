package uy.urudin.datatypes;

import java.io.Serializable;
import java.sql.Timestamp;


public class DTRegistro implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private String latitud;
	private String longitud;
	private int bateria;
	private int scooterid;
	
	
	public DTRegistro(String latitud, String longitud, int bateria, int scooterid) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.bateria = bateria;
		this.scooterid = scooterid;
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




	public int getScooterid() {
		return scooterid;
	}




	public void setScooterid(int scooterid) {
		this.scooterid = scooterid;
	}




	public DTRegistro() {
		super();
	}
}
