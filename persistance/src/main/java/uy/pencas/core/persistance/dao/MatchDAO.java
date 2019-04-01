package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.persistance.interfaces.CompetitionDAOLocal;
import uy.pencas.core.persistance.interfaces.MatchDAOLocal;
import uy.pencas.core.persistance.interfaces.TeamDAOLocal;
import uy.pencas.core.persistance.model.Match;


@Stateful
public class MatchDAO implements MatchDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@EJB
	TeamDAOLocal t;
	@EJB
	CompetitionDAOLocal c;
	
    public MatchDAO() {
    }

	@Override
	public void add(DTMatch dtMatch) {
		// con id null
		Match match = new Match(dtMatch);
		em.persist(match);
	}

	@Override
	public void merge(DTMatch dtMatch) {
		Match match = new Match(dtMatch);
		em.merge(match);
	}

	@Override
	public void delete(DTMatch dtMatch) {
		Match match = new Match(dtMatch);
		em.remove(em.merge(match));
	}
	
	@Override
	public DTMatch find(Integer id) {
		Match match = em.find(Match.class, id);
		return match.getDTMatch();
	}
	
	@Override
	public List<DTMatch> findAll() {
		List<Match> Listmatch = em.createQuery("SELECT t FROM Match t", Match.class).getResultList();
		List<DTMatch> ListDT = new ArrayList<DTMatch>();
		for(Match t : Listmatch){
			ListDT.add(t.getDTMatch());
		}
		return ListDT; 
	}

}
