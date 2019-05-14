package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTScooter;




@Local
public interface ScooterDAOLocal {
	DTScooter add(DTScooter dtscooter);
	DTScooter merge(DTScooter dtscooter);
	void delete(Integer Id);
	DTScooter find(Integer id);
	List<DTScooter> findAll();
}
