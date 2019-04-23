package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.urudin.datatypes.datatypes.DTRegistro;
import uy.urudin.persistance.interfaces.RegistroDAOLocal;
import uy.urudin.persistance.model.Registro;


@Stateful
public class RegistroDAO implements RegistroDAOLocal {

	//@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	//Properties properties = new Properties(); 


	
    public RegistroDAO() {
    	//properties.put("hibernate.default_schema", "public"); 
    	//em.setJpaProperties(properties); 
    }

	@Override
	public void add(DTRegistro dtregistro) {
		// con id null
		Registro registro = new Registro(dtregistro);
		em.persist(registro);
	}

	@Override
	public void merge(DTRegistro dtregistro) {
		Registro registro = new Registro(dtregistro);
		em.merge(registro);
	}

	@Override
	public void delete(DTRegistro dtregistro) {
		Registro registro = new Registro(dtregistro);
		em.remove(em.merge(registro));
	}
	
	@Override
	public DTRegistro find(Integer id) {
		Registro registro = em.find(Registro.class, id);
		return registro.getDTRegistro();
	}
	
	@Override
	public List<DTRegistro> findAll() {
		List<Registro> Listregistro = em.createQuery("SELECT p FROM Registro p", Registro.class).getResultList();
		List<DTRegistro> ListDT = new ArrayList<DTRegistro>();
		for(Registro t : Listregistro){
			ListDT.add(t.getDTRegistro());
		}
		return ListDT; 
	}

}
