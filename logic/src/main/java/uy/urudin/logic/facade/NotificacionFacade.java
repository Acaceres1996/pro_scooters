package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTNotificacion;
import uy.urudin.datatypes.DTNotificacioncliente;
import uy.urudin.logic.interfaces.NotificacionFacadeLocal;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.interfaces.NotificacionDAOLocal;
import uy.urudin.persistance.interfaces.NotificacionclienteDAOLocal;




/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class NotificacionFacade implements  NotificacionFacadeLocal {


	@EJB
	NotificacionDAOLocal NotificacionDAO;
	@EJB
	ClienteDAOLocal ClienteDAO;
	@EJB
	NotificacionclienteDAOLocal NotificacionclienteDAO;
	@EJB
	PushNotificationFacade PushNotification;
	
    /**
     * Default constructor. 
     */
    public NotificacionFacade() {
        
    }

    @Override
	public DTNotificacion add(DTNotificacion dtNotificacion) {
    	//creo la notificacion
    	DTNotificacion ret = NotificacionDAO.add(dtNotificacion);
    	
    	//envio de push notification. masivo
    	PushNotification.sendPushNotification(dtNotificacion.getCabezal(), dtNotificacion.getCuerpo());
    	
    	
    	//se la asocio a todos los clientes como no leida
    	List<DTCliente> todoslosclientes = ClienteDAO.findAll();
    	for (DTCliente onedtCliente : todoslosclientes) {
    		DTNotificacioncliente nueva = new DTNotificacioncliente();
    		nueva.setLeido(false);
    		nueva.setNotificacion(ret);
    		nueva.setCliente(onedtCliente);
    		NotificacionclienteDAO.add(nueva);
		}
		return ret;
	}


	@Override
	public List<DTNotificacion> obtenerNotificacionesEnviadas() {
		return NotificacionDAO.findAll();
	}

	
	@Override
	public DTNotificacioncliente marcarLeidaNotificacion(Integer idnotificacion, Integer idcliente) {
		DTNotificacioncliente notificacioncliente = NotificacionclienteDAO.obtenerUnaNotificacionCliente( idnotificacion,  idcliente);
		DTNotificacioncliente leida = NotificacionclienteDAO.marcarLeidaNotificacionCliente(notificacioncliente.getId());
		return leida;
	}

	@Override
	public List<DTNotificacion> obtenerTodaslasNotificacionesNoleidasdeCliente(Integer idcliente) {
		List<DTNotificacioncliente> noleidascliente = NotificacionclienteDAO.obtenerTodaslasNotificacionesNoleidasdeCliente(idcliente);
		List<DTNotificacion> Notificacionesnoleidascliente = new ArrayList<DTNotificacion>();
		for (DTNotificacioncliente oneDTNotificacioncliente : noleidascliente) {
			Notificacionesnoleidascliente.add(oneDTNotificacioncliente.getNotificacion());
		}
		return Notificacionesnoleidascliente;
	}



}
