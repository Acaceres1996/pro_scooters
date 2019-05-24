package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTNotificacion;




@Local
public interface NotificacionDAOLocal {
	public DTNotificacion add(DTNotificacion dtNotificacion);
	public List<DTNotificacion> findAll();
}
