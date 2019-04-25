package uy.urudin.datatypes;

import java.io.Serializable;


public class DTScooter implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String latitud;
	private String longitud;
	private Integer bateria;
	private boolean encendido;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Integer getBateria() {
		return bateria;
	}
	public void setBateria(Integer bateria) {
		this.bateria = bateria;
	}
	public boolean isEncendido() {
		return encendido;
	}
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	public DTScooter() {
		super();
	}
	/**
	 * @param id
	 * @param latitud
	 * @param longitud
	 * @param bateria
	 * @param encendido
	 */
	public DTScooter(int id, String latitud, String longitud, Integer bateria, boolean encendido) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.bateria = bateria;
		this.encendido = encendido;
	}

	
}
