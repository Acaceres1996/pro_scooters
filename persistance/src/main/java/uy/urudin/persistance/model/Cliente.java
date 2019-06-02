// Generated with g9.

package uy.urudin.persistance.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;

@Entity
@Table(name="cliente", schema = "urudin", indexes={@Index(name="cliente_email_IX", columnList="email", unique=true)})
public class Cliente implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, length=20)
    private String nombre;
    @Column(nullable=false, length=20)
    private String apellido;
    @Column(unique=true, nullable=false, length=50)
    private String email;
    @Column(nullable=false, precision=10)
    private int saldo;
//    @OneToMany(mappedBy="cliente")
//    private Set<Notificacioncliente> notificacioncliente;
//    @OneToMany(mappedBy="cliente")
//    private Set<Viaje> viaje;

    /** Default constructor. */
    public Cliente() {
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for apellido.
     *
     * @return the current value of apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter method for apellido.
     *
     * @param aApellido the new value for apellido
     */
    public void setApellido(String aApellido) {
        apellido = aApellido;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for saldo.
     *
     * @return the current value of saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Setter method for saldo.
     *
     * @param aSaldo the new value for saldo
     */
    public void setSaldo(int aSaldo) {
        saldo = aSaldo;
    }

    /**
//     * Access method for notificacioncliente.
//     *
//     * @return the current value of notificacioncliente
//     */
//    public Set<Notificacioncliente> getNotificacioncliente() {
//        return notificacioncliente;
//    }
//
//    /**
//     * Setter method for notificacioncliente.
//     *
//     * @param aNotificacioncliente the new value for notificacioncliente
//     */
//    public void setNotificacioncliente(Set<Notificacioncliente> aNotificacioncliente) {
//        notificacioncliente = aNotificacioncliente;
//    }
//
//    /**
//     * Access method for viaje.
//     *
//     * @return the current value of viaje
//     */
//    public Set<Viaje> getViaje() {
//        return viaje;
//    }
//
//    /**
//     * Setter method for viaje.
//     *
//     * @param aViaje the new value for viaje
//     */
//    public void setViaje(Set<Viaje> aViaje) {
//        viaje = aViaje;
//    }

    public Cliente(DTCliente dtCliente) {
    	this.id = dtCliente.getId();
		this.nombre = dtCliente.getNombre();
		this.apellido = dtCliente.getApellido();
		this.email = dtCliente.getEmail();
		this.saldo = dtCliente.getSaldo();
	}
	
	public DTCliente getDTCliente() {
		return new DTCliente(this.getId(),this.getNombre(),this.getApellido(),this.getEmail(),this.getSaldo());
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param saldo
	 */
	public Cliente(int id, String nombre, String apellido, String email, int saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.saldo = saldo;
	}
    
	
}
