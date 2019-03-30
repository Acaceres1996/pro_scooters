package uy.pencas.core.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.datatypes.enumerated.TypePrize;
import uy.pencas.core.logic.interfaces.PrizeFacadeLocal;
import uy.pencas.core.logic.interfaces.PrizeFacadeRemote;
import uy.pencas.core.persistance.interfaces.PrizeDAOLocal;

/**
 * Session Bean implementation class TeamFacade
 */
@Stateless
@LocalBean
public class PrizeFacade implements PrizeFacadeRemote, PrizeFacadeLocal {

	@EJB
	PrizeDAOLocal PrizeDAO;
	
    /**
     * Default constructor. 
     */
    public PrizeFacade() {
        
    }

	@Override
	public void add(DTPrize dtPrize) {
		PrizeDAO.add(dtPrize);
	}

	@Override
	public void update(DTPrize dtPrize) {
		PrizeDAO.merge(dtPrize);
	}

	@Override
	public void delete(DTPrize dtPrize) {
		PrizeDAO.delete(dtPrize);
	}

	@Override
	public DTPrize find(Integer id) {
		return PrizeDAO.find(id);
	}

	@Override
	public List<DTPrize> findAll() {
		return PrizeDAO.findAll();
	}
	
	@Override
	public List<DTPrize> findEnabled(){
		List<DTPrize> all = this.findAll();
		List<DTPrize> enabled = new ArrayList<>();
		for(DTPrize p : all ) {
			if( p.getEnabled() ) {
				enabled.add(p);
			}
		}
		return enabled;
	}

}
