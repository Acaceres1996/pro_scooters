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
import javax.persistence.Version;

import uy.urudin.datatypes.DTAdmin;

@Entity(name="admin")
public class Admin implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, length=20)
    private String usuario;
    @Column(nullable=false, length=500)
    private String password;

    /** Default constructor. */
    public Admin() {
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
     * Access method for usuario.
     *
     * @return the current value of usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuario.
     *
     * @param aUsuario the new value for usuario
     */
    public void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }
    
    public Admin(DTAdmin dtAdmin) {
    	this.id = dtAdmin.getId();
		this.usuario = dtAdmin.getUsuario();
		this.password = dtAdmin.getPassword() ;
	}
	
	public DTAdmin getDTAdmin() {
		return new DTAdmin(this.getId(),this.getUsuario(), this.getPassword());
	}

	/**
	 * @param id
	 * @param usuario
	 * @param password
	 */
	public Admin(int id, String usuario, String password) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}
	
	

}
