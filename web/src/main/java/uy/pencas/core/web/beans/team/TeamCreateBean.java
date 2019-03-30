package uy.pencas.core.web.beans.team;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeSport;
import uy.pencas.core.logic.interfaces.TeamFacadeRemote;

@RequestScoped
@ManagedBean(name = "team_create", eager = true)
public class TeamCreateBean {

	@EJB
	TeamFacadeRemote teamEJB;
	
	DTTeam p = new DTTeam();
	
	public TeamCreateBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String createTeam() {
		List<DTMatch> matchesLocal = new ArrayList<DTMatch>();
		List<DTMatch> matchesVisitor = new ArrayList<DTMatch>();
		p.setMatchesLocal(matchesLocal);
		p.setMatchesVisitor(matchesVisitor);
		teamEJB.add(p);
		return "team_manage.xhtml?faces-redirect=true";
	}
	
	public TypeSport[] getTypes(){
		return TypeSport.values();
	}

	public DTTeam getP() {
		return p;
	}

	public void setP(DTTeam p) {
		this.p = p;
	}
	
	
	
}
