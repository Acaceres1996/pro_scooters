package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.persistance.interfaces.MonederohistoricoDAOLocal;
import uy.urudin.persistance.model.Monederohistorico;



@Stateful
public class MonederoHistoricoDAO implements MonederohistoricoDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public MonederoHistoricoDAO() {
    }
	


	@Override
	public DTMonederohistorico add(DTMonederohistorico dtMonederohistorico) {
		// con id null
		System.out.println("LLEGUE ADD MONEDEROHISTORICO");
		Monederohistorico monederohistorico = new Monederohistorico(dtMonederohistorico);
		em.persist(monederohistorico);
		return monederohistorico.getDTMonederohistorico();
	}

	@Override
	public DTMonederohistorico find(Integer id) {
		System.out.println("LLEGUE FIND MONEDEROHISTORICO");
		Monederohistorico monederohistorico = em.find(Monederohistorico.class, id);
		return monederohistorico .getDTMonederohistorico();
	}

	@Override
	public List<DTMonederohistorico> findAll() {
		System.out.println("LLEGUE FINDADLL MONEDEROHISTORICO");
		List<Monederohistorico> ListMonederohistorico = em.createQuery("SELECT a FROM Monederohistorico a ", Monederohistorico.class).getResultList();
		List<DTMonederohistorico> ListDT = new ArrayList<DTMonederohistorico>();
		for(Monederohistorico t : ListMonederohistorico){
			System.out.println("ACA");
			ListDT.add(t.getDTMonederohistorico());
		}
		return ListDT; 
	}
}
