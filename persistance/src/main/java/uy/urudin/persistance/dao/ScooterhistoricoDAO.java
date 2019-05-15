package uy.urudin.persistance.dao;


import java.util.ArrayList;
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


//	@Override
//	public List<DTScooterhistorico> todoslosScootersHistoricoDisponibles() {
//		// se considera disponible
//		//Solo se mostraran Scooters encendidos, que no se encuentren en uso y con batería mayor al mínimo definido por el sistema. 
//		
//		//inicializo vacio
//		List<DTScooterhistorico> ret = new ArrayList<DTScooterhistorico>();
//		
//		//parametro sistema a numero
//		String minbat = ParametroEJB.getValueByName("BATERIABAJA");
//		Integer minimobat = Integer.valueOf(minbat);
//System.out.println("DEBUGDEBUGDEBUG:" + minimobat + ";");
//
//		//listar cuales son los scooter que cumplen con ello
//		List<DTScooter> libres = ScooterEJB.scootersLibres();
//System.out.println("DEBUGDEBUGDEBUG:" +"zize" + libres.size()  + ";");
//		
//		//pedir ultima ubicacion de esos scooters
//		for (DTScooter onescooter : libres) {
//			
//			//ultimo historico de uno libre.
//			DTScooterhistorico oneSH = ultimoScooterHistoricoUnIdScooter(onescooter.getId());
//			
//			//solo incluyo quienes bateria > al minimo.
//			if(oneSH.getBateria() > minimobat) {
//				ret.add(oneSH);
//			}
//		}
//		return ret;
//	}

    
	@Override
	public DTScooterhistorico find(Integer id) {
		Scooterhistorico scooterhistorico = em.find(Scooterhistorico.class, id);
		return scooterhistorico.getDTScooterhistorico();
	}
	
	@Override
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooter(Integer idscooter) {
		System.out.println("DEBUGDEBUGDEBUG:" +"idscooter" + idscooter + ";");
		
		Query query = em.createNativeQuery("SELECT p.* FROM public.scooterhistorico p where p.idscooter = :idscooter ORDER BY p.fecha DESC", Scooterhistorico.class);
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
}
