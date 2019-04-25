package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;
import uy.urudin.logic.interfaces.ScooterFacadeRemote;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;



/**
 * Session Bean implementation class ScooterFacade
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
	public void add(DTScooter dtScooter) {
		ScooterDAO.add(dtScooter);
	}

	@Override
	public void update(DTScooter dtScooter) {
		ScooterDAO.merge(dtScooter);
	}

	@Override
	public void delete(DTScooter dtScooter) {
		ScooterDAO.delete(dtScooter);
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
