package uy.pencas.core.web.beans.team;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeSport;
import uy.pencas.core.logic.interfaces.TeamFacadeRemote;

@ManagedBean(name = "team_modify", eager = true)
public class TeamModifyBean {

	@EJB
	TeamFacadeRemote teamEJB;
	
	DTTeam p = new DTTeam();
	
	public TeamModifyBean() {
		this.load();
	}
	
	public String modifyTeam() {
		teamEJB.update(p);				
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().remove("dtteam_mod");
		return "team_manage.xhtml?faces-redirect=true";
	}	
	
	public DTTeam getP() {
		return p;
	}

	public void setP(DTTeam p) {
		this.p = p;
	}

	public TypeSport[] getTypes(){
		return TypeSport.values();
	}
	
	public void load() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		if(  external.getSessionMap().containsKey("dtteam_mod") ) {
			System.out.println("Entre Team");
			p = (DTTeam) external.getSessionMap().get("dtteam_mod");
			System.out.println(p.getId());
		}else {
			System.out.println("Algo fallo, no lo logré cargar Team");
		}
	}
}
