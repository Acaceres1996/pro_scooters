package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;
import java.util.Date;


//PaymentRequest
public class DTPaymentRequest implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private Integer amount;
	private Date created;
	private Integer idRequest;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Integer getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public DTPaymentRequest() {
		super();
	}
	public DTPaymentRequest(Integer id, Integer amount, Date created, Integer idRequest) {
		super();
		this.id = id;
		this.amount = amount;
		this.created = created;
		this.idRequest = idRequest;
	}

	
}
