package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTScooter;




@Local
public interface ScooterDAOLocal {
	DTScooter add(DTScooter dtscooter);
	void merge(DTScooter dtscooter);
	void delete(DTScooter dtscooter);
	DTScooter find(Integer id);
	List<DTScooter> findAll();
}
