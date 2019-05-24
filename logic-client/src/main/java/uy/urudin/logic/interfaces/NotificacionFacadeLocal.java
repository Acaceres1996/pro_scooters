package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTNotificacion;
import uy.urudin.datatypes.DTNotificacioncliente;

@Local
public interface NotificacionFacadeLocal {
	public DTNotificacion add(DTNotificacion dtNotificacion);
	public List<DTNotificacion> obtenerNotificacionesEnviadas();
	public DTNotificacioncliente marcarLeidaNotificacion(Integer idnotificacion, Integer idcliente);
	public List<DTNotificacion> obtenerTodaslasNotificacionesNoleidasdeCliente(Integer idcliente);
}