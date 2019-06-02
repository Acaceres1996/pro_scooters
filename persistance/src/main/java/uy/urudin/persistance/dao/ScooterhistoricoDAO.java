package uy.urudin.persistance.dao;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTParametro;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.persistance.interfaces.AdminDAOLocal;
import uy.urudin.persistance.interfaces.ScooterhistoricoDAOLocal;
import uy.urudin.persistance.model.Admin;
import uy.urudin.persistance.model.Parametro;
import uy.urudin.persistance.model.Scooter;
import uy.urudin.persistance.model.Scooterhistorico;


@Stateful
public class ScooterhistoricoDAO implements ScooterhistoricoDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	
    public ScooterhistoricoDAO() {
    	
    }
    
	@Override
	public DTScooterhistorico find(Integer id) {
		Scooterhistorico scooterhistorico = em.find(Scooterhistorico.class, id);
		return scooterhistorico.getDTScooterhistorico();
	}
	
	@Override
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooter(Integer idscooter) {
		//System.out.println("DEBUGDEBUGDEBUG:" +"idscooter" + idscooter + ";");
		
		Query query = em.createNativeQuery("SELECT p.* FROM urudin.scooterhistorico p where p.idscooter = :idscooter ORDER BY p.fecha DESC", Scooterhistorico.class);
        query.setParameter("idscooter", idscooter);
//        query.setParameter("user", iduser);
        Scooterhistorico s = null;
        DTScooterhistorico dTCompetitor = null;
        try {
        	 //s = (Scooterhistorico) query.getSingleResult();
        	s = (Scooterhistorico) query.getResultList().get(0);
        	 dTCompetitor = s.getDTScooterhistorico();
		} catch (Exception e) {
			System.out.println(e.toString());
			s = null;
			dTCompetitor = null;
		}
		return dTCompetitor;
	}

	@Override
	public DTScooterhistorico add(DTScooterhistorico dtscooterhistorico) {
		Scooterhistorico scooterhistorico = new Scooterhistorico(dtscooterhistorico);
		//fecha ahora.
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		scooterhistorico.setFecha(timestamp);
		
		em.persist(scooterhistorico);
		return scooterhistorico.getDTScooterhistorico();
	}

	@Override
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooterBasico(Integer idscooter) {
		//salvo basico mismo que ultimoScooterHistoricoUnIdScooter
		Query query = em.createNativeQuery("SELECT p.* FROM urudin.scooterhistorico p where p.idscooter = :idscooter ORDER BY p.fecha DESC", Scooterhistorico.class);
        query.setParameter("idscooter", idscooter);
//        query.setParameter("user", iduser);
        Scooterhistorico s = null;
        DTScooterhistorico dTCompetitor = null;
        try {
        	 //s = (Scooterhistorico) query.getSingleResult();
        	s = (Scooterhistorico) query.getResultList().get(0);
        	 dTCompetitor = s.getDTScooterhistoricoBasico(); //basico porque no quiero nuevamente los DT SCOOTER.
		} catch (Exception e) {
			System.out.println(e.toString());
			s = null;
			dTCompetitor = null;
		}
		return dTCompetitor;
	}
}
