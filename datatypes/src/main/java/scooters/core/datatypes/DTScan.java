package scooters.core.datatypes;

import java.io.Serializable;

public class DTScan implements Serializable {

	private static final long serialVersionUID = 1L;	
	private Integer Id;
	private Integer CustomerId;
	private Integer ScooterReportId;
	
	public DTScan() {
		super();
	}
	
	public DTScan(Integer Id, Integer CustomerId, Integer ScooterReportId) {
		this.setId(Id);
		this.setCustomerId(CustomerId);
		this.setScooterReportId(ScooterReportId);
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
	public Integer getScooterReportId() {
		return ScooterReportId;
	}
	public void setScooterReportId(Integer ScooterReportId) {
		this.ScooterReportId = ScooterReportId;
	}
}
