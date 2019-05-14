package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.model.Cliente;


@Stateful
public class ClienteDAO implements ClienteDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public ClienteDAO() {
    }

	@Override
	public void add(DTCliente DTCliente) {
		// con id null
		Cliente Cliente = new Cliente(DTCliente);
		em.persist(Cliente);
	}

	@Override
	public void merge(DTCliente DTCliente) {
		Cliente Cliente = new Cliente(DTCliente);
		em.merge(Cliente);
	}

	@Override
	public void delete(DTCliente DTCliente) {
		Cliente Cliente = new Cliente(DTCliente);
		em.remove(em.merge(Cliente));
	}

	@Override
	public DTCliente find(Integer id) {
		Cliente Cliente = em.find(Cliente.class, id);
		return Cliente.getDTCliente();
	}

	@Override
	public List<DTCliente> findAll() {
		List<Cliente> ListCliente = em.createQuery("SELECT a FROM Cliente a", Cliente.class).getResultList();
		List<DTCliente> ListDT = new ArrayList<DTCliente>();
		for(Cliente t : ListCliente){
			ListDT.add(t.getDTCliente());
		}
		return ListDT; 
	}
}
