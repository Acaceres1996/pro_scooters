package uy.pencas.core.web.beans.competition;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.enumerated.TypeSport;
import uy.pencas.core.logic.interfaces.CompetitionFacadeRemote;

@ManagedBean(name = "competition_modify", eager = true)
public class CompetitionModifyBean {

	@EJB
	CompetitionFacadeRemote competitionEJB;
	
	DTCompetition p = new DTCompetition();
	
	public CompetitionModifyBean() {
		this.load();
	}
	
	public String modifyCompetition() {
		competitionEJB.update(p);				
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().remove("dtcompetition_mod");
		return "competition_manage.xhtml?faces-redirect=true";
	}	
	
	public DTCompetition getP() {
		return p;
	}

	public void setP(DTCompetition p) {
		this.p = p;
	}

	public TypeSport[] getTypes(){
		return TypeSport.values();
	}
	
	public void load() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		if(  external.getSessionMap().containsKey("dtcompetition_mod") ) {
			System.out.println("Entre COMPETITION");
			p = (DTCompetition) external.getSessionMap().get("dtcompetition_mod");
			System.out.println(p.getId());
		}else {
			System.out.println("Algo fallo, no lo logré cargar COMPETITION");
		}
	}
}
