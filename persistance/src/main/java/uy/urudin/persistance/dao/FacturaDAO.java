package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTFactura;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.persistance.interfaces.FacturaDAOLocal;
import uy.urudin.persistance.model.Factura;
import uy.urudin.persistance.model.Parametro;
import uy.urudin.persistance.model.Scooter;


@Stateful
public class FacturaDAO implements FacturaDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public FacturaDAO() {
    }

    @Override
	public DTFactura add(DTFactura DTFactura) {
		// con id null
		Factura Factura = new Factura(DTFactura);
		em.persist(Factura);
		return Factura.getDTFactura();
	}
    

	@Override
	public void delete(Integer Id) {
		DTFactura DTFactura = find(Id);
		Factura Factura = new Factura(DTFactura);
		em.remove(em.merge(Factura));
	}
	
	private DTFactura find(Integer id) {
		Factura Factura = em.find(Factura.class, id);
		return Factura.getDTFactura();
	}
	
	@Override
	public List<DTFactura> findAll() {
		List<Factura> ListFactura = em.createQuery("SELECT p FROM Factura p", Factura.class).getResultList();
		List<DTFactura> ListDT = new ArrayList<DTFactura>();
		for(Factura t : ListFactura){
			ListDT.add(t.getDTFactura());
		}
		return ListDT; 
	}

	@Override
	public DTFactura findByViaje(int id) {
		Factura f = em.createQuery("SELECT p FROM Factura p WHERE p.viaje = " + id, Factura.class).getSingleResult();
		return f.getDTFactura();
	} 

}
