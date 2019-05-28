package uy.urudin.datatypes;

import java.io.Serializable;

public class DTScooterScan implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	/*
	esta es numero serial, si se encuentra encendido, 
	si está arrendado, la batería restante, kilómetros disponibles para recorrer, 
	costo fijo, costo por minuto
	*/
	private int id;
	private String numeroserial;
	private boolean encendido;
	private boolean enuso;
	private int bateria;
	private double kmDisponibles;
	private double costoMinuto;
    private double costoBase;

    
	public DTScooterScan(int id, String numeroserial, boolean encendido, boolean enuso, int bateria,
			double kmDisponibles, double costoMinuto, double costoBase) {
		super();
		this.id = id;
		this.numeroserial = numeroserial;
		this.encendido = encendido;
		this.enuso = enuso;
		this.bateria = bateria;
		this.kmDisponibles = kmDisponibles;
		this.costoMinuto = costoMinuto;
		this.costoBase = costoBase;
	}
    
	public DTScooterScan() {
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


	public int getBateria() {
		return bateria;
	}


	public void setBateria(int bateria) {
		this.bateria = bateria;
	}


	public double getKmDisponibles() {
		return kmDisponibles;
	}


	public void setKmDisponibles(double kmDisponibles) {
		this.kmDisponibles = kmDisponibles;
	}


	public double getCostoMinuto() {
		return costoMinuto;
	}


	public void setCostoMinuto(double costoMinuto) {
		this.costoMinuto = costoMinuto;
	}


	public double getCostoBase() {
		return costoBase;
	}


	public void setCostoBase(double costoBase) {
		this.costoBase = costoBase;
	}
	
	
}
