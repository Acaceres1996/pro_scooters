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

}
