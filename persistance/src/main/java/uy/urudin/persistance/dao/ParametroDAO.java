package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTParametro;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;
import uy.urudin.persistance.model.Parametro;


@Stateful
public class ParametroDAO implements ParametroDAOLocal {

	//@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	//Properties properties = new Properties(); 


	
    public ParametroDAO() {
    	//properties.put("hibernate.default_schema", "public"); 
    	//em.setJpaProperties(properties); 
    }

	@Override
	public void add(DTParametro dtParameter) {
		// con id null
		Parametro Parameter = new Parametro(dtParameter);
		em.persist(Parameter);
	}

	@Override
	public void merge(DTParametro dtParameter) {
		Parametro Parameter = new Parametro(dtParameter);
		em.merge(Parameter);
	}

	@Override
	public void delete(DTParametro dtParameter) {
		Parametro Parameter = new Parametro(dtParameter);
		em.remove(em.merge(Parameter));
	}
	
	@Override
	public DTParametro find(Integer id) {
		Parametro Parameter = em.find(Parametro.class, id);
		return Parameter.getDTParametro();
	}
	
	@Override
	public List<DTParametro> findAll() {
		List<Parametro> ListParameter = em.createQuery("SELECT p FROM Parametro p", Parametro.class).getResultList();
		List<DTParametro> ListDT = new ArrayList<DTParametro>();
		for(Parametro t : ListParameter){
			ListDT.add(t.getDTParametro());
		}
		return ListDT; 
	}

	@Override
	public String getValueByName(String n) {
		Query query = em.createQuery("SELECT p.valor FROM Parametro p where p.nombre = :codigo ");
        query.setParameter("codigo", n);
        String s;
        try {
        	 s = (String) query.getSingleResult();
		} catch (Exception e) {
			s = "";
		}
		return s;
	}

	@Override
	public DTParametro getDTParameterByName(String n) {
		Query query = em.createQuery("SELECT p FROM Parametro p where p.nombre = :codigo ");
        query.setParameter("codigo", n);
        Parametro s;
        try {
        	 s = (Parametro) query.getSingleResult();
		} catch (Exception e) {
			s = null;
		}
		return s.getDTParametro();
	}

}
