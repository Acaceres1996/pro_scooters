package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTPaymentReward;

import java.util.Date;


/**
 * The persistent class for the payment_reward database table.
 * 
 */
@Entity
@Table(name="payment_reward")
@NamedQuery(name="PaymentReward.findAll", query="SELECT p FROM PaymentReward p")
public class PaymentReward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer amount;

	private Date created;

	@Column(name="id_reward")
	private Integer idReward;

	public PaymentReward() {
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

	public Integer getIdReward() {
		return this.idReward;
	}

	public void setIdReward(Integer idReward) {
		this.idReward = idReward;
	}


	public PaymentReward(DTPaymentReward dtPaymentReward) {
		super();
		this.id = dtPaymentReward.getId();
		this.amount = dtPaymentReward.getAmount();
		this.created = dtPaymentReward.getCreated();
		this.idReward = dtPaymentReward.getIdReward();
	}
	
	public DTPaymentReward getDTPaymentReward() {
		return new DTPaymentReward(this.id,this.amount,this.created,this.idReward);
	}
	

}