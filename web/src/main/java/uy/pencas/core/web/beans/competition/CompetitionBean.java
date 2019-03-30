package uy.pencas.core.web.beans.competition;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.datatypes.enumerated.TypeSport;
import uy.pencas.core.logic.interfaces.CompetitionFacadeRemote;

@RequestScoped
@ManagedBean(name = "competitionBean", eager = true)
public class CompetitionBean {

	@EJB
	CompetitionFacadeRemote competitionEJB;
		
	public CompetitionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<DTCompetition> getCompetitions(){
		return competitionEJB.findAll();
	}
	


	public String goToModify(DTCompetition p) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().put("dtcompetition_mod", p );
		return ("competition_modify.xhtml?faces-redirect=true");
	}
	
	public TypeSport[] getTypes(){
		return TypeSport.values();
	}

}
