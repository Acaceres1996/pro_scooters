package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTScooter;

@Local
public interface ScooterFacadeLocal {
	DTScooter add(DTScooter dtscooter);
	void update(DTScooter dtscooter);
	void delete(DTScooter dtscooter);
	DTScooter find(Integer id);
	List<DTScooter> findAll();
}
