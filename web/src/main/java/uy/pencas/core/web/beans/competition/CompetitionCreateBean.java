package uy.pencas.core.web.beans.competition;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.enumerated.TypeSport;
import uy.pencas.core.logic.interfaces.CompetitionFacadeRemote;

@RequestScoped
@ManagedBean(name = "competition_create", eager = true)
public class CompetitionCreateBean {

	@EJB
	CompetitionFacadeRemote competitionEJB;
	
	DTCompetition p = new DTCompetition();
	
	public CompetitionCreateBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String createCompetition() {
		List<DTMatch> matches = new ArrayList<DTMatch>();
		p.setMatches(matches);
		competitionEJB.add(p);
		return "competition_manage.xhtml?faces-redirect=true";
	}
	
	public TypeSport[] getTypes(){
		return TypeSport.values();
	}

	public DTCompetition getP() {
		return p;
	}

	public void setP(DTCompetition p) {
		this.p = p;
	}
	
	
	
}
