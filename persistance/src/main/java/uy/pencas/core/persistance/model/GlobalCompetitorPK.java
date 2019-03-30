package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitorPK;

/**
 * The primary key class for the global_competitor database table.
 * 
 */
@Embeddable
public class GlobalCompetitorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Column(name="id_organization", insertable=false, updatable=false)
	private Integer idOrganization;

	public GlobalCompetitorPK() {
	}
	

	
	/**
	 * @param id
	 * @param idOrganization
	 */
	public GlobalCompetitorPK(Integer id, Integer idOrganization) {
		super();
		this.id = id;
		this.idOrganization = idOrganization;
	}



	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdOrganization() {
		return this.idOrganization;
	}
	public void setIdOrganization(Integer idOrganization) {
		this.idOrganization = idOrganization;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GlobalCompetitorPK)) {
			return false;
		}
		GlobalCompetitorPK castOther = (GlobalCompetitorPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.idOrganization.equals(castOther.idOrganization);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.idOrganization.hashCode();
		
		return hash;
	}
	
	public GlobalCompetitorPK(DTGlobalCompetitorPK dtGlobalCompetitorPK) {
		this.id = dtGlobalCompetitorPK.getId();
		this.idOrganization = dtGlobalCompetitorPK.getIdOrganization();
	}
	
	public DTGlobalCompetitorPK getDTGlobalCompetitorPK() {
		return new DTGlobalCompetitorPK(this.getId(),this.getIdOrganization());
	}
}