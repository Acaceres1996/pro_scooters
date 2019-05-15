package uy.urudin.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.persistance.interfaces.AdminDAOLocal;
import uy.urudin.persistance.model.Admin;
import uy.urudin.persistance.model.Parametro;
import uy.urudin.persistance.model.Scooter;


@Stateful
public class AdminDAO implements AdminDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public AdminDAO() {
    }

    @Override
	public DTAdmin add(DTAdmin dtAdmin) {
		// con id null
		Admin Admin = new Admin(dtAdmin);
		//existe el usario ingresado?
		if(existeusuario(dtAdmin.getUsuario()) <= 0 ) {
			em.persist(Admin);
			return Admin.getDTAdmin();
		}else {
			return null;
		}
	}
    
    
	private int existeusuario(String usuario) {
		Query query = em.createQuery("SELECT count(*) FROM Admin p where p.usuario = :usuario ");
        query.setParameter("usuario", usuario);
        int i = 9;
        try {
        	i = ((Number) query.getSingleResult()).intValue();;
		} catch (Exception e) {
			i = 8;
		}
		return i;
	}

	@Override
	public void delete(Integer Id) {
		DTAdmin dtadmin = find(Id);
		Admin admin = new Admin(dtadmin);
		em.remove(em.merge(admin));
	}
	
	private DTAdmin find(Integer id) {
		Admin admin = em.find(Admin.class, id);
		return admin.getDTAdmin();
	}
	
	@Override
	public List<DTAdmin> findAll() {
		List<Admin> ListAdmin = em.createQuery("SELECT p FROM Admin p", Admin.class).getResultList();
		List<DTAdmin> ListDT = new ArrayList<DTAdmin>();
		for(Admin t : ListAdmin){
			ListDT.add(t.getDTAdmin());
		}
		return ListDT; 
	}

}
