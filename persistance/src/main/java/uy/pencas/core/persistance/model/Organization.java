package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;
import uy.pencas.core.datatypes.datatypes.DTOrganization;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeStatus;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private TypeStatus approved;

	@Column(name="id_admin")
	private Integer idAdmin;

	private String name;

	//bi-directional many-to-one association to GlobalCompetitor
	@OneToMany(mappedBy="organization")
	private List<GlobalCompetitor> globalCompetitors;

	public Organization() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeStatus getApproved() {
		return this.approved;
	}

	public void setApproved(TypeStatus approved) {
		this.approved = approved;
	}

	public Integer getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GlobalCompetitor> getGlobalCompetitors() {
		return this.globalCompetitors;
	}

	public void setGlobalCompetitors(List<GlobalCompetitor> globalCompetitors) {
		this.globalCompetitors = globalCompetitors;
	}

	public GlobalCompetitor addGlobalCompetitor(GlobalCompetitor globalCompetitor) {
		getGlobalCompetitors().add(globalCompetitor);
		globalCompetitor.setOrganization(this);

		return globalCompetitor;
	}

	public GlobalCompetitor removeGlobalCompetitor(GlobalCompetitor globalCompetitor) {
		getGlobalCompetitors().remove(globalCompetitor);
		globalCompetitor.setOrganization(null);

		return globalCompetitor;
	}
	
	public Organization(DTOrganization dtOrganization) {
		this.id = dtOrganization.getId();
		this.approved = dtOrganization.getApproved();
		this.idAdmin = dtOrganization.getIdAdmin();
		this.name = dtOrganization.getName();
	}
	
	public DTOrganization getDTOrganization() {
		List<DTGlobalCompetitor> dtGlobalCompetitors = new ArrayList<DTGlobalCompetitor>();
		for(GlobalCompetitor gc : this.getGlobalCompetitors()) {
			dtGlobalCompetitors.add(gc.getDTGlobalCompetitorBasic());
		}
		return new DTOrganization(this.getId(),this.getApproved(),this.getIdAdmin(),this.getName(), dtGlobalCompetitors);
	}

	public DTOrganization getDTOrganizationBasic() {
		return new DTOrganization(this.getId(),this.getApproved(),this.getIdAdmin(),this.getName(), null);
	}
}