package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.pencas.core.datatypes.datatypes.DTGlobalRanking;
import uy.pencas.core.persistance.interfaces.GlobalRankingDAOLocal;
import uy.pencas.core.persistance.model.GlobalRanking;



@Stateful
public class GlobalRankingDAO implements GlobalRankingDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public GlobalRankingDAO() {
    }

	@Override
	public void add(DTGlobalRanking dtGlobalRanking) {
		//con id null
		GlobalRanking team = new GlobalRanking(dtGlobalRanking);
		em.persist(team);
	}

	@Override
	public void merge(DTGlobalRanking dtGlobalRanking) {
		GlobalRanking team = new GlobalRanking(dtGlobalRanking);
		em.merge(team);
	}

	@Override
	public void delete(DTGlobalRanking dtGlobalRanking) {
		GlobalRanking team = new GlobalRanking(dtGlobalRanking);
		em.remove(em.merge(team));
	}
	
	@Override
	public DTGlobalRanking find(Integer id) {
		GlobalRanking team = em.find(GlobalRanking.class, id);
		return team.getDTGlobalRanking();
	}
	
	@Override
	public List<DTGlobalRanking> findAll() {
		//List<GlobalRanking> Listteam = em.createQuery("SELECT t FROM GlobalRanking t", GlobalRanking.class).getResultList();
//		List<GlobalRanking> Listteam = em.createQuery("SELECT t FROM GlobalRanking t order by t.score_partial DESC", GlobalRanking.class).getResultList();
		Query query = em.createNativeQuery("SELECT p.* FROM global_ranking p order by p.score_partial DESC", GlobalRanking.class);
		List<GlobalRanking> Listteam = (List<GlobalRanking>) query.getResultList();
		List<DTGlobalRanking> ListDT = new ArrayList<DTGlobalRanking>();
		for(GlobalRanking t : Listteam){
			ListDT.add(t.getDTGlobalRanking());
		}
		return ListDT; 
	}
	
	@Override
	public DTGlobalRanking getDTRankingByCompetitorPenca(Integer idcompetitor,Integer idpenca,Integer IdOrganizacion) {

		Query query = em.createNativeQuery("SELECT p.* FROM global_ranking p where p.id_penca = :penca and p.id_competitor = :competitor and id_organization = :organization", GlobalRanking.class);
        query.setParameter("penca", idpenca);
        query.setParameter("competitor", idcompetitor);
        query.setParameter("organization", IdOrganizacion);
        GlobalRanking s = null;
        DTGlobalRanking DtRanking = null;
        try {
        	 s = (GlobalRanking) query.getSingleResult();
        	 DtRanking = s.getDTGlobalRanking();
		} catch (Exception e) {
//			System.out.println(e.toString());
			s = null;
			DtRanking = null;
		}
		return DtRanking;
	}

}
