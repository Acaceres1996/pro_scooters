package uy.urudin.persistance.model;
// Generated Apr 9, 2019 11:18:31 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uy.urudin.datatypes.datatypes.DTParametro;
import uy.urudin.datatypes.datatypes.DTScooter;

/**
 * Scooter generated by hbm2java
 */
@Entity
@Table(name = "scooter", schema = "public")
public class Scooter implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "latitud", length = 30)
	private String latitud;
	@Column(name = "longitud", length = 30)
	private String longitud;
	@Column(name = "bateria")
	private Integer bateria;
	@Column(name = "encendido", nullable = false)
	private boolean encendido;

	public Scooter() {
	}

	public Scooter(int id, boolean encendido) {
		this.id = id;
		this.encendido = encendido;
	}

	public Scooter(int id, String latitud, String longitud, Integer bateria, boolean encendido) {
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.bateria = bateria;
		this.encendido = encendido;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public Integer getBateria() {
		return this.bateria;
	}

	public void setBateria(Integer bateria) {
		this.bateria = bateria;
	}


	public boolean isEncendido() {
		return this.encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	
	public Scooter(DTScooter dtScooter) {
		this.id = dtScooter.getId();
		this.latitud = dtScooter.getLatitud();
		this.longitud = dtScooter.getLongitud();
		this.bateria = dtScooter.getBateria();
		this.encendido = dtScooter.isEncendido();
	}
	
	public DTScooter getDTScooter() {
		return new DTScooter(this.getId(),this.getLatitud(),this.getLongitud(),this.getBateria(),this.isEncendido());
	}

}