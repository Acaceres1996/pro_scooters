package uy.pencas.core.web.beans.match;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.enumerated.TypeStated;
import uy.pencas.core.logic.interfaces.MatchFacadeRemote;

@RequestScoped
@ManagedBean(name = "matchBean", eager = true)
public class MatchBean {

	@EJB
	MatchFacadeRemote matchEJB;
		
	public MatchBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<DTMatch> getMatchs(){
		return matchEJB.findAll();
	}
	


	public String goToModify(DTMatch p, int selectedItem, int selectedTeamLocal, int selectedTeamVisitor) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().put("dtmatch_mod", p );
		external.getSessionMap().put("selectedItem", selectedItem );
		external.getSessionMap().put("selectedTeamLocal", selectedTeamLocal );
		external.getSessionMap().put("selectedTeamVisitor", selectedTeamVisitor );
		return ("match_modify.xhtml?faces-redirect=true");
	}
	
	public TypeStated[] getTypes(){
		return TypeStated.values();
	}

}
