package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;
import uy.pencas.core.datatypes.datatypes.DTGlobalRanking;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the global_competitor database table.
 * 
 */
@Entity
@Table(name="global_competitor")
@NamedQuery(name="GlobalCompetitor.findAll", query="SELECT g FROM GlobalCompetitor g")
public class GlobalCompetitor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GlobalCompetitorPK id;

	@Column(name="id_penca")
	private Integer idPenca;

	@Column(name="id_request")
	private Integer idRequest;

	@Column(name="id_user")
	private Integer idUser;

	private Date joined;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="id_organization", insertable = false, updatable = false)
	private Organization organization;

	//bi-directional many-to-one association to GlobalRanking
	@OneToMany(mappedBy="globalCompetitor")
	private List<GlobalRanking> globalRankings;

	public GlobalCompetitor() {
	}

	public GlobalCompetitorPK getId() {
		return this.id;
	}

	public void setId(GlobalCompetitorPK id) {
		this.id = id;
	}

	public Integer getIdPenca() {
		return this.idPenca;
	}

	public void setIdPenca(Integer idPenca) {
		this.idPenca = idPenca;
	}

	public Integer getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Date getJoined() {
		return this.joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<GlobalRanking> getGlobalRankings() {
		return this.globalRankings;
	}

	public void setGlobalRankings(List<GlobalRanking> globalRankings) {
		this.globalRankings = globalRankings;
	}

	public GlobalRanking addGlobalRanking(GlobalRanking globalRanking) {
		getGlobalRankings().add(globalRanking);
		globalRanking.setGlobalCompetitor(this);

		return globalRanking;
	}

	public GlobalRanking removeGlobalRanking(GlobalRanking globalRanking) {
		getGlobalRankings().remove(globalRanking);
		globalRanking.setGlobalCompetitor(null);

		return globalRanking;
	}

	public GlobalCompetitor(GlobalCompetitorPK id, Integer idPenca, Integer idRequest, Integer idUser, Date joined,
			Organization organization) {
		super();
		this.id = id;
		this.idPenca = idPenca;
		this.idRequest = idRequest;
		this.idUser = idUser;
		this.joined = joined;
		this.organization = organization;
	}
	
	public GlobalCompetitor(DTGlobalCompetitor dtGlobalCompetitor) {
		//cuidado
		GlobalCompetitorPK globalCompetitorPK = new GlobalCompetitorPK(dtGlobalCompetitor.getId());
		
		this.id = globalCompetitorPK;
		this.idPenca = dtGlobalCompetitor.getIdPenca();
		this.idRequest = dtGlobalCompetitor.getIdRequest();
		this.idUser = dtGlobalCompetitor.getIdUser();
		this.joined = dtGlobalCompetitor.getJoined();
		Organization organization = new Organization(dtGlobalCompetitor.getOrganization());
		this.organization = organization;

	}

	public DTGlobalCompetitor getDTGlobalCompetitor() {
		List<DTGlobalRanking> globalRankings = new ArrayList<DTGlobalRanking>();
		for(GlobalRanking gr : this.getGlobalRankings()) {
			globalRankings.add(gr.getDTGlobalRanking()); //ya es basic
		}		
		return new DTGlobalCompetitor(this.getId().getDTGlobalCompetitorPK(),
				this.getIdPenca(),
				this.getIdRequest(),
				this.getIdUser(),
				this.getJoined(),
				this.getOrganization().getDTOrganizationBasic(),
				globalRankings);
	}
	
	public DTGlobalCompetitor getDTGlobalCompetitorBasic() {
		return new DTGlobalCompetitor(this.getId().getDTGlobalCompetitorPK(),
				this.getIdPenca(),
				this.getIdRequest(),
				this.getIdUser(),
				this.getJoined(),
				this.getOrganization().getDTOrganizationBasic(),
				null);
	}
	
	
}