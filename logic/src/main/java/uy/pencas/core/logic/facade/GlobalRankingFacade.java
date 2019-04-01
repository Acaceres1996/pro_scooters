package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import scooters.core.logic.interfaces.GlobalRankingFacadeLocal;
import scooters.core.logic.interfaces.GlobalRankingFacadeRemote;
import uy.pencas.core.datatypes.datatypes.DTGlobalRanking;
import uy.pencas.core.persistance.interfaces.GlobalRankingDAOLocal;

/**
 * Session Bean implementation class GlobalRankingFacade
 */
@Stateless
@LocalBean
public class GlobalRankingFacade implements GlobalRankingFacadeRemote, GlobalRankingFacadeLocal {

	@EJB
	GlobalRankingDAOLocal globalRankingDAO;
	
    /**
     * Default constructor. 
     */
    public GlobalRankingFacade() {
        
    }

	@Override
	public void add(DTGlobalRanking dtGlobalRanking) {
		globalRankingDAO.add(dtGlobalRanking);
	}

	@Override
	public void update(DTGlobalRanking dtGlobalRanking) {
		
		DTGlobalRanking dtOld = globalRankingDAO.getDTRankingByCompetitorPenca(dtGlobalRanking.getGlobalCompetitor().getId().getId(),dtGlobalRanking.getIdPenca(),dtGlobalRanking.getGlobalCompetitor().getId().getIdOrganization());
		if( dtOld != null) {
			System.out.println("Si ya existe el registro lo actualizo.");
			//globalRankingDAO.delete(dtOld);
			dtGlobalRanking.setId(dtOld.getId());
		}
		
		globalRankingDAO.merge(dtGlobalRanking);
	}

	@Override
	public void delete(DTGlobalRanking dtGlobalRanking) {
		globalRankingDAO.delete(dtGlobalRanking);
	}

	@Override
	public DTGlobalRanking find(Integer id) {
		return globalRankingDAO.find(id);
	}

	@Override
	public List<DTGlobalRanking> findAll() {
		return globalRankingDAO.findAll();
	}

	@Override
	public DTGlobalRanking getDTRankingByCompetitorPenca(Integer idcompetitor, Integer idpenca,
			Integer IdOrganizacion) {
System.out.println("idcompetitor"+idcompetitor.toString());
System.out.println("idpenca"+idpenca.toString());
System.out.println("IdOrganizacion"+IdOrganizacion.toString());
		return globalRankingDAO.getDTRankingByCompetitorPenca(idcompetitor, idpenca, IdOrganizacion);
	}
	

}
