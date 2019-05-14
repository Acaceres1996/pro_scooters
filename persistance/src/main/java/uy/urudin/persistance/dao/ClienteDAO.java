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
	public DTCliente add(DTCliente dtcliente) {
		// con id null
		Cliente cliente = new Cliente(dtcliente);
//System.out.println("DEBUGDEBUGDEBUG:" + cuantosemails(dtcliente.getEmail()) + ";");
		//existe el email ingresado.
		if(cuantosemails(dtcliente.getEmail()) <= 0 ) {
			//saldo siempre comienza en 0 al crear.
			cliente.setSaldo(0);
			em.persist(cliente);
			return cliente.getDTCliente();
		}else {
			return null;
		}
	}
    
	private int cuantosemails(String email) {
		Query query = em.createQuery("SELECT count(*) FROM Cliente p where p.email = :email ");
        query.setParameter("email", email);
        int i = 9;
        try {
        	i = ((Number) query.getSingleResult()).intValue();;
		} catch (Exception e) {
			i = 8;
		}
		return i;
	}

	@Override
	public DTCliente merge(DTCliente dtcliente) {
		Cliente cliente = new Cliente(dtcliente);
		// puede existir 0 o 1 vez pero no mas.
		if(cuantosemails(dtcliente.getEmail()) <= 1 ) {
			em.merge(cliente);
			return cliente.getDTCliente();
		}else {
			return null;
		}
	}

//	@Override
//	public void delete(DTCliente dtcliente) {
//		Cliente cliente = new Cliente(dtcliente);
//		em.remove(em.merge(cliente));
//	}
	
	@Override
	public DTCliente find(Integer id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente.getDTCliente();
	}
	
	
	@Override
	public DTCliente find(String email) {
		Query query = em.createQuery("SELECT p FROM Cliente p where p.email = :email ");
        query.setParameter("email", email);
        Cliente s;
        try {
        	 s = (Cliente) query.getSingleResult();
		} catch (Exception e) {
			s = null;
//			System.out.println("DEBUGDEBUGDEBUG:" + "cach" + ";");
		}
        
//        System.out.println("DEBUGDEBUGDEBUG:" + s.getApellido() + ";");
		return s.getDTCliente();
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
