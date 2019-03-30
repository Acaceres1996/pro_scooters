package uy.pencas.core.web.beans.team;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeSport;
import uy.pencas.core.logic.interfaces.TeamFacadeRemote;

@RequestScoped
@ManagedBean(name = "teamBean", eager = true)
public class TeamBean {

	@EJB
	TeamFacadeRemote teamEJB;
		
	public TeamBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<DTTeam> getTeams(){
		return teamEJB.findAll();
	}
	


	public String goToModify(DTTeam p) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().put("dtteam_mod", p );
		return ("team_modify.xhtml?faces-redirect=true");
	}
	
	public TypeSport[] getTypes(){
		return TypeSport.values();
	}

}
