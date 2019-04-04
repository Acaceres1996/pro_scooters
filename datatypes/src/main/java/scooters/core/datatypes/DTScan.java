package scooters.core.datatypes;

import java.io.Serializable;

public class DTScan implements Serializable {

	private static final long serialVersionUID = 1L;	
	private Integer Id;
	private Integer CustomerId;
	private Integer ScooterId;
	
	public DTScan() {
		super();
	}
	
	public DTScan(Integer Id, Integer CustomerId, Integer ScooterId) {
		this.setId(Id);
		this.setCustomerId(CustomerId);
		this.setScooterId(ScooterId);
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}
	public Integer getScooterId() {
		return ScooterId;
	}
	public void setScooterId(Integer scooterId) {
		ScooterId = scooterId;
	}
}
