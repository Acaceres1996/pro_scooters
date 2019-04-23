package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.urudin.datatypes.datatypes.DTCliente;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.model.Cliente;


@Stateful
public class ClienteDAO implements ClienteDAOLocal {

	//@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	//Properties properties = new Properties(); 


	
    public ClienteDAO() {
    	//properties.put("hibernate.default_schema", "public"); 
    	//em.setJpaProperties(properties); 
    }

	@Override
	public void add(DTCliente dtcliente) {
		// con id null
		Cliente cliente = new Cliente(dtcliente);
		em.persist(cliente);
	}

	@Override
	public void merge(DTCliente dtcliente) {
		Cliente cliente = new Cliente(dtcliente);
		em.merge(cliente);
	}

	@Override
	public void delete(DTCliente dtcliente) {
		Cliente cliente = new Cliente(dtcliente);
		em.remove(em.merge(cliente));
	}
	
	@Override
	public DTCliente find(Integer id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente.getDTCliente();
	}
	
	@Override
	public List<DTCliente> findAll() {
		List<Cliente> Listcliente = em.createQuery("SELECT p FROM Cliente p", Cliente.class).getResultList();
		List<DTCliente> ListDT = new ArrayList<DTCliente>();
		for(Cliente t : Listcliente){
			ListDT.add(t.getDTCliente());
		}
		return ListDT; 
	}

}
