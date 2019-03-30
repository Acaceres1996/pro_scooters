package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTGlobalRanking;


/**
 * The persistent class for the global_ranking database table.
 * 
 */
@Entity
@Table(name="global_ranking")
@NamedQuery(name="GlobalRanking.findAll", query="SELECT g FROM GlobalRanking g")
public class GlobalRanking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="id_penca")
	private Integer idPenca;

	@Column(name="score_partial")
	private Integer scorePartial;

	//bi-directional many-to-one association to GlobalCompetitor
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_competitor", referencedColumnName="id"),
		@JoinColumn(name="id_organization", referencedColumnName="id_organization")
		})
	private GlobalCompetitor globalCompetitor;

	
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

	public GlobalRanking() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPenca() {
		return this.idPenca;
	}

	public void setIdPenca(Integer idPenca) {
		this.idPenca = idPenca;
	}

	public Integer getScorePartial() {
		return this.scorePartial;
	}

	public void setScorePartial(Integer scorePartial) {
		this.scorePartial = scorePartial;
	}

	public GlobalCompetitor getGlobalCompetitor() {
		return this.globalCompetitor;
	}

	public void setGlobalCompetitor(GlobalCompetitor globalCompetitor) {
		this.globalCompetitor = globalCompetitor;
	}

	public GlobalRanking(DTGlobalRanking dtGlobalRanking) {
		this.id = dtGlobalRanking.getId();
		this.idPenca = dtGlobalRanking.getIdPenca();
		this.scorePartial = dtGlobalRanking.getScorePartial();
		GlobalCompetitor globalCompetitor = new GlobalCompetitor(dtGlobalRanking.getGlobalCompetitor());
		this.globalCompetitor = globalCompetitor;
		this.name = dtGlobalRanking.getName();
		this.lastname = dtGlobalRanking.getLastname();
		this.mail = dtGlobalRanking.getMail();
	}

	public DTGlobalRanking getDTGlobalRanking() {
		return new DTGlobalRanking(this.getId(),this.getIdPenca(),this.getScorePartial(),this.getGlobalCompetitor().getDTGlobalCompetitorBasic(), this.name, this.lastname,this.mail);
	}
}