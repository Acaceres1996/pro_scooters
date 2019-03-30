package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;
import uy.pencas.core.persistance.interfaces.GlobalCompetitorDAOLocal;
import uy.pencas.core.persistance.model.GlobalCompetitor;
import uy.pencas.core.persistance.model.GlobalCompetitorPK;


@Stateful
public class GlobalCompetitorDAO implements GlobalCompetitorDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public GlobalCompetitorDAO() {
    }

	@Override
	public void add(DTGlobalCompetitor dtGlobalCompetitor) {
		GlobalCompetitor globalCompetitor = new GlobalCompetitor(dtGlobalCompetitor);
		em.persist(globalCompetitor);
	}

	@Override
	public void merge(DTGlobalCompetitor dtGlobalCompetitor) {		
		GlobalCompetitor globalCompetitor = new GlobalCompetitor(dtGlobalCompetitor);
		em.merge(globalCompetitor);
	}

	@Override
	public void delete(DTGlobalCompetitor dtGlobalCompetitor) {		
		GlobalCompetitor globalCompetitor = new GlobalCompetitor(dtGlobalCompetitor);
		em.remove(em.merge(globalCompetitor));
	}
	
	@Override
	public DTGlobalCompetitor find(Integer id, Integer idOrganization) {		
		// TODO test composite primary key
		GlobalCompetitorPK pk = new GlobalCompetitorPK(id,idOrganization);
		
		GlobalCompetitor globalCompetitor = em.find(GlobalCompetitor.class, pk);
		return globalCompetitor.getDTGlobalCompetitor();
	}
	
	@Override
	public List<DTGlobalCompetitor> findAll() {		
		List<GlobalCompetitor> ListglobalCompetitor = em.createQuery("SELECT t FROM GlobalCompetitor t", GlobalCompetitor.class).getResultList();
		List<DTGlobalCompetitor> ListDT = new ArrayList<DTGlobalCompetitor>();
		for(GlobalCompetitor t : ListglobalCompetitor){
			ListDT.add(t.getDTGlobalCompetitor());
		}
		return ListDT; 
	}

}
