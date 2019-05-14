package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.model.Scooter;


@Stateful
public class ScooterDAO implements ScooterDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public ScooterDAO() {
    }

	@Override
	public void add(DTScooter dtScooter) {
		// con id null
		Scooter scooter = new Scooter(dtScooter);
		//datos por default
		scooter.setEncendido(true);
		scooter.setEnuso(false);
		scooter.setEliminado(false);
		em.persist(scooter);
	}

	@Override
	public void merge(DTScooter dtScooter) {
		Scooter Scooter = new Scooter(dtScooter);
		em.merge(Scooter);
	}

	@Override
	public void delete(DTScooter dtScooter) {
		Scooter Scooter = new Scooter(dtScooter);
		em.remove(em.merge(Scooter));
	}

	@Override
	public DTScooter find(Integer id) {
		Scooter Scooter = em.find(Scooter.class, id);
		return Scooter.getDTScooter();
	}

	@Override
	public List<DTScooter> findAll() {
		List<Scooter> ListScooter = em.createQuery("SELECT a FROM Scooter a", Scooter.class).getResultList();
		List<DTScooter> ListDT = new ArrayList<DTScooter>();
		for(Scooter t : ListScooter){
			ListDT.add(t.getDTScooter());
		}
		return ListDT; 
	}
}
