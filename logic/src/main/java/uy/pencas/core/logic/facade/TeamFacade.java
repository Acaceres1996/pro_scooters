package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.logic.interfaces.TeamFacadeLocal;
import uy.pencas.core.logic.interfaces.TeamFacadeRemote;

import uy.pencas.core.persistance.interfaces.TeamDAOLocal;

/**
 * Session Bean implementation class TeamFacade
 */
@Stateless
@LocalBean
public class TeamFacade implements TeamFacadeRemote, TeamFacadeLocal {

	@EJB
	TeamDAOLocal teamDAO;
	
    /**
     * Default constructor. 
     */
    public TeamFacade() {
        
    }

	@Override
	public void add(DTTeam dtTeam) {
		teamDAO.add(dtTeam);
	}

	@Override
	public void update(DTTeam dtTeam) {
		teamDAO.merge(dtTeam);
	}

	@Override
	public void delete(DTTeam dtTeam) {
		teamDAO.delete(dtTeam);
	}

	@Override
	public DTTeam find(Integer id) {
		return teamDAO.find(id);
	}

	@Override
	public List<DTTeam> findAll() {
		return teamDAO.findAll();
	}
	

}
