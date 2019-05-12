package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.persistance.interfaces.AdminDAOLocal;
import uy.urudin.persistance.model.Admin;


@Stateful
public class AdminDAO implements AdminDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public AdminDAO() {
    }

	@Override
	public void add(DTAdmin dtAdmin) {
		// con id null
		Admin Admin = new Admin(dtAdmin);
		em.persist(Admin);
	}

	@Override
	public void merge(DTAdmin dtAdmin) {
		Admin Admin = new Admin(dtAdmin);
		em.merge(Admin);
	}
/*
	@Override
	public void delete(DTParameter dtParameter) {
		Parameter Parameter = new Parameter(dtParameter);
		em.remove(em.merge(Parameter));
	}
*/
	@Override
	public DTAdmin find(Integer id) {
		Admin Admin = em.find(Admin.class, id);
		return Admin.getDTAdmin();
	}
	/*

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
*/

	@Override
	public void delete(DTAdmin dtadmin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DTAdmin> findAll() {
		List<Admin> ListAdmin = em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
		List<DTAdmin> ListDT = new ArrayList<DTAdmin>();
		for(Admin t : ListAdmin){
			ListDT.add(t.getDTAdmin());
		}
		return ListDT; 
	}
}
