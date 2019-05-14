package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.persistance.interfaces.AdminDAOLocal;


@Stateful
public class AdminDAO implements AdminDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public AdminDAO() {
    }

    @Override
	public DTAdmin add(DTAdmin a) {
		// con id null
		//Admin admin = new Admin(a);
		//em.persist(a);
    	//return admin.getDT();
		return (new DTAdmin() );
	}

	@Override
	public DTAdmin update(DTAdmin a) {
		/*
		Admin admin = new Admin(a);
		em.merge(a);
		return a.getDT();
		*/
		return (new DTAdmin());
	}

	@Override
	public void delete(DTAdmin a) {
		/*
		Admin admin = new Admin(a);
		em.remove(em.merge(admin));
		*/
	}
	
	@Override
	public DTAdmin get(Integer id) {
		/*
		 Admin admin = em.find(Admin.class, id);
		return Admin.getDT();
		 */
		return (new DTAdmin());
	}
	
	@Override
	public DTAdmin get(String email) {
		/*
		 Admin admin = em.find(Admin.class, id);
		return Admin.getDT();
		 */
		return (new DTAdmin());
	}
	
	@Override
	public List<DTAdmin> list() {
		/*List<DTAdmin> ListParameter = em.createQuery("SELECT p FROM ADMIN p", Admin.class).getResultList();
		List<DTAdmin> ListDT = new ArrayList<DTAdmin>();
		for(Admin t : ListParameter){
			ListDT.add(t.getDTParametro());
		}
		return ListDT; 
		*/
		List<DTAdmin> ListDT = new ArrayList<DTAdmin>();
		return ListDT;
	}
	}
