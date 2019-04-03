package scooters.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import scooters.core.datatypes.*;

@Local
public interface ScooterDAOLocal {
	void add(DTScooter scooter);
	void merge(DTScooter scooter);
	void delete(DTScooter scooter);
	DTScooter find(Integer id);
	List<DTScooter> findAll();
}
