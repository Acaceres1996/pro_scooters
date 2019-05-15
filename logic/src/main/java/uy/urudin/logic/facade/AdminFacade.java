package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.logic.interfaces.AdminFacadeLocal;
import uy.urudin.persistance.interfaces.AdminDAOLocal;




/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class AdminFacade implements  AdminFacadeLocal {


	@EJB
	AdminDAOLocal AdminDAO;
	
    /**
     * Default constructor. 
     */
    public AdminFacade() {
        
    }

    @Override
	public DTAdmin add(DTAdmin dtParameter) {
		return AdminDAO.add(dtParameter);
	}


	@Override
	public List<DTAdmin> findAll() {
		return AdminDAO.findAll();
	}

	
	@Override
	public void delete(Integer Id) {
		AdminDAO.delete(Id);
	}

	@Override
	public boolean login(DTAdmin dtAdmin) {
		List<DTAdmin> all = findAll();
		boolean ret = false;
		for (DTAdmin one : all) {
			if(one.getUsuario().equals(dtAdmin.getUsuario()) && one.getPassword().equals(dtAdmin.getPassword())) {
				ret = true;
			}
		}
		return ret;
	}



}
