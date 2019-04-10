package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.urudin.datatypes.datatypes.DTParametro;
import uy.urudin.datatypes.datatypes.DTScooter;

@Remote
public interface ScooterFacadeRemote {
	void add(DTScooter dtscooter);
	void update(DTScooter dtscooter);
	void delete(DTScooter dtscooter);
	DTScooter find(Integer id);
	List<DTScooter> findAll();
}
