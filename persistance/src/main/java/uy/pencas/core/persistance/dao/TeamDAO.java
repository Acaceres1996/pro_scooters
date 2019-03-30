package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.persistance.interfaces.TeamDAOLocal;
import uy.pencas.core.persistance.model.Team;


@Stateful
public class TeamDAO implements TeamDAOLocal {

	//@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public TeamDAO() {
    }

	@Override
	public void add(DTTeam dtTeam) {
		//con id null
		Team team = new Team(dtTeam);
		em.persist(team);
	}

	@Override
	public void merge(DTTeam dtTeam) {
		Team team = new Team(dtTeam);
		em.merge(team);
	}

	@Override
	public void delete(DTTeam dtTeam) {
		Team team = new Team(dtTeam);
		em.remove(em.merge(team));
	}
	
	@Override
	public DTTeam find(Integer id) {
		Team team = em.find(Team.class, id);
		return team.getDTTeam();
	}
	
	@Override
	public List<DTTeam> findAll() {
		List<Team> Listteam = em.createQuery("SELECT t FROM Team t", Team.class).getResultList();
		List<DTTeam> ListDT = new ArrayList<DTTeam>();
		for(Team t : Listteam){
			ListDT.add(t.getDTTeam());
		}
		return ListDT; 
	}

}
