package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTResumenViaje;
import uy.urudin.datatypes.DTViaje;

@Local
public interface ViajeFacadeLocal {
	DTViaje add(DTViaje dtviaje);
	DTViaje update(DTViaje dtviaje);
	DTViaje find(Integer id);
	List<DTViaje> findAll();
	DTViaje iniciarViaje(DTViaje v);
	DTResumenViaje finalizarViaje(DTViaje v);
}
