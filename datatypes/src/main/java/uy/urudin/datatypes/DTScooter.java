package uy.urudin.datatypes;

import java.io.Serializable;



public class DTScooter implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String numeroserial;
	private boolean encendido;
	private boolean enuso;
	private boolean eliminado;
	//Scooterhistorico> scooterhistorico
	//Viaje> viaje
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public DTScooter(int id, String numeroserial, boolean encendido, boolean enuso, boolean eliminado) {
		super();
		this.id = id;
		this.numeroserial = numeroserial;
		this.encendido = encendido;
		this.enuso = enuso;
		this.eliminado = eliminado;
	}

	
}
