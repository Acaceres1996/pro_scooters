package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import scooters.core.logic.interfaces.MatchFacadeLocal;
import scooters.core.logic.interfaces.MatchFacadeRemote;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.persistance.interfaces.MatchDAOLocal;

/**
 * Session Bean implementation class MatchFacade
 */
@Stateless
@LocalBean
public class MatchFacade implements MatchFacadeRemote, MatchFacadeLocal {

	@EJB
	MatchDAOLocal teamDAO;
	
    /**
     * Default constructor. 
     */
    public MatchFacade() {
        
    }

	@Override
	public void add(DTMatch dtMatch) {
		teamDAO.add(dtMatch);
	}

	@Override
	public void update(DTMatch dtMatch) {
		teamDAO.merge(dtMatch);
	}

	@Override
	public void delete(DTMatch dtMatch) {
		teamDAO.delete(dtMatch);
	}

	@Override
	public DTMatch find(Integer id) {
		return teamDAO.find(id);
	}

	@Override
	public List<DTMatch> findAll() {
		return teamDAO.findAll();
	}
	

}
