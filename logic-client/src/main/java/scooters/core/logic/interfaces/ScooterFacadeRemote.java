package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;
import scooters.core.datatypes.DTScooter;

@Remote
public interface ScooterFacadeRemote {
	void add(DTScooter scooter);

	void merge(DTScooter scooter);

	void delete(DTScooter scooter);

	DTScooter find(Integer id);

	List<DTScooter> findAll();
}
