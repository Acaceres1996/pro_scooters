package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;
import java.util.Date;

import uy.pencas.core.datatypes.enumerated.TypeStated;




//Match
public class DTMatch implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	   
	private Integer id;
	private Integer localResult;
	private TypeStated stated;
	private Integer visitorResult;

	private Date started;
	private DTCompetition competition;
	private DTTeam teamLocal;
	private DTTeam teamVisitor;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLocalResult() {
		return localResult;
	}
	public void setLocalResult(Integer localResult) {
		this.localResult = localResult;
	}
	public Date getStarted() {
		return started;
	}
	public void setStarted(Date started) {
		this.started = started;
	}
	public TypeStated getStated() {
		return stated;
	}
	public void setStated(TypeStated stated) {
		this.stated = stated;
	}
	public Integer getVisitorResult() {
		return visitorResult;
	}
	public void setVisitorResult(Integer visitorResult) {
		this.visitorResult = visitorResult;
	}
	public DTCompetition getCompetition() {
		return competition;
	}
	public void setCompetition(DTCompetition competition) {
		this.competition = competition;
	}
	public DTTeam getTeamLocal() {
		return teamLocal;
	}
	public void setTeamLocal(DTTeam teamLocal) {
		this.teamLocal = teamLocal;
	}
	public DTTeam getTeamVisitor() {
		return teamVisitor;
	}
	public void setTeamVisitor(DTTeam teamVisitor) {
		this.teamVisitor = teamVisitor;
	}

	public DTMatch() {
		super();
	}
	
	public DTMatch(Integer id, Integer localResult, Date started, TypeStated stated, Integer visitorResult, 
			DTCompetition competition, DTTeam teamLocal, DTTeam teamVisitor) {
		super();
		this.id = id;
		this.localResult = localResult;
		this.started = started;
		this.stated = stated;
		this.visitorResult = visitorResult;
		this.competition = competition;
		this.teamLocal = teamLocal;
		this.teamVisitor = teamVisitor;
	}
	
}
