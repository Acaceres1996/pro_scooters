package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import uy.pencas.core.datatypes.datatypes.DTService;
import uy.pencas.core.persistance.interfaces.ServiceDAOLocal;
import uy.pencas.core.persistance.model.Service;



@Stateful
public class ServiceDAO implements ServiceDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public ServiceDAO() {
    }

	@Override
	public void add(DTService dtService) {
		//con id null
		Service service = new Service(dtService);
		em.persist(service);
	}

	@Override
	public void merge(DTService dtService) {
		Service service = new Service(dtService);
		em.merge(service);
	}

	@Override
	public void delete(DTService dtService) {
		Service service = new Service(dtService);
		em.remove(em.merge(service));
	}
	
	@Override
	public DTService find(Integer id) {
		Service service = em.find(Service.class, id);
		return service.getDTService();
	}
	
	@Override
	public List<DTService> findAll() {
		List<Service> ListComp = em.createQuery("SELECT c FROM Service c", Service.class).getResultList();
		List<DTService> ListDT = new ArrayList<DTService>();
		for(Service t : ListComp){
			ListDT.add(t.getDTService());
		}
		return ListDT; 
	}

}
