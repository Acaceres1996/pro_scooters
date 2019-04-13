package uy.urudin.persistance.model;
// Generated Apr 9, 2019 11:18:31 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uy.urudin.datatypes.datatypes.DTRegistro;
import uy.urudin.datatypes.datatypes.DTScooter;

/**
 * Registro generated by hbm2java
 */
@Entity
@Table(name = "registro", schema = "public")
public class Registro implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idscooter", nullable = false)
	private Scooter scooter;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", length = 29)
	private Date fecha;

	public Registro() {
	}

	public Registro(int id, Cliente cliente, Scooter scooter) {
		this.id = id;
		this.cliente = cliente;
		this.scooter = scooter;
	}

	public Registro(int id, Cliente cliente, Scooter scooter, Date fecha) {
		this.id = id;
		this.cliente = cliente;
		this.scooter = scooter;
		this.fecha = fecha;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Scooter getScooter() {
		return this.scooter;
	}

	public void setScooter(Scooter scooter) {
		this.scooter = scooter;
	}


	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	public Registro(DTRegistro dtRegistro) {
		this.id = dtRegistro.getId();
		
		this.cliente = new Cliente(dtRegistro.getCliente());
		this.scooter = new Scooter(dtRegistro.getScooter());
		this.fecha = dtRegistro.getFecha();
	}
	
	public DTRegistro getDTRegistro() {
		return new DTRegistro(this.getId(),this.getCliente().getDTCliente(),this.getScooter().getDTScooter(),this.getFecha());
	}
}
