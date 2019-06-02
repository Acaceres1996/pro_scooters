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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTFactura;
import uy.urudin.datatypes.DTViaje;

@Entity
@Table(name="factura", schema = "urudin")
public class Factura implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false)
    private Timestamp fecha;
    @Column(nullable=false, precision=17, scale=17)
    private double monto;
    @Column(nullable=false, length=15)
    private String estado;
    @OneToOne(optional=false)
    @JoinColumn(name="idviaje", nullable=false)
    private Viaje viaje;

    /** Default constructor. */
    public Factura() {
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
     * Access method for fecha.
     *
     * @return the current value of fecha
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * Setter method for fecha.
     *
     * @param aFecha the new value for fecha
     */
    public void setFecha(Timestamp aFecha) {
        fecha = aFecha;
    }

    /**
     * Access method for monto.
     *
     * @return the current value of monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Setter method for monto.
     *
     * @param aMonto the new value for monto
     */
    public void setMonto(double aMonto) {
        monto = aMonto;
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
     * Access method for viaje.
     *
     * @return the current value of viaje
     */
    public Viaje getViaje() {
        return viaje;
    }

    /**
     * Setter method for viaje.
     *
     * @param aViaje the new value for viaje
     */
    public void setViaje(Viaje aViaje) {
        viaje = aViaje;
    }
    
    public Factura(DTFactura dtFactura) {
    	this.id = dtFactura.getId();
		this.fecha = dtFactura.getFecha();
		this.monto = dtFactura.getMonto();
		this.estado = dtFactura.getEstado();
		Viaje viaje = new Viaje(dtFactura.getViaje());
		this.viaje = viaje;
	}
	
	public DTFactura getDTFactura() {
		return new DTFactura(this.getId(),this.getFecha(),this.getMonto(),this.getEstado(),this.getViaje().getDTViaje());
	}

	/**
	 * @param id
	 * @param fecha
	 * @param monto
	 * @param estado
	 * @param viaje
	 */
	public Factura(int id, Timestamp fecha, double monto, String estado, Viaje viaje) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
		this.viaje = viaje;
	}
	
//	public DTFactura getDTFacturaBasic() {
//		return new DTFactura(this.getId(),this.getFecha(),this.getMonto(),this.getEstado(),null);
//	}
	
	


}
