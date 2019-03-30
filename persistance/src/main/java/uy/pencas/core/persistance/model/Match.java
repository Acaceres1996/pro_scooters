package uy.pencas.core.persistance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.enumerated.TypeStated;






/**
 * The persistent class for the match database table.
 * 
 */
@Entity
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="local_result")
	private Integer localResult;

	private Date started;

	@Enumerated(EnumType.STRING)
	private TypeStated stated;

	@Column(name="visitor_result")
	private Integer visitorResult;

	//bi-directional many-to-one association to Competition
	@ManyToOne
	@JoinColumn(name="id_competition")
	private Competition competition;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="id_team_local")
//	private Team team1;
	private Team teamLocal;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="id_team_visitor")
//	private Team team2;
	private Team teamVisitor;

	public Match() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLocalResult() {
		return this.localResult;
	}

	public void setLocalResult(Integer localResult) {
		this.localResult = localResult;
	}

	public Date getStarted() {
		return this.started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public TypeStated getStated() {
		return this.stated;
	}

	public void setStated(TypeStated stated) {
		this.stated = stated;
	}

	public Integer getVisitorResult() {
		return this.visitorResult;
	}

	public void setVisitorResult(Integer visitorResult) {
		this.visitorResult = visitorResult;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Team getTeamLocal() {
		return this.teamLocal;
	}

	public void setTeamLocal(Team teamLocal) {
		this.teamLocal = teamLocal;
	}

	public Team getTeamVisitor() {
		return this.teamVisitor;
	}

	public void setTeamVisitor(Team teamVisitor) {
		this.teamVisitor = teamVisitor;
	}

	public Match(DTMatch dtMatch) {
		this.id = dtMatch.getId();
		this.localResult = dtMatch.getLocalResult();
		this.started = dtMatch.getStarted();
		this.stated = dtMatch.getStated();
		this.visitorResult = dtMatch.getVisitorResult();
		this.competition = new Competition (dtMatch.getCompetition());
		this.teamLocal = new Team (dtMatch.getTeamLocal());
		this.teamVisitor = new Team (dtMatch.getTeamVisitor());
	}
	
	public DTMatch getDTMatch() {
		return new DTMatch(this.getId(),
				this.getLocalResult(),
				this.getStarted(),
				this.getStated(),
				this.getVisitorResult(),
				this.getCompetition().getDTCompetitionBasic(),
				this.getTeamLocal().getDTTeamBasic(),
				this.getTeamVisitor().getDTTeamBasic()
				);
	}
	public DTMatch getDTMatchBasic() {
		return new DTMatch(this.getId(),
				this.getLocalResult(),
				this.getStarted(),
				this.getStated(),
				this.getVisitorResult(),
				null, //solo no muestro competencias
				this.getTeamLocal().getDTTeamBasic(),
				this.getTeamVisitor().getDTTeamBasic()
				);
	}

}