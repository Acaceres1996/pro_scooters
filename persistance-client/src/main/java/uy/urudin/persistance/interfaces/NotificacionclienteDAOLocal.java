package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTNotificacion;
import uy.urudin.datatypes.DTNotificacioncliente;




@Local
public interface NotificacionclienteDAOLocal {
	public DTNotificacioncliente add(DTNotificacioncliente dtNotificacioncliente);
	public DTNotificacioncliente marcarLeidaNotificacionCliente(Integer idnotificacioncliente);
	public List<DTNotificacioncliente> obtenerTodaslasNotificacionesNoleidasdeCliente(Integer idcliente);
	public DTNotificacioncliente obtenerUnaNotificacionCliente(Integer idnotificacion, Integer idcliente);
}
