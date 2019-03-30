package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;


public class DTGlobalCompetitorPK implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private Integer idOrganization;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdOrganization() {
		return idOrganization;
	}
	public void setIdOrganization(Integer idOrganization) {
		this.idOrganization = idOrganization;
	}
	
	public DTGlobalCompetitorPK(Integer id, Integer idOrganization) {
		this.id = id;
		this.idOrganization = idOrganization;
	}
	
	public DTGlobalCompetitorPK() {
		super();
	}
	
	
}
