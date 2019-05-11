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

@Entity
@Table(name="scooter", indexes={@Index(name="scooter_numeroserial_IX", columnList="numeroserial", unique=true)})
public class Scooter implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

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

    /**
     * Compares the key for this instance with another Scooter.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Scooter and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Scooter)) {
            return false;
        }
        Scooter that = (Scooter) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Scooter.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Scooter)) return false;
        return this.equalKeys(other) && ((Scooter)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Scooter |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
