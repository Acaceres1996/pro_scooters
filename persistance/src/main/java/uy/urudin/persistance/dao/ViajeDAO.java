package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.urudin.datatypes.DTViaje;
import uy.urudin.persistance.interfaces.ViajeDAOLocal;
import uy.urudin.persistance.model.Cliente;
import uy.urudin.persistance.model.Scooter;
import uy.urudin.persistance.model.Viaje;


@Stateful
public class ViajeDAO implements ViajeDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public ViajeDAO() {
    }

	@Override
	public DTViaje add(DTViaje DTViaje) {
		// con id null
		Viaje Viaje = new Viaje(DTViaje);
		//datos por default
		Viaje.setFechainicio(DTViaje.getFechainicio());
		Viaje.setEstado(DTViaje.getEstado());
		Viaje.setMinutospermitidossaldo(DTViaje.getMinutospermitidossaldo());
		Cliente c = em.find(Cliente.class, DTViaje.getCliente().getId());
		Scooter s = em.find(Scooter.class, DTViaje.getScooter().getId());
		Viaje.setCliente(c);
		Viaje.setScooter(s);
		em.persist(Viaje);
		return Viaje.getDTViaje();
	}

	@Override
	public DTViaje merge(DTViaje DTViaje) {
		Viaje Viaje = new Viaje(DTViaje);
		em.merge(Viaje);
		return Viaje.getDTViaje();
	}

	@Override
	public DTViaje find(Integer id) {
		Viaje Viaje = em.find(Viaje.class, id);
		return Viaje.getDTViaje();
	}

	@Override
	public List<DTViaje> findAll() {
		List<Viaje> ListViaje = em.createQuery("SELECT a FROM Viaje a ", Viaje.class).getResultList();
		List<DTViaje> ListDT = new ArrayList<DTViaje>();
		for(Viaje t : ListViaje){
			ListDT.add(t.getDTViaje());
		}
		return ListDT; 
	}
	
	@Override
	public List<DTViaje> findByUser(int idUser) {
		List<Viaje> ListViaje = em.createQuery("SELECT a FROM Viaje a WHERE cliente = " + idUser, Viaje.class).getResultList();
		List<DTViaje> ListDT = new ArrayList<DTViaje>();
		for(Viaje t : ListViaje){
			ListDT.add(t.getDTViaje());
		}
		return ListDT; 
	}

	@Override
	public DTViaje buscarIniciadoPorScooter(int idScooter) {
		try {
			Viaje viaje = em.createQuery("SELECT a FROM Viaje a WHERE a.estado = 'Iniciado' and scooter = " + idScooter, Viaje.class).getSingleResult();
			return viaje.getDTViaje(); 
		} catch (Exception e) {
			return null;
		}
	}
	
}
