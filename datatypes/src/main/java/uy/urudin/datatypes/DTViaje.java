package uy.urudin.datatypes;

import java.io.Serializable;
import java.sql.Timestamp;


public class DTViaje implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
    private Timestamp fechainicio;
    private Timestamp fechafin;
    private String estado;
    private int minutospermitidossaldo;
    private DTFactura factura;
    private DTCliente cliente;
    private DTScooter scooter;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Timestamp getFechafin() {
		return fechafin;
	}
	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getMinutospermitidossaldo() {
		return minutospermitidossaldo;
	}
	public void setMinutospermitidossaldo(int minutospermitidossaldo) {
		this.minutospermitidossaldo = minutospermitidossaldo;
	}
	public DTFactura getFactura() {
		return factura;
	}
	public void setFactura(DTFactura factura) {
		this.factura = factura;
	}
	public DTCliente getCliente() {
		return cliente;
	}
	public void setCliente(DTCliente cliente) {
		this.cliente = cliente;
	}
	public DTScooter getScooter() {
		return scooter;
	}
	public void setScooter(DTScooter scooter) {
		this.scooter = scooter;
	}
    
	public DTViaje(int id, Timestamp fechainicio, Timestamp fechafin, String estado, int minutospermitidossaldo,
			DTFactura factura, DTCliente cliente, DTScooter scooter) {
		super();
		this.id = id;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.estado = estado;
		this.minutospermitidossaldo = minutospermitidossaldo;
		this.factura = factura;
		this.cliente = cliente;
		this.scooter = scooter;
	}
	
	public DTViaje() {
		super();
	}
}
