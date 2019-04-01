package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import scooters.core.logic.interfaces.GlobalCompetitorFacadeLocal;
import scooters.core.logic.interfaces.GlobalCompetitorFacadeRemote;
import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;
import uy.pencas.core.persistance.interfaces.GlobalCompetitorDAOLocal;


/**
 * Session Bean implementation class TeamFacade
 */
@Stateless
@LocalBean
public class GlobalCompetitorFacade implements GlobalCompetitorFacadeRemote, GlobalCompetitorFacadeLocal {

	@EJB
	GlobalCompetitorDAOLocal competitorDAO;
	
    /**
     * Default constructor. 
     */
    public GlobalCompetitorFacade() {
        
    }

	@Override
	public void add(DTGlobalCompetitor dtGlobalCompetitor) {
		competitorDAO.add(dtGlobalCompetitor);
	}

	@Override
	public void update(DTGlobalCompetitor dtGlobalCompetitor) {
		competitorDAO.merge(dtGlobalCompetitor);
	}

	@Override
	public void delete(DTGlobalCompetitor dtGlobalCompetitor) {
		competitorDAO.delete(dtGlobalCompetitor);
	}

	@Override
	public DTGlobalCompetitor find(Integer id, Integer idOrganization) {
		return competitorDAO.find(id, idOrganization);
	}

	@Override
	public List<DTGlobalCompetitor> findAll() {
		return competitorDAO.findAll();
	}
	

}
