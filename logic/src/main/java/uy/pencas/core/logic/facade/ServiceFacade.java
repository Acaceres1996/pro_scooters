package uy.pencas.core.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTService;
import uy.pencas.core.datatypes.enumerated.Type;
import uy.pencas.core.datatypes.enumerated.TypeService;
import uy.pencas.core.logic.interfaces.ServiceFacadeLocal;
import uy.pencas.core.logic.interfaces.ServiceFacadeRemote;

import uy.pencas.core.persistance.interfaces.ServiceDAOLocal;

/**
 * Session Bean implementation class ServiceFacade
 */
@Stateless
@LocalBean
public class ServiceFacade implements ServiceFacadeRemote, ServiceFacadeLocal {

	@EJB
	ServiceDAOLocal serviceDAO;
	
    /**
     * Default constructor. 
     */
    public ServiceFacade() {
        
    }

	@Override
	public void add(DTService dtService) {
		serviceDAO.add(dtService);
	}

	@Override
	public void update(DTService dtService) {
		serviceDAO.merge(dtService);
	}

	@Override
	public void delete(DTService dtService) {
		serviceDAO.delete(dtService);
	}

	@Override
	public DTService find(Integer id) {
		return serviceDAO.find(id);
	}

	@Override
	public List<DTService> findAll() {
		return serviceDAO.findAll();
	}

	@Override
	public List<DTService> findEnabled() {
		List<DTService> all = this.findAll();
		List<DTService> enabled = new ArrayList<>();
		for(DTService s : all) {
			if( s.getEnabled() ) {
				enabled.add(s);
			}
		}
		return enabled;
	}

}
