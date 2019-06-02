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
import javax.persistence.Table;
import javax.persistence.Version;

import uy.urudin.datatypes.DTParametro;

@Entity
@Table(name="parametro", schema = "urudin")
public class Parametro implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, length=20)
    private String nombre;
    @Column(nullable=false, length=500)
    private String valor;

    /** Default constructor. */
    public Parametro() {
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
     * Access method for valor.
     *
     * @return the current value of valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Setter method for valor.
     *
     * @param aValor the new value for valor
     */
    public void setValor(String aValor) {
        valor = aValor;
    }

	/**
	 * @param id
	 * @param nombre
	 * @param valor
	 */
	public Parametro(int id, String nombre, String valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public Parametro(DTParametro DtParametro) {
		super();
		this.id = DtParametro.getId();
		this.nombre = DtParametro.getNombre();
		this.valor = DtParametro.getValor();
	}

	
	public DTParametro getDTParametro() {
		return new DTParametro(
				this.getId(),
				this.getNombre(),
				this.getValor()
		);
	}
    
}
