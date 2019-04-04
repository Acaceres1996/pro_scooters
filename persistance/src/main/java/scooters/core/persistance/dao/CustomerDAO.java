package scooters.core.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import scooters.core.datatypes.DTCustomer;
import scooters.core.persistance.interfaces.CustomerDAOLocal;
import scooters.core.persistance.model.Customer;

@Stateful
public class CustomerDAO implements CustomerDAOLocal{
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public CustomerDAO() {
    }
    
    public void add(DTCustomer customer) {
		Customer s = new Customer(customer);
		em.persist(s);
	}

	public void merge(DTCustomer customer) {		
		Customer s = new Customer(customer);
		em.merge(s);
	}

	public void delete(DTCustomer customer) {		
		Customer s = new Customer(customer);
		em.remove(em.merge(s));
	}
	
	public DTCustomer find(Integer id) {				
		Customer s = em.find(Customer.class, id);
		return s.toDataType();
	}
	
	public List<DTCustomer> findAll() {		
		List<Customer> CustomerList = em.createQuery("SELECT t FROM Customer t", Customer.class).getResultList();
		List<DTCustomer> ListDT = new ArrayList<DTCustomer>();
		for(Customer t : CustomerList){
			ListDT.add(t.toDataType());
		}
		return ListDT; 
	}
}
