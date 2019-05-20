package uy.urudin.datatypes;

import java.io.Serializable;

public class DTMonederohistorico implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private DTCliente cliente;
	private int saldoprevio;
	private int saldocarga;
	

	public DTMonederohistorico(int id,DTCliente cliente, int saldoprevio, int saldocarga) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.saldoprevio = saldoprevio;
		this.saldocarga = saldocarga;
	}
	
	public DTMonederohistorico(int id, int saldoprevio, int saldocarga) {
		super();
		this.id = id;
		this.saldoprevio = saldoprevio;
		this.saldocarga = saldocarga;
	}
	
	public DTMonederohistorico() {
		super();
	}

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

	public int getSaldoprevio() {
		return saldoprevio;
	}

	public void setSaldoprevio(int saldoprevio) {
		this.saldoprevio = saldoprevio;
	}

	public int getSaldocarga() {
		return saldocarga;
	}

	public void setSaldocarga(int saldocarga) {
		this.saldocarga = saldocarga;
	}
	
}
