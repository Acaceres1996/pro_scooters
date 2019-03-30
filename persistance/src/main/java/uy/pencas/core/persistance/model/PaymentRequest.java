package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTPaymentRequest;

import java.util.Date;


/**
 * The persistent class for the payment_request database table.
 * 
 */
@Entity
@Table(name="payment_request")
@NamedQuery(name="PaymentRequest.findAll", query="SELECT p FROM PaymentRequest p")
public class PaymentRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer amount;

	private Date created;

	@Column(name="id_request")
	private Integer idRequest;

	public PaymentRequest() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}


	public PaymentRequest(DTPaymentRequest dtPaymentRequest) {
		super();
		this.id = dtPaymentRequest.getId();
		this.amount = dtPaymentRequest.getAmount();
		this.created = dtPaymentRequest.getCreated();
		this.idRequest = dtPaymentRequest.getIdRequest();
	}
	
	public DTPaymentRequest getDTPaymentRequest() {
		return new DTPaymentRequest(this.id,this.amount,this.created,this.idRequest);
	}

}