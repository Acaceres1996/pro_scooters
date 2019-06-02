// Generated with g9.

package uy.urudin.persistance.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTFactura;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTViaje;

@Entity
@Table(name="viaje", schema = "urudin")
public class Viaje implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false)
    private Timestamp fechainicio;
    private Timestamp fechafin;
    @Column(nullable=false, length=15)
    private String estado;
    @Column(nullable=false, precision=10) 
    private int minutospermitidossaldo;
    @ManyToOne(optional=false)
    @JoinColumn(name="idcliente", nullable=false)
    private Cliente cliente;
    @ManyToOne(optional=false)
    @JoinColumn(name="idscooter", nullable=false)
    private Scooter scooter;

    /** Default constructor. */
    public Viaje() {
        super();
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
     * Access method for fechainicio.
     *
     * @return the current value of fechainicio
     */
    public Timestamp getFechainicio() {
        return fechainicio;
    }

    /**
     * Setter method for fechainicio.
     *
     * @param aFechainicio the new value for fechainicio
     */
    public void setFechainicio(Timestamp aFechainicio) {
        fechainicio = aFechainicio;
    }

    /**
     * Access method for fechafin.
     *
     * @return the current value of fechafin
     */
    public Timestamp getFechafin() {
        return fechafin;
    }

    /**
     * Setter method for fechafin.
     *
     * @param aFechafin the new value for fechafin
     */
    public void setFechafin(Timestamp aFechafin) {
        fechafin = aFechafin;
    }

    /**
     * Access method for estado.
     *
     * @return the current value of estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter method for estado.
     *
     * @param aEstado the new value for estado
     */
    public void setEstado(String aEstado) {
        estado = aEstado;
    }

    /**
     * Access method for minutospermitidossaldo.
     *
     * @return the current value of minutospermitidossaldo
     */
    public int getMinutospermitidossaldo() {
        return minutospermitidossaldo;
    }

    /**
     * Setter method for minutospermitidossaldo.
     *
     * @param aMinutospermitidossaldo the new value for minutospermitidossaldo
     */
    public void setMinutospermitidossaldo(int aMinutospermitidossaldo) {
        minutospermitidossaldo = aMinutospermitidossaldo;
    }

//    /**
//     * Access method for factura.
//     *
//     * @return the current value of factura
//     */
//    public Factura getFactura() {
//        return factura;
//    }
//
//    /**
//     * Setter method for factura.
//     *
//     * @param aFactura the new value for factura
//     */
//    public void setFactura(Factura aFactura) {
//        factura = aFactura;
//    }

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
     * Access method for scooter.
     *
     * @return the current value of scooter
     */
    public Scooter getScooter() {
        return scooter;
    }

    /**
     * Setter method for scooter.
     *
     * @param aScooter the new value for scooter
     */
    public void setScooter(Scooter aScooter) {
        scooter = aScooter;
    }
    
    public Viaje(DTViaje dtViaje) {
    	this.id = dtViaje.getId();
    	this.fechainicio = dtViaje.getFechainicio();
		this.fechafin = dtViaje.getFechafin();
		this.estado = dtViaje.getEstado();
		this.minutospermitidossaldo = dtViaje.getMinutospermitidossaldo();
		//Factura factura = new Factura(dtViaje.getFactura());
		//this.factura = factura;
		Cliente cliente = new Cliente(dtViaje.getCliente());
		this.cliente = cliente;
		Scooter scooter = new Scooter(dtViaje.getScooter());
		this.scooter = scooter;
	}
	
	public DTViaje getDTViaje() {
		return new DTViaje(
				this.getId(),
				this.getFechainicio(), 
				this.getFechafin(),
				this.getEstado(),
				this.getMinutospermitidossaldo(),
				//this.getFactura().getDTFactura(),
				this.getCliente().getDTCliente(),
				this.getScooter().getDTScooter()); 
	}

	/**
	 * @param id
	 * @param fechainicio
	 * @param fechafin
	 * @param estado
	 * @param minutospermitidossaldo
	 * @param factura
	 * @param cliente
	 * @param scooter
	 */
	public Viaje(int id, Timestamp fechainicio, Timestamp fechafin, String estado, int minutospermitidossaldo,
			Cliente cliente, Scooter scooter) {
		super();
		this.id = id;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.estado = estado;
		this.minutospermitidossaldo = minutospermitidossaldo;
		//this.factura = factura;
		this.cliente = cliente;
		this.scooter = scooter;
	}

	
}
