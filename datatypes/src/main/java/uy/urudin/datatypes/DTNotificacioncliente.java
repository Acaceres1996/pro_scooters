package uy.urudin.datatypes;

import java.io.Serializable;


public class DTNotificacioncliente implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;

	private int id;
    private boolean leido;
    private DTCliente cliente;
    private DTNotificacion notificacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	public DTCliente getCliente() {
		return cliente;
	}

	public void setCliente(DTCliente cliente) {
		this.cliente = cliente;
	}

	public DTNotificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(DTNotificacion notificacion) {
		this.notificacion = notificacion;
	}
	
	public DTNotificacioncliente(int id, boolean leido, DTCliente cliente, DTNotificacion notificacion) {
		super();
		this.id = id;
		this.leido = leido;
		this.cliente = cliente;
		this.notificacion = notificacion;
	}
	
	public DTNotificacioncliente() {
		super();
	}
	
}
