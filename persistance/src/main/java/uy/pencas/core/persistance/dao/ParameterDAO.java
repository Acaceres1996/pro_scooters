package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.pencas.core.datatypes.datatypes.DTParameter;
import uy.pencas.core.persistance.interfaces.ParameterDAOLocal;
import uy.pencas.core.persistance.model.Parameter;


@Stateful
public class ParameterDAO implements ParameterDAOLocal {

	//@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public ParameterDAO() {
    }

	@Override
	public void add(DTParameter dtParameter) {
		// con id null
		Parameter Parameter = new Parameter(dtParameter);
		em.persist(Parameter);
	}

	@Override
	public void merge(DTParameter dtParameter) {
		Parameter Parameter = new Parameter(dtParameter);
		em.merge(Parameter);
	}

	@Override
	public void delete(DTParameter dtParameter) {
		Parameter Parameter = new Parameter(dtParameter);
		em.remove(em.merge(Parameter));
	}
	
	@Override
	public DTParameter find(Integer id) {
		Parameter Parameter = em.find(Parameter.class, id);
		return Parameter.getDTParameter();
	}
	
	@Override
	public List<DTParameter> findAll() {
		List<Parameter> ListParameter = em.createQuery("SELECT p FROM Parameter p", Parameter.class).getResultList();
		List<DTParameter> ListDT = new ArrayList<DTParameter>();
		for(Parameter t : ListParameter){
			ListDT.add(t.getDTParameter());
		}
		return ListDT; 
	}

	@Override
	public String getValueByName(String n) {
		
		Query query = em.createQuery("SELECT p.value FROM Parameter p where p.name = :codigo ");
        query.setParameter("codigo", n);
        String s = (String) query.getSingleResult();
        		
//		String Value = em.createQuery("SELECT p.value FROM Parameter p where p.name = :name ", String.class)
//				.setParameter("name", name)
//				.setMaxResults(1)
//				.getSingleResult();
		return s;
	}

}
