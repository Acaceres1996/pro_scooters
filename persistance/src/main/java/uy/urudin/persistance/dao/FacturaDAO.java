package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTFactura;
import uy.urudin.persistance.interfaces.FacturaDAOLocal;
import uy.urudin.persistance.model.Factura;


@Stateful
public class FacturaDAO implements FacturaDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public FacturaDAO() {
    }

	@Override
	public void add(DTFactura DTFactura) {
		// con id null
		Factura Factura = new Factura(DTFactura);
		em.persist(Factura);
	}

	@Override
	public void merge(DTFactura DTFactura) {
		Factura Factura = new Factura(DTFactura);
		em.merge(Factura);
	}

	@Override
	public void delete(DTFactura DTFactura) {
		Factura Factura = new Factura(DTFactura);
		em.remove(em.merge(Factura));
	}

	@Override
	public DTFactura find(Integer id) {
		Factura Factura = em.find(Factura.class, id);
		return Factura.getDTFactura();
	}

	@Override
	public List<DTFactura> findAll() {
		List<Factura> ListFactura = em.createQuery("SELECT a FROM Factura a", Factura.class).getResultList();
		List<DTFactura> ListDT = new ArrayList<DTFactura>();
		for(Factura t : ListFactura){
			ListDT.add(t.getDTFactura());
		}
		return ListDT; 
	}
}
