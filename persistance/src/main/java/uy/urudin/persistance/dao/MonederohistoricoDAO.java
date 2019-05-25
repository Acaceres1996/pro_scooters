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
public class MonederohistoricoDAO implements MonederohistoricoDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public MonederohistoricoDAO() {
    }

    @Override
	public DTMonederohistorico add(DTMonederohistorico dtMonederohistorico) {
		// con id null
		Monederohistorico Monederohistorico = new Monederohistorico(dtMonederohistorico);
		em.persist(Monederohistorico);
		return Monederohistorico.getDTMonederohistorico();
	}
    
	@Override
	public void delete(Integer Id) {
		DTMonederohistorico dtMonederohistorico = find(Id);
		Monederohistorico Monederohistorico = new Monederohistorico(dtMonederohistorico);
		em.remove(em.merge(Monederohistorico));
	} 
	
	public DTMonederohistorico find(Integer id) {
		Monederohistorico Monederohistorico = em.find(Monederohistorico.class, id);
		return Monederohistorico.getDTMonederohistorico();
	}
	
	@Override
	public List<DTMonederohistorico> findAll() {
		List<Monederohistorico> ListMonederohistorico = em.createQuery("SELECT p FROM Monederohistorico p", Monederohistorico.class).getResultList();
		List<DTMonederohistorico> ListDT = new ArrayList<DTMonederohistorico>();
		for(Monederohistorico t : ListMonederohistorico){
			ListDT.add(t.getDTMonederohistorico());
		}
		return ListDT; 
	}

	@Override
	public List<DTMonederohistorico> findPagos() {
		List<Monederohistorico> pagos = em.createQuery("SELECT p FROM Monederohistorico p WHERE p.motivo = 'Paypal'", Monederohistorico.class).getResultList();
		List<DTMonederohistorico> ListDT = new ArrayList<DTMonederohistorico>();
		for(Monederohistorico t : pagos){
			ListDT.add(t.getDTMonederohistorico());
		}
		return ListDT; 
	}

	@Override
	public List<DTMonederohistorico> findPagosUsuario(Integer id) {
		List<Monederohistorico> pagos = em.createQuery("SELECT p FROM Monederohistorico p WHERE p.motivo = 'Paypal' AND p.cliente = " + id, Monederohistorico.class).getResultList();
		List<DTMonederohistorico> ListDT = new ArrayList<DTMonederohistorico>();
		for(Monederohistorico t : pagos){
			ListDT.add(t.getDTMonederohistorico());
		}
		return ListDT;
	}

}
