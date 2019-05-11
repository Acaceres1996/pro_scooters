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
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="notificacion")
public class Notificacion implements Serializable {

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
    @Column(nullable=false, length=20)
    private String cabezal;
    @Column(nullable=false, length=500)
    private String cuerpo;
    @Column(nullable=false, length=15)
    private String estado;
    @Column(nullable=false, length=1)
    private boolean masiva;
    @OneToMany(mappedBy="notificacion")
    private Set<Notificacioncliente> notificacioncliente;

    /** Default constructor. */
    public Notificacion() {
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
     * Access method for cabezal.
     *
     * @return the current value of cabezal
     */
    public String getCabezal() {
        return cabezal;
    }

    /**
     * Setter method for cabezal.
     *
     * @param aCabezal the new value for cabezal
     */
    public void setCabezal(String aCabezal) {
        cabezal = aCabezal;
    }

    /**
     * Access method for cuerpo.
     *
     * @return the current value of cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * Setter method for cuerpo.
     *
     * @param aCuerpo the new value for cuerpo
     */
    public void setCuerpo(String aCuerpo) {
        cuerpo = aCuerpo;
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
     * Access method for masiva.
     *
     * @return true if and only if masiva is currently true
     */
    public boolean getMasiva() {
        return masiva;
    }

    /**
     * Setter method for masiva.
     *
     * @param aMasiva the new value for masiva
     */
    public void setMasiva(boolean aMasiva) {
        masiva = aMasiva;
    }

    /**
     * Access method for notificacioncliente.
     *
     * @return the current value of notificacioncliente
     */
    public Set<Notificacioncliente> getNotificacioncliente() {
        return notificacioncliente;
    }

    /**
     * Setter method for notificacioncliente.
     *
     * @param aNotificacioncliente the new value for notificacioncliente
     */
    public void setNotificacioncliente(Set<Notificacioncliente> aNotificacioncliente) {
        notificacioncliente = aNotificacioncliente;
    }

    /**
     * Compares the key for this instance with another Notificacion.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Notificacion and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Notificacion)) {
            return false;
        }
        Notificacion that = (Notificacion) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Notificacion.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Notificacion)) return false;
        return this.equalKeys(other) && ((Notificacion)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Notificacion |");
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
