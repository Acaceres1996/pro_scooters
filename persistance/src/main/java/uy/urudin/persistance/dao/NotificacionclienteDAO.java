package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTNotificacioncliente;
import uy.urudin.datatypes.DTParametro;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.persistance.interfaces.NotificacionclienteDAOLocal;
import uy.urudin.persistance.model.Notificacioncliente;
import uy.urudin.persistance.model.Parametro;
import uy.urudin.persistance.model.Scooter;
import uy.urudin.persistance.model.Scooterhistorico;


@Stateful
public class NotificacionclienteDAO implements NotificacionclienteDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public NotificacionclienteDAO() {
    }

    @Override
	public DTNotificacioncliente add(DTNotificacioncliente dtNotificacioncliente) {
		// con id null
		Notificacioncliente Notificacioncliente = new Notificacioncliente(dtNotificacioncliente);
		em.persist(Notificacioncliente);
		return Notificacioncliente.getDTNotificacioncliente();
	}
    
    
    @Override
	public DTNotificacioncliente marcarLeidaNotificacionCliente(Integer idnotificacioncliente) {
		// con id null
    	Notificacioncliente notificacioncliente = em.find(Notificacioncliente.class, idnotificacioncliente);
    	notificacioncliente.setLeido(true);
		em.merge(notificacioncliente);
		return notificacioncliente.getDTNotificacioncliente();
	}
    
    
	@Override
	public List<DTNotificacioncliente> obtenerTodaslasNotificacionesNoleidasdeCliente(Integer idcliente) {
		System.out.println("TEST1");
		Query query = em.createNativeQuery("SELECT p.* FROM public.Notificacioncliente p where p.leido = false and p.idcliente = :cliente ", Notificacioncliente.class);
        query.setParameter("cliente", idcliente);
        List<DTNotificacioncliente> ListdTNotificacioncliente = new ArrayList<DTNotificacioncliente>();
        try {
        	List<Notificacioncliente> all = (List<Notificacioncliente>) query.getResultList();
    		for(Notificacioncliente t : all){
    			ListdTNotificacioncliente.add(t.getDTNotificacioncliente());
    		}
    		return ListdTNotificacioncliente;
		} catch (Exception e) {
			System.out.println(e.toString());
			ListdTNotificacioncliente = null;
			return null;
		}
	}

	@Override
	public DTNotificacioncliente obtenerUnaNotificacionCliente(Integer idnotificacion, Integer idcliente) {
		System.out.println("TEST2");
		Query query = em.createNativeQuery("SELECT p.* FROM public.Notificacioncliente p where p.idcliente = :cliente and p.idnotificacion = :notificacion ", Notificacioncliente.class);
        query.setParameter("cliente", idcliente);
        query.setParameter("notificacion", idnotificacion);
		Notificacioncliente uno = (Notificacioncliente) query.getSingleResult();
		return uno.getDTNotificacioncliente();
	}

}
