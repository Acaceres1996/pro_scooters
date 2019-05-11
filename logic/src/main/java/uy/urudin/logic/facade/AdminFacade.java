package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.logic.interfaces.AdminFacadeLocal;
import uy.urudin.logic.interfaces.AdminFacadeRemote;
import uy.urudin.persistance.interfaces.AdminDAOLocal;



/**
 * Session Bean implementation class AdminFacade
 */
@Stateless
@LocalBean
public class AdminFacade implements AdminFacadeRemote, AdminFacadeLocal {

	@EJB
	AdminDAOLocal AdminDAO;
	
    /**
     * Default constructor. 
     */
    public AdminFacade() {
        
    }

	@Override
	public void add(DTAdmin dtAdmin) {
		AdminDAO.add(dtAdmin);
	}

	@Override
	public void update(DTAdmin dtAdmin) {
		AdminDAO.merge(dtAdmin);
	}

	@Override
	public void delete(DTAdmin dtAdmin) {
		AdminDAO.delete(dtAdmin);
	}

	@Override
	public DTAdmin find(Integer id) {
		return AdminDAO.find(id);
	}

	@Override
	public List<DTAdmin> findAll() {
		return AdminDAO.findAll();
	}


}
