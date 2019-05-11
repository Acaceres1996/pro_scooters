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
@Table(name="cliente", indexes={@Index(name="cliente_email_IX", columnList="email", unique=true)})
public class Cliente implements Serializable {

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
    private String nombre;
    @Column(nullable=false, length=20)
    private String apellido;
    @Column(unique=true, nullable=false, length=50)
    private String email;
    @Column(nullable=false, precision=10)
    private int saldo;
    @OneToMany(mappedBy="cliente")
    private Set<Notificacioncliente> notificacioncliente;
    @OneToMany(mappedBy="cliente")
    private Set<Viaje> viaje;

    /** Default constructor. */
    public Cliente() {
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
     * Access method for apellido.
     *
     * @return the current value of apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter method for apellido.
     *
     * @param aApellido the new value for apellido
     */
    public void setApellido(String aApellido) {
        apellido = aApellido;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for saldo.
     *
     * @return the current value of saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Setter method for saldo.
     *
     * @param aSaldo the new value for saldo
     */
    public void setSaldo(int aSaldo) {
        saldo = aSaldo;
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
     * Compares the key for this instance with another Cliente.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Cliente and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Cliente)) {
            return false;
        }
        Cliente that = (Cliente) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Cliente.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cliente)) return false;
        return this.equalKeys(other) && ((Cliente)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Cliente |");
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
