package uy.urudin.datatypes;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


public class DTFactura implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
    private int id;
    private Timestamp fecha;
    private double monto;
    private String estado;
    private DTViaje viaje;
    
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
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public DTViaje getViaje() {
		return viaje;
	}
	public void setViaje(DTViaje viaje) {
		this.viaje = viaje;
	}
    
	public DTFactura(int id, Timestamp fecha, double monto, String estado, DTViaje viaje) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
		this.viaje = viaje;
	}
	
	public DTFactura() {
		super();
	}
	
}
