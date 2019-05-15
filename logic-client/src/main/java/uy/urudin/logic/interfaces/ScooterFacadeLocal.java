package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTScooter;

@Local
public interface ScooterFacadeLocal {
	DTScooter add(DTScooter dtscooter);
	DTScooter update(DTScooter dtscooter);
	void delete(Integer id);
	DTScooter find(Integer id);
	List<DTScooter> findAll();
	public List<DTScooter> scootersLibres();
}
