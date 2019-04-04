package scooters.core.persistance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import scooters.core.datatypes.DTScan;

@Embeddable
public class Scan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="Id", insertable=true, updatable=false)
	private Integer Id;		
	private Integer CustomerId;	
	private Integer ScooterReportId;
	
	public Scan() {
		
	}
	
	public Scan(DTScan s) {
		this.setId( s.getId() );
		this.setCustomerId( s.getCustomerId() );
		this.setScooterReportId( s.getScooterReportId() );
	}
	
	public DTScan toDataType() {
		return new DTScan( this.getId(), this.getCustomerId(), this.getScooterReportId());
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
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
	public void setScooterReportId(Integer scooterReportId) {
		ScooterReportId = scooterReportId;
	}
	
}
