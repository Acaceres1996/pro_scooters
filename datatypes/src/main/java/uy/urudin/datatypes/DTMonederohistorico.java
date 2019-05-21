package uy.urudin.datatypes;

import java.io.Serializable;
import java.util.Date;


public class DTMonederohistorico implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private int id;
	private DTCliente dtcliente;
	private Date fecha;
	private int saldoanterior;
	private String motivo;
	private int monto;
	private String idtransaccion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DTCliente getDtcliente() {
		return dtcliente;
	}
	public void setDtcliente(DTCliente dtcliente) {
		this.dtcliente = dtcliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getSaldoanterior() {
		return saldoanterior;
	}
	public void setSaldoanterior(int saldoanterior) {
		this.saldoanterior = saldoanterior;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public String getIdtransaccion() {
		return idtransaccion;
	}
	public void setIdtransaccion(String idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	
	public DTMonederohistorico() {
		super();
	}
	public DTMonederohistorico(int id, DTCliente dtcliente, Date fecha, int saldoanterior, String motivo, int monto,
			String idtransaccion) {
		super();
		this.id = id;
		this.dtcliente = dtcliente;
		this.fecha = fecha;
		this.saldoanterior = saldoanterior;
		this.motivo = motivo;
		this.monto = monto;
		this.idtransaccion = idtransaccion;
	}
	public DTMonederohistorico(int id, DTCliente dtcliente, Date fecha, int saldoanterior, String motivo, int monto) {
		super();
		this.id = id;
		this.dtcliente = dtcliente;
		this.fecha = fecha;
		this.saldoanterior = saldoanterior;
		this.motivo = motivo;
		this.monto = monto;
	}
	
	
	
	
}
