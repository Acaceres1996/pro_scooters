package uy.urudin.datatypes;

import java.io.Serializable;
import java.util.List;



public class DTScooter implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String numeroserial;
	private boolean encendido;
	private boolean enuso;
	private boolean eliminado;
//	private List <DTScooterhistorico> scooterhistorico;
//	private List <DTViaje> viaje;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroserial() {
		return numeroserial;
	}
	public void setNumeroserial(String numeroserial) {
		this.numeroserial = numeroserial;
	}
	public boolean isEncendido() {
		return encendido;
	}
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	public boolean isEnuso() {
		return enuso;
	}
	public void setEnuso(boolean enuso) {
		this.enuso = enuso;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
//	public List<DTScooterhistorico> getScooterhistorico() {
//		return scooterhistorico;
//	}
//	public void setScooterhistorico(List<DTScooterhistorico> scooterhistorico) {
//		this.scooterhistorico = scooterhistorico;
//	}
//	public List<DTViaje> getViaje() {
//		return viaje;
//	}
//	public void setViaje(List<DTViaje> viaje) {
//		this.viaje = viaje;
//	}

	public DTScooter() {
		super();
	}

	public DTScooter(int id, String numeroserial, boolean encendido, boolean enuso, boolean eliminado) {
		super();
		this.id = id;
		this.numeroserial = numeroserial;
		this.encendido = encendido;
		this.enuso = enuso;
		this.eliminado = eliminado;
	}

}
