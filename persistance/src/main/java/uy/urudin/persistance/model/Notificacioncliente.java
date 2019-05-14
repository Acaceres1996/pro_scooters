// Generated with g9.

package uy.urudin.persistance.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import uy.urudin.datatypes.DTNotificacioncliente;

@Entity(name="notificacioncliente")
public class Notificacioncliente implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, length=1)
    private boolean leido;
    @ManyToOne(optional=false)
    @JoinColumn(name="idcliente", nullable=false)
    private Cliente cliente;
    @ManyToOne(optional=false)
    @JoinColumn(name="idnotificacion", nullable=false)
    private Notificacion notificacion;

    /** Default constructor. */
    public Notificacioncliente() {
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
     * Access method for leido.
     *
     * @return true if and only if leido is currently true
     */
    public boolean getLeido() {
        return leido;
    }

    /**
     * Setter method for leido.
     *
     * @param aLeido the new value for leido
     */
    public void setLeido(boolean aLeido) {
        leido = aLeido;
    }

    /**
     * Access method for cliente.
     *
     * @return the current value of cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Setter method for cliente.
     *
     * @param aCliente the new value for cliente
     */
    public void setCliente(Cliente aCliente) {
        cliente = aCliente;
    }

    /**
     * Access method for notificacion.
     *
     * @return the current value of notificacion
     */
    public Notificacion getNotificacion() {
        return notificacion;
    }

    /**
     * Setter method for notificacion.
     *
     * @param aNotificacion the new value for notificacion
     */
    public void setNotificacion(Notificacion aNotificacion) {
        notificacion = aNotificacion;
    }

	/**
	 * @param id
	 * @param leido
	 * @param cliente
	 * @param notificacion
	 */
	public Notificacioncliente(int id, boolean leido, Cliente cliente, Notificacion notificacion) {
		super();
		this.id = id;
		this.leido = leido;
		this.cliente = cliente;
		this.notificacion = notificacion;
	}
    
	public Notificacioncliente(DTNotificacioncliente DtNotificacioncliente) {
		super();
		this.id = DtNotificacioncliente.getId();
		this.leido = DtNotificacioncliente.isLeido();
		Cliente cliente = new Cliente(DtNotificacioncliente.getCliente());
		this.cliente = cliente;
		Notificacion notificacion = new Notificacion(DtNotificacioncliente.getNotificacion());
		this.notificacion = notificacion;
	}
	
	public DTNotificacioncliente getDTNotificacioncliente() {
		return new DTNotificacioncliente(
				this.getId(),
				this.getLeido(),
				this.getCliente().getDTCliente(),
				this.getNotificacion().getDTNotificacion()
				);
	}
    

}
