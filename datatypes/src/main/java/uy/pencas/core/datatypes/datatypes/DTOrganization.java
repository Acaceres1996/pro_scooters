package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;
import java.util.List;

import uy.pencas.core.datatypes.enumerated.TypeStatus;


public class DTOrganization  implements Serializable {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private TypeStatus approved;
	private Integer idAdmin;
	private String name;
	private List<DTGlobalCompetitor> dtGlobalCompetitors;
	
	public void setId (Integer id) {
		this.id = id;
	}
	
	public Integer getId () {
		return id;
	}
	
	public void setApproved (TypeStatus approved) {
		this.approved = approved;
	}
	
	public TypeStatus getApproved () {
		return approved;
	}
	
	public void setIdAdmin (Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	public Integer getIdAdmin () {
		return idAdmin;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
	
	public void setDtGlobalCompetitors (List<DTGlobalCompetitor> dtGlobalCompetitors) {
		this.dtGlobalCompetitors = dtGlobalCompetitors;
	}
	
	public List<DTGlobalCompetitor> getDtGlobalCompetitors () {
		return dtGlobalCompetitors;
	}
	
	
	public DTOrganization (Integer id, TypeStatus approved, Integer idAdmin, String name, List<DTGlobalCompetitor> dtGlobalCompetitors) {
		this.id = id;
		this.approved = approved;
		this.idAdmin = idAdmin;
		this.name = name;
		this.dtGlobalCompetitors = dtGlobalCompetitors;
	}
	
	public DTOrganization() {
		super();
	}
	
}
