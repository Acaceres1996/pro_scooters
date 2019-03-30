package uy.pencas.core.web.beans.match;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeStated;
import uy.pencas.core.logic.interfaces.CompetitionFacadeLocal;
import uy.pencas.core.logic.interfaces.MatchFacadeRemote;
import uy.pencas.core.logic.interfaces.TeamFacadeLocal;


@RequestScoped
@ManagedBean(name = "match_create", eager = true)
public class MatchCreateBean {

	@EJB
	MatchFacadeRemote matchEJB;
	@EJB
	CompetitionFacadeLocal competitionEJB;
	@EJB
	TeamFacadeLocal teamEJB;
	
	DTMatch p = new DTMatch();
	
	int selectedItem = 0; // CREAR +getter +setter para que funcione
    Map<String, String> availableItems; //CREAR +getter +setter para que funcione
    
	int selectedTeamLocal= 0; // CREAR +getter +setter para que funcione
    Map<String, String> availableTeamLocals; //CREAR +getter +setter para que funcione
	
	int selectedTeamVisitor= 0; // CREAR +getter +setter para que funcione
    Map<String, String> availableTeamVisitors; //CREAR +getter +setter para que funcione
    
	public MatchCreateBean() {
	}

	@PostConstruct
	public void init() {
		//para interactuar con otros EJB se hace aca.
		this.getCompetition();
		this.getTeamLocal();
		this.getTeamVisitor();
	}
	
	public String createMatch() {
		p.setLocalResult(0);
		p.setVisitorResult(0);
//		FECHA ACTUAL.		
//		Date currentDate = Calendar.getInstance().getTime();
//		p.setStarted(currentDate);
		p.setStated(TypeStated.NOT_STARTED);

		System.out.println("selectedItem:"+selectedItem);
		System.out.println("selectedTeamLocal:"+selectedTeamLocal);
		System.out.println("selectedTeamVisitor:"+selectedTeamVisitor);
		
		DTCompetition competition = competitionEJB.find(selectedItem);
		DTTeam teamLocal = teamEJB.find(selectedTeamLocal);
		DTTeam teamVisitor = teamEJB.find(selectedTeamVisitor);
		
		p.setCompetition(competition);
		p.setTeamLocal(teamLocal);
		p.setTeamVisitor(teamVisitor);
		
		matchEJB.add(p);
		return "match_manage.xhtml?faces-redirect=true";
	}
	
//	public void selectOneMenuListener(ValueChangeEvent event) {
//	    //This will return you the newly selected
//	    //value as an object. You'll have to cast it.
//	    Object newValue = event.getNewValue(); 
//	    System.out.println("newValue:" + newValue.toString());
//	    this.setSelectedItem((Integer) newValue);
//	    this.getTeamLocal();
//		this.getTeamVisitor();
//
//	}

	public void getTeamLocal(){
		 System.out.println("actualizo getTeamLocal()");
		System.out.println("selectedItem:"+this.getSelectedItem());
		 Map<String, String> availableTeamLocalsAux  = new LinkedHashMap<String, String>();
		 List<DTTeam> DtTeams = new ArrayList<DTTeam>();
		 DtTeams = teamEJB.findAll();
		for(DTTeam onedtTeam : DtTeams) {
			availableTeamLocalsAux.put(onedtTeam.getName(),onedtTeam.getId().toString());
		}
		this.setAvailableTeamLocals(availableTeamLocalsAux);
	}
	
	public void getTeamVisitor(){
		 System.out.println("actualizo getTeamVisitor()");
		System.out.println("selectedItem:"+this.getSelectedItem());
		System.out.println("SelectedTeamLocal():"+this.getSelectedTeamLocal());
		 Map<String, String> availableTeamVisitorsAux  = new LinkedHashMap<String, String>();
		 List<DTTeam> DtTeams = new ArrayList<DTTeam>();
		 DtTeams = teamEJB.findAll();
		for(DTTeam onedtTeam : DtTeams) {
			availableTeamVisitorsAux.put(onedtTeam.getName(),onedtTeam.getId().toString());
		}
		this.setAvailableTeamVisitors(availableTeamVisitorsAux);
	}

	public void getCompetition(){
	System.out.println("actualizo getCompetition()");
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
	


}
