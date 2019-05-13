package uy.urudin.datatypes;

import java.io.Serializable;
import java.util.Set;


public class DTNotificacion implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
    private String cabezal;
    private String cuerpo;
    private String estado;
    private boolean masiva;
    private Set<DTNotificacioncliente> notificacioncliente;

	public DTNotificacion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCabezal() {
		return cabezal;
	}

	public void setCabezal(String cabezal) {
		this.cabezal = cabezal;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isMasiva() {
		return masiva;
	}

	public void setMasiva(boolean masiva) {
		this.masiva = masiva;
	}

	public Set<DTNotificacioncliente> getNotificacioncliente() {
		return notificacioncliente;
	}

	public void setNotificacioncliente(Set<DTNotificacioncliente> notificacioncliente) {
		this.notificacioncliente = notificacioncliente;
	}
	
	public DTNotificacion(int id, String cabezal, String cuerpo, String estado, boolean masiva,
			Set<DTNotificacioncliente> notificacioncliente) {
		super();
		this.id = id;
		this.cabezal = cabezal;
		this.cuerpo = cuerpo;
		this.estado = estado;
		this.masiva = masiva;
		this.notificacioncliente = notificacioncliente;
	}
	
}
