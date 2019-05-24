package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTNotificacion;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.persistance.interfaces.NotificacionDAOLocal;
import uy.urudin.persistance.model.Notificacion;
import uy.urudin.persistance.model.Parametro;
import uy.urudin.persistance.model.Scooter;


@Stateful
public class NotificacionDAO implements NotificacionDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public NotificacionDAO() {
    }

    @Override
	public DTNotificacion add(DTNotificacion dtNotificacion) {
		// con id null
		Notificacion Notificacion = new Notificacion(dtNotificacion);
		Notificacion.setEstado("Enviado");
		Notificacion.setMasiva(true);
		em.persist(Notificacion);
		return Notificacion.getDTNotificacion();
	}
    
    
	@Override
	public List<DTNotificacion> findAll() {
		List<Notificacion> ListNotificacion = em.createQuery("SELECT p FROM Notificacion p", Notificacion.class).getResultList();
		List<DTNotificacion> ListDT = new ArrayList<DTNotificacion>();
		for(Notificacion t : ListNotificacion){
			ListDT.add(t.getDTNotificacion());
		}
		return ListDT; 
	}

}
