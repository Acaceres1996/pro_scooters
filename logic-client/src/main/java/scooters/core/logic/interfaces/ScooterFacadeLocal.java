package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;
import scooters.core.datatypes.DTScooter;

@Local
public interface ScooterFacadeLocal {
	void add(DTScooter scooter);

	void merge(DTScooter scooter);

	void delete(DTScooter scooter);

	DTScooter find(Integer id);

	List<DTScooter> findAll();
}
