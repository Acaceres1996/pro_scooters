package uy.urudin.datatypes;

import java.io.Serializable;
import java.util.List;



public class DTScooterUltimoRegistro implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private String numeroserial;
	private boolean encendido;
	private boolean enuso;
	private boolean eliminado;
	private DTScooterhistorico ultimoregistro;
	public DTScooterUltimoRegistro(DTScooter dtscooter,
			DTScooterhistorico ultimoregistro) {
		super();
		this.id = dtscooter.getId();
		this.numeroserial = dtscooter.getNumeroserial();
		this.encendido = dtscooter.isEncendido();
		this.enuso = dtscooter.isEnuso();
		this.eliminado = dtscooter.isEliminado();
		this.ultimoregistro = ultimoregistro;
	}
	public DTScooterUltimoRegistro() {
		super();
	}
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
	public DTScooterhistorico getUltimoregistro() {
		return ultimoregistro;
	}
	public void setUltimoregistro(DTScooterhistorico ultimoregistro) {
		this.ultimoregistro = ultimoregistro;
	}

	
}
