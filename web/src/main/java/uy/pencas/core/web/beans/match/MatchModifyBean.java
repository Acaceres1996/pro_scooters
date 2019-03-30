package uy.pencas.core.web.beans.match;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeStated;
import uy.pencas.core.logic.interfaces.CompetitionFacadeLocal;
import uy.pencas.core.logic.interfaces.MatchFacadeRemote;
import uy.pencas.core.logic.interfaces.TeamFacadeLocal;

@ManagedBean(name = "match_modify", eager = true)
public class MatchModifyBean {

	@EJB
	MatchFacadeRemote matchEJB;
	@EJB
	CompetitionFacadeLocal competitionEJB;
	@EJB
	TeamFacadeLocal teamEJB;
	
	DTMatch p = new DTMatch();
	
	int selectedItem; // CREAR +getter +setter para que funcione
    Map<String, String> availableItems; //CREAR +getter +setter para que funcione
    
	int selectedTeamLocal; // CREAR +getter +setter para que funcione
    Map<String, String> availableTeamLocals; //CREAR +getter +setter para que funcione
	
	int selectedTeamVisitor; // CREAR +getter +setter para que funcione
    Map<String, String> availableTeamVisitors; 
	
	public MatchModifyBean() {
		this.load();
	}
	
	@PostConstruct
	public void init() {
		//para interactuar con otros EJB se hace aca.
		this.getTeamVisitor();
		this.getCompetition();
		this.getTeamLocal();
	}
	
	public String modifyMatch() {
		
		DTCompetition competition = competitionEJB.find(selectedItem);
		DTTeam teamLocal = teamEJB.find(selectedTeamLocal);
		DTTeam teamVisitor = teamEJB.find(selectedTeamVisitor);
		
		p.setCompetition(competition);
		p.setTeamLocal(teamLocal);
		p.setTeamVisitor(teamVisitor);
		
		matchEJB.update(p);	
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().remove("dtmatch_mod");
		external.getSessionMap().remove("selectedItem");
		external.getSessionMap().remove("selectedTeamLocal");
		external.getSessionMap().remove("selectedTeamVisitor");
		return "match_manage.xhtml?faces-redirect=true";
	}	
	
	public void getTeamLocal(){
		 //System.out.println("actualizo getTeamLocal()");
		//System.out.println("selectedItem:"+this.getSelectedItem());
		 Map<String, String> availableTeamLocalsAux  = new LinkedHashMap<String, String>();
		 List<DTTeam> DtTeams = new ArrayList<DTTeam>();
		 DtTeams = teamEJB.findAll();
		for(DTTeam onedtTeam : DtTeams) {
			//System.out.println("ESTOY 2");
			availableTeamLocalsAux.put(onedtTeam.getName(),onedtTeam.getId().toString());
		}
		//System.out.println("availableTeamLocalsAux Size:"+ availableTeamLocalsAux.size());
		this.setAvailableTeamLocals(availableTeamLocalsAux);
	}
	
	public void getTeamVisitor(){
		//System.out.println("actualizo getTeamVisitor()");
		//System.out.println("selectedItem:"+this.getSelectedItem());
		//System.out.println("SelectedTeamLocal():"+this.getSelectedTeamLocal());
		 Map<String, String> availableTeamVisitorsAux  = new LinkedHashMap<String, String>();
		 List<DTTeam> DtTeams = new ArrayList<DTTeam>();
		 DtTeams = teamEJB.findAll();
		 //System.out.println("ESTOY 1");
		for(DTTeam onedtTeam : DtTeams) {
			//System.out.println("ESTOY 2");
				availableTeamVisitorsAux.put(onedtTeam.getName(),onedtTeam.getId().toString());
		}
		//System.out.println("availableTeamVisitorsAux Size:"+ availableTeamVisitorsAux.size());
		this.setAvailableTeamVisitors(availableTeamVisitorsAux);
	}

	public void getCompetition(){
	//System.out.println("actualizo getCompetition()");
		 Map<String, String> availableItemsAux  = new LinkedHashMap<String, String>();
		 List<DTCompetition> DtCompetitions = new ArrayList<DTCompetition>();
		 DtCompetitions = competitionEJB.findAll();
		for(DTCompetition onedtComp : DtCompetitions) {
			availableItemsAux.put(onedtComp.getName(),onedtComp.getId().toString());
		}
		this.setAvailableItems(availableItemsAux);
	}
	
	public Integer getSelectedTeamLocal() {
		return selectedTeamLocal;
	}

	public void setSelectedTeamLocal(Integer selectedTeamLocal) {
		this.selectedTeamLocal = selectedTeamLocal;
	}

	public Map<String, String> getAvailableTeamLocals() {
		return availableTeamLocals;
	}

	public void setAvailableTeamLocals(Map<String, String> availableTeamLocals) {
		this.availableTeamLocals = availableTeamLocals;
	}

	public Integer getSelectedTeamVisitor() {
		return selectedTeamVisitor;
	}

	public void setSelectedTeamVisitor(Integer selectedTeamVisitor) {
		this.selectedTeamVisitor = selectedTeamVisitor;
	}

	public Map<String, String> getAvailableTeamVisitors() {
		return availableTeamVisitors;
	}

	public void setAvailableTeamVisitors(Map<String, String> availableTeamVisitors) {
		this.availableTeamVisitors = availableTeamVisitors;
	}
	
	public Integer getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Integer selectedItem) {
		this.selectedItem = selectedItem;
	}

	public Map<String, String> getAvailableItems() {
		return availableItems;
	}

	public void setAvailableItems(Map<String, String> availableItems) {
		this.availableItems = availableItems;
	}
	
	public DTMatch getP() {
		return p;
	}

	public void setP(DTMatch p) {
		this.p = p;
	}
	
	public TypeStated[] getTypes(){
		return TypeStated.values();
	}
	
	public void load() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		if(  external.getSessionMap().containsKey("dtmatch_mod") ) {
			//System.out.println("Entre Match");
			p = (DTMatch) external.getSessionMap().get("dtmatch_mod");
			selectedItem = (Integer) external.getSessionMap().get("selectedItem");
			selectedTeamLocal = (Integer) external.getSessionMap().get("selectedTeamLocal");
			selectedTeamVisitor = (Integer) external.getSessionMap().get("selectedTeamVisitor");
			//System.out.println("p.getId()"+p.getId());
			//System.out.println("selectedItem"+ selectedItem );
			//System.out.println("selectedTeamLocal"+ selectedTeamLocal );
			//System.out.println("selectedTeamVisitor"+ selectedTeamVisitor );

		}else {
			//System.out.println("Algo fallo, no lo logré cargar Match");
		}
	}
}
