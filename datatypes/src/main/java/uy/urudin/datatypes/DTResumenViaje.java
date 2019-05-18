package uy.urudin.datatypes;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


public class DTResumenViaje implements Serializable  {


	private static final long serialVersionUID = 6128016096756071380L;
	
    private double minutos;
    private double costoMinuto;
    private double costoBase;
    private double costoTotal;
    
	public double getMinutos() {
		return minutos;
	}
	public void setMinutos(double minutos) {
		this.minutos = minutos;
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
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	public DTResumenViaje(double minutos, double costoMinuto, double costoBase, double costoTotal) {
		super();
		this.minutos = minutos;
		this.costoMinuto = costoMinuto;
		this.costoBase = costoBase;
		this.costoTotal = costoTotal;
	}
	
	public DTResumenViaje() {
		super();
	}
	
}
