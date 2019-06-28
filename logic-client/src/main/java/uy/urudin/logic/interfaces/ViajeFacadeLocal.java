package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTResumenViaje;
import uy.urudin.datatypes.DTViaje;
import uy.urudin.datatypes.DTViajePagoDetallado;

@Local
public interface ViajeFacadeLocal {
	DTViaje add(DTViaje dtviaje);
	DTViaje update(DTViaje dtviaje);
	DTViaje find(Integer id);
	List<DTViajePagoDetallado> findAll();
	DTViaje iniciarViaje(DTViaje v) throws Exception;
	DTResumenViaje finalizarViaje(DTViaje v) throws Exception;
	int duracionViaje(DTViaje v);
	List<DTViajePagoDetallado> findByUser(int id);
	DTViaje buscarIniciadoPorScooter(int idScooter);
}
