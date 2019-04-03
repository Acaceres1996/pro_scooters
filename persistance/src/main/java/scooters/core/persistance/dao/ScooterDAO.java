package scooters.core.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import scooters.core.datatypes.DTScooter;
import scooters.core.persistance.interfaces.ScooterDAOLocal;
import scooters.core.persistance.model.Scooter;

@Stateful
public class ScooterDAO implements ScooterDAOLocal{
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public ScooterDAO() {
    }
    
    public void add(DTScooter scooter) {
		Scooter s = new Scooter(scooter);
		em.persist(s);
	}

	public void merge(DTScooter scooter) {		
		Scooter s = new Scooter(scooter);
		em.merge(s);
	}

	public void delete(DTScooter scooter) {		
		Scooter s = new Scooter(scooter);
		em.remove(em.merge(s));
	}
	
	public DTScooter find(Integer id) {				
		Scooter s = em.find(Scooter.class, id);
		return s.toDataType();
	}
	
	public List<DTScooter> findAll() {		
		List<Scooter> ScooterList = em.createQuery("SELECT t FROM Scooter t", Scooter.class).getResultList();
		List<DTScooter> ListDT = new ArrayList<DTScooter>();
		for(Scooter t : ScooterList){
			ListDT.add(t.toDataType());
		}
		return ListDT; 
	}
}
