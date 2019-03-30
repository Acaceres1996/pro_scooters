package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class DTGlobalCompetitor implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private DTGlobalCompetitorPK id;
	private Integer idPenca;
	private Integer idRequest;
	private Integer idUser;
	private Date joined;
	private DTOrganization organization;
	private List<DTGlobalRanking> globalRankings;
	
	public DTGlobalCompetitorPK getId() {
		return id;
	}
	public void setId(DTGlobalCompetitorPK id) {
		this.id = id;
	}
	public Integer getIdPenca() {
		return idPenca;
	}
	public void setIdPenca(Integer idPenca) {
		this.idPenca = idPenca;
	}
	public Integer getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Date getJoined() {
		return joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}
	public DTOrganization getOrganization() {
		return organization;
	}
	public void setOrganization(DTOrganization organization) {
		this.organization = organization;
	}
	public List<DTGlobalRanking> getGlobalRankings() {
		return globalRankings;
	}
	public void setGlobalRankings(List<DTGlobalRanking> globalRankings) {
		this.globalRankings = globalRankings;
	}
	
	
	
	public DTGlobalCompetitor(DTGlobalCompetitorPK id, Integer idPenca, Integer idRequest, 
			Integer idUser, Date joined, DTOrganization organization, List<DTGlobalRanking> globalRankings) {
		this.id = id;
		this.idPenca = idPenca;
		this.idRequest = idRequest;
		this.idUser = idUser;
		this.joined = joined;
		this.organization = organization;
		this.globalRankings = globalRankings;
	}

	public DTGlobalCompetitor() {
		super();
	}
	
	
}
