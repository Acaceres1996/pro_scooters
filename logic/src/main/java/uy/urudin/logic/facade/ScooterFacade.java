package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.datatypes.DTScooter;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;
import uy.urudin.logic.interfaces.ScooterFacadeRemote;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;



/**
 * Session Bean implementation class ParameterFacade
 */
@Stateless
@LocalBean
public class ScooterFacade implements ScooterFacadeRemote, ScooterFacadeLocal {

	@EJB
	ScooterDAOLocal ScooterDAO;
	
    /**
     * Default constructor. 
     */
    public ScooterFacade() {
        
    }

	@Override
	public void add(DTScooter dtParameter) {
		ScooterDAO.add(dtParameter);
	}

	@Override
	public void update(DTScooter dtParameter) {
		ScooterDAO.merge(dtParameter);
	}

	@Override
	public void delete(DTScooter dtParameter) {
		ScooterDAO.delete(dtParameter);
	}

	@Override
	public DTScooter find(Integer id) {
		return ScooterDAO.find(id);
	}

	@Override
	public List<DTScooter> findAll() {
		return ScooterDAO.findAll();
	}


}
