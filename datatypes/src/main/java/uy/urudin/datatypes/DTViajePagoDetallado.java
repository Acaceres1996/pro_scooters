package uy.urudin.datatypes;

import java.io.Serializable;
import java.sql.Timestamp;

public class DTViajePagoDetallado implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
    private Timestamp fechainicio;
    private Timestamp fechafin;
    private String mailCliente;
    private String numeroserial;
    private int minutos;
    private double costoTotal;
    private String estado;

	public DTViajePagoDetallado() {
		super();
	}
	
	public DTViajePagoDetallado(int id, Timestamp fechainicio, Timestamp fechafin, String mailCliente,
			String numeroserial, int minutos, double costoTotal, String estado) {
		super();
		this.id = id;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.mailCliente = mailCliente;
		this.numeroserial = numeroserial;
		this.minutos = minutos;
		this.costoTotal = costoTotal;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Timestamp getFechafin() {
		return fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public String getMailCliente() {
		return mailCliente;
	}

	public void setMailCliente(String mailCliente) {
		this.mailCliente = mailCliente;
	}

	public String getNumeroserial() {
		return numeroserial;
	}

	public void setNumeroserial(String numeroserial) {
		this.numeroserial = numeroserial;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
