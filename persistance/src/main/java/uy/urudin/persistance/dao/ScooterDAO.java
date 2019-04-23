package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.urudin.datatypes.datatypes.DTScooter;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.model.Scooter;


@Stateful
public class ScooterDAO implements ScooterDAOLocal {

	//@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	//Properties properties = new Properties(); 


	
    public ScooterDAO() {
    	//properties.put("hibernate.default_schema", "public"); 
    	//em.setJpaProperties(properties); 
    }

	@Override
	public void add(DTScooter dtscooter) {
		// con id null
		Scooter scooter = new Scooter(dtscooter);
		em.persist(scooter);
	}

	@Override
	public void merge(DTScooter dtscooter) {
		Scooter scooter = new Scooter(dtscooter);
		em.merge(scooter);
	}

	@Override
	public void delete(DTScooter dtscooter) {
		Scooter scooter = new Scooter(dtscooter);
		scooter.setEncendido(false); // lo apage en lugar de eliminarlo.
		//em.remove(em.merge(scooter));
		em.merge(scooter);
	}
	
	@Override
	public DTScooter find(Integer id) {
		Scooter scooter = em.find(Scooter.class, id);
		return scooter.getDTScooter();
	}
	
	@Override
	public List<DTScooter> findAll() {
		List<Scooter> Listscooter = em.createQuery("SELECT p FROM Scooter p", Scooter.class).getResultList();
		List<DTScooter> ListDT = new ArrayList<DTScooter>();
		for(Scooter t : Listscooter){
			ListDT.add(t.getDTScooter());
		}
		return ListDT; 
	}

}
