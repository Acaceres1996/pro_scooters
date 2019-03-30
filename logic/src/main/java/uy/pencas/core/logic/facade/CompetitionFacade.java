package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.logic.interfaces.CompetitionFacadeLocal;
import uy.pencas.core.logic.interfaces.CompetitionFacadeRemote;
import uy.pencas.core.persistance.interfaces.CompetitionDAOLocal;

/**
 * Session Bean implementation class TeamFacade
 */
@Stateless
@LocalBean
public class CompetitionFacade implements CompetitionFacadeRemote, CompetitionFacadeLocal {

	@EJB
	CompetitionDAOLocal competitionDAO;
	
    /**
     * Default constructor. 
     */
    public CompetitionFacade() {
        
    }

	@Override
	public void add(DTCompetition dtCompetition) {
		competitionDAO.add(dtCompetition);
	}

	@Override
	public void update(DTCompetition dtCompetition) {
		competitionDAO.merge(dtCompetition);
	}

	@Override
	public void delete(DTCompetition dtCompetition) {
		competitionDAO.delete(dtCompetition);
	}

	@Override
	public DTCompetition find(Integer id) {
		return competitionDAO.find(id);
	}

	@Override
	public List<DTCompetition> findAll() {
		return competitionDAO.findAll();
	}
	

}
