package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.persistance.interfaces.CompetitionDAOLocal;
import uy.pencas.core.persistance.model.Competition;



@Stateful
public class CompetitionDAO implements CompetitionDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public CompetitionDAO() {
    }

	@Override
	public void add(DTCompetition dtCompetition) {
		Competition competition = new Competition(dtCompetition);
		em.persist(competition);
	}

	@Override
	public void merge(DTCompetition dtCompetition) {
		Competition competition = new Competition(dtCompetition);
		em.merge(competition);
	}

	@Override
	public void delete(DTCompetition dtCompetition) {
		Competition competition = new Competition(dtCompetition);
		em.remove(em.merge(competition));
	}
	
	@Override
	public DTCompetition find(Integer id) {
		Competition competition = em.find(Competition.class, id);
		return competition.getDTCompetition();
	}
	
	@Override
	public List<DTCompetition> findAll() {
		List<Competition> ListComp = em.createQuery("SELECT c FROM Competition c", Competition.class).getResultList();
		List<DTCompetition> ListDT = new ArrayList<DTCompetition>();
		for(Competition t : ListComp){
			ListDT.add(t.getDTCompetition());
		}
		return ListDT; 
	}

}
