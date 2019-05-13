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
import javax.persistence.Version;

@Entity(name="scooterhistorico")
public class Scooterhistorico implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false)
    private Timestamp fecha;
    @Column(nullable=false, length=50)
    private String latitud;
    @Column(nullable=false, length=50)
    private String longitud;
    @Column(nullable=false, precision=10)
    private int bateria;
    @ManyToOne(optional=false)
    @JoinColumn(name="idscooter", nullable=false)
    private Scooter scooter;

    /** Default constructor. */
    public Scooterhistorico() {
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
     * Access method for latitud.
     *
     * @return the current value of latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * Setter method for latitud.
     *
     * @param aLatitud the new value for latitud
     */
    public void setLatitud(String aLatitud) {
        latitud = aLatitud;
    }

    /**
     * Access method for longitud.
     *
     * @return the current value of longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * Setter method for longitud.
     *
     * @param aLongitud the new value for longitud
     */
    public void setLongitud(String aLongitud) {
        longitud = aLongitud;
    }

    /**
     * Access method for bateria.
     *
     * @return the current value of bateria
     */
    public int getBateria() {
        return bateria;
    }

    /**
     * Setter method for bateria.
     *
     * @param aBateria the new value for bateria
     */
    public void setBateria(int aBateria) {
        bateria = aBateria;
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
}
