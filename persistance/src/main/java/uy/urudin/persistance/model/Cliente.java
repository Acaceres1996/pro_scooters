package uy.urudin.persistance.model;
// Generated Apr 9, 2019 11:18:31 PM by Hibernate Tools 5.2.8.Final

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import uy.urudin.datatypes.datatypes.DTCliente;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "email", nullable = false, length = 30)
	private String email;

	public Cliente() {
	}

	public Cliente(int id, String email) {
		this.id = id;
		this.email = email;
	}

	public Cliente(int id, String email, Set<Registro> registros, Set<Notificacion> notificacions) {
		this.id = id;
		this.email = email;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente(DTCliente dtCliente) {
		this.id = dtCliente.getId();
		this.email = dtCliente.getEmail();
	}
	
	public DTCliente getDTCliente() {
		return new DTCliente(this.getId(),this.getEmail());
	}

}
