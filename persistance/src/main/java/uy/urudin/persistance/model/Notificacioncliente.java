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

@Entity(name="notificacioncliente")
public class Notificacioncliente implements Serializable {

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
     * Compares the key for this instance with another Notificacioncliente.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Notificacioncliente and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Notificacioncliente)) {
            return false;
        }
        Notificacioncliente that = (Notificacioncliente) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Notificacioncliente.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Notificacioncliente)) return false;
        return this.equalKeys(other) && ((Notificacioncliente)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Notificacioncliente |");
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
