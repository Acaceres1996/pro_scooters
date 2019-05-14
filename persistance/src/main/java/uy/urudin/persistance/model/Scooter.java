// Generated with g9.

package uy.urudin.persistance.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
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

import uy.urudin.datatypes.DTFactura;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.datatypes.DTViaje;

@Entity
@Table(name="scooter", indexes={@Index(name="scooter_numeroserial_IX", columnList="numeroserial", unique=true)})
public class Scooter implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(unique=true, nullable=false, length=20)
    private String numeroserial;
    @Column(nullable=false, length=1)
    private boolean encendido;
    @Column(nullable=false, length=1)
    private boolean enuso;
    @Column(nullable=false, length=1)
    private boolean eliminado;
    @OneToMany(mappedBy="scooter")
    private Set<Scooterhistorico> scooterhistorico;
    @OneToMany(mappedBy="scooter")
    private Set<Viaje> viaje;

    /** Default constructor. */
    public Scooter() {
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
     * Access method for numeroserial.
     *
     * @return the current value of numeroserial
     */
    public String getNumeroserial() {
        return numeroserial;
    }

    /**
     * Setter method for numeroserial.
     *
     * @param aNumeroserial the new value for numeroserial
     */
    public void setNumeroserial(String aNumeroserial) {
        numeroserial = aNumeroserial;
    }

    /**
     * Access method for encendido.
     *
     * @return true if and only if encendido is currently true
     */
    public boolean getEncendido() {
        return encendido;
    }

    /**
     * Setter method for encendido.
     *
     * @param aEncendido the new value for encendido
     */
    public void setEncendido(boolean aEncendido) {
        encendido = aEncendido;
    }

    /**
     * Access method for enuso.
     *
     * @return true if and only if enuso is currently true
     */
    public boolean getEnuso() {
        return enuso;
    }

    /**
     * Setter method for enuso.
     *
     * @param aEnuso the new value for enuso
     */
    public void setEnuso(boolean aEnuso) {
        enuso = aEnuso;
    }

    /**
     * Access method for eliminado.
     *
     * @return true if and only if eliminado is currently true
     */
    public boolean getEliminado() {
        return eliminado;
    }

    /**
     * Setter method for eliminado.
     *
     * @param aEliminado the new value for eliminado
     */
    public void setEliminado(boolean aEliminado) {
        eliminado = aEliminado;
    }

    /**
     * Access method for scooterhistorico.
     *
     * @return the current value of scooterhistorico
     */
    public Set<Scooterhistorico> getScooterhistorico() {
        return scooterhistorico;
    }

    /**
     * Setter method for scooterhistorico.
     *
     * @param aScooterhistorico the new value for scooterhistorico
     */
    public void setScooterhistorico(Set<Scooterhistorico> aScooterhistorico) {
        scooterhistorico = aScooterhistorico;
    }

    /**
     * Access method for viaje.
     *
     * @return the current value of viaje
     */
    public Set<Viaje> getViaje() {
        return viaje;
    }

    /**
     * Setter method for viaje.
     *
     * @param aViaje the new value for viaje
     */
    public void setViaje(Set<Viaje> aViaje) {
        viaje = aViaje;
    }
    
    public DTScooter getDTScooterBasic() {
		return new DTScooter(
				this.getId(),
				this.getNumeroserial(),
				this.getEncendido(),
				this.getEnuso(),
				this.getEliminado(),
				null,
				null);
	}

}
