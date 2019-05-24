package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTViaje;




@Local
public interface ViajeDAOLocal {
	DTViaje add(DTViaje dtviaje);
	DTViaje merge(DTViaje dtviaje);
	DTViaje find(Integer id);
	List<DTViaje> findAll();
	List<DTViaje> findByUser(int id);
}
