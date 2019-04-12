package uy.urudin.datatypes.datatypes;

import java.io.Serializable;
import java.util.Date;


public class DTRegistro implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private DTCliente cliente;
	private DTScooter scooter;
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @param id
	 * @param cliente
	 * @param scooter
	 * @param fecha
	 */
	public DTRegistro(int id, DTCliente cliente, DTScooter scooter, Date fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.scooter = scooter;
		this.fecha = fecha;
	}

	
}
