package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.model.Scooter;


@Stateful
public class ScooterDAO implements ScooterDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public ScooterDAO() {
    }
	
    @Override
	public List<DTScooter> scootersLibres() {		
		List<Scooter> ListScooter = em.createQuery("SELECT a FROM Scooter a where a.encendido = true and a.enuso = false and a.eliminado = false", Scooter.class).getResultList();
		List<DTScooter> ListDT = new ArrayList<DTScooter>();
		for(Scooter t : ListScooter){
			ListDT.add(t.getDTScooter());
		}
		return ListDT; 
	}
    
    @Override
	public List<DTScooter> scootersEnUso() {

		List<Scooter> ListScooter = em.createQuery("SELECT a FROM Scooter a where a.enuso = true", Scooter.class).getResultList();
		List<DTScooter> ListDT = new ArrayList<DTScooter>();
		for(Scooter t : ListScooter){
			ListDT.add(t.getDTScooter());
		}
		return ListDT; 
	}

    
    @Override
	public List<DTScooter> scootersApagados() {
		List<Scooter> ListScooter = em.createQuery("SELECT a FROM Scooter a where a.encendido = false and a.eliminado = false", Scooter.class).getResultList();
		List<DTScooter> ListDT = new ArrayList<DTScooter>();
		for(Scooter t : ListScooter){
			ListDT.add(t.getDTScooter());
		}
		return ListDT; 
	}

	@Override
	public DTScooter add(DTScooter dtScooter) {
		Scooter scooter = new Scooter(dtScooter);
		scooter.setEncendido(true);
		scooter.setEnuso(false);
		scooter.setEliminado(false);
		em.persist(scooter);
		return scooter.getDTScooter();
	}

	@Override
	public DTScooter merge(DTScooter dtScooter) {
		Scooter Scooter = new Scooter(dtScooter);
		em.merge(Scooter);
		return Scooter.getDTScooter();
	}

	@Override
	public void delete(Integer Id) {
		DTScooter dtScooter = find(Id);
		Scooter Scooter = new Scooter(dtScooter);
		if(!Scooter.getEncendido()) {
			Scooter.setEliminado(true);
			Scooter.setEncendido(false);
			em.merge(Scooter);
		}
	}

	@Override
	public DTScooter find(Integer id) {
		Scooter Scooter = em.find(Scooter.class, id);
		return Scooter.getDTScooter();
	}

	@Override
	public List<DTScooter> findAll() {
		List<Scooter> ListScooter = em.createQuery("SELECT a FROM Scooter a where a.eliminado = false ", Scooter.class).getResultList();
		List<DTScooter> ListDT = new ArrayList<DTScooter>();
		for(Scooter t : ListScooter){
			ListDT.add(t.getDTScooter());
		}
		return ListDT; 
	}
}
