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
import javax.persistence.Table;
import javax.persistence.Version;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTMonederohistorico;

@Entity(name="monederohistorico")
@Table(name="monederohistorico", schema = "public")
public class Monederohistorico implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @ManyToOne(optional=false)
    @JoinColumn(name="idcliente", nullable=false)
    private Cliente cliente;
    @Column(nullable=false, precision=10)
    private int saldoprevio;
    @Column(nullable=false, precision=10)
    private int saldocarga;

    /** Default constructor. */
    public Monederohistorico() {
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
     * Access method for saldoprevio.
     *
     * @return the current value of saldoprevio
     */
    public int getSaldoprevio() {
        return saldoprevio;
    }

    /**
     * Setter method for saldoprevio.
     *
     * @param aSaldoprevio the new value for saldoprevio
     */
    public void setSaldoprevio(int aSaldoprevio) {
        saldoprevio = aSaldoprevio;
    }

    /**
     * Access method for saldocarga.
     *
     * @return the current value of saldocarga
     */
    public int getSaldocarga() {
        return saldocarga;
    }

    /**
     * Setter method for saldocarga.
     *
     * @param aSaldocarga the new value for saldocarga
     */
    public void setSaldocarga(int aSaldocarga) {
        saldocarga = aSaldocarga;
    }

    
    public DTMonederohistorico getDTMonederohistorico() {
		return new DTMonederohistorico(
				this.getId(),
				this.getSaldoprevio(),
				this.getSaldocarga()
				);
	}
    
	public Monederohistorico(DTMonederohistorico dtMonederohistorico) {
		this.id = dtMonederohistorico.getId();
		Cliente cliente = new Cliente(dtMonederohistorico.getCliente());
		this.cliente = cliente;
		this.saldoprevio = dtMonederohistorico.getSaldoprevio();
		this.saldocarga = dtMonederohistorico.getSaldocarga();
	}

	public Monederohistorico(int id,Cliente cliente, int saldoprevio, int saldocarga) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.saldoprevio = saldoprevio;
		this.saldocarga = saldocarga;
	}
	
}
