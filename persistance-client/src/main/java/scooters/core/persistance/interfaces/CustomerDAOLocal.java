package scooters.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import scooters.core.datatypes.*;

@Local
public interface CustomerDAOLocal {
	void add(DTCustomer customer);
	void merge(DTCustomer customer);
	void delete(DTCustomer customer);
	DTCustomer find(Integer id);
	List<DTCustomer> findAll();
}
