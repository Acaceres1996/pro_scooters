package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;



//GlobalRanking
public class DTGlobalRanking implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private Integer idPenca;
	private Integer scorePartial;
	private DTGlobalCompetitor globalCompetitor;
	private String name;
	private String lastname;
	private String mail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPenca() {
		return idPenca;
	}
	public void setIdPenca(Integer idPenca) {
		this.idPenca = idPenca;
	}
	public Integer getScorePartial() {
		return scorePartial;
	}
	public void setScorePartial(Integer scorePartial) {
		this.scorePartial = scorePartial;
	}

	public DTGlobalRanking() {
		super();
	}
	public DTGlobalCompetitor getGlobalCompetitor() {
		return globalCompetitor;
	}
	public void setGlobalCompetitor(DTGlobalCompetitor globalCompetitor) {
		this.globalCompetitor = globalCompetitor;
	}
	public DTGlobalRanking(Integer id, Integer idPenca, Integer scorePartial, DTGlobalCompetitor globalCompetitor, String name,String lastname, String mail) {
		super();
		this.id = id;
		this.idPenca = idPenca;
		this.scorePartial = scorePartial;
		this.globalCompetitor = globalCompetitor;
		this.name = name;
		this.lastname = lastname;
		this.mail = mail;
	}

	
	
}
