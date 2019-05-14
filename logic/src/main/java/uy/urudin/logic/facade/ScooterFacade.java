package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;



/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class ScooterFacade implements  ScooterFacadeLocal {


	@EJB
	ScooterDAOLocal ScooterDAO;
	
    /**
     * Default constructor. 
     */
    public ScooterFacade() {
        
    }

	@Override
	public DTScooter add(DTScooter dtScooter) {
		return ScooterDAO.add(dtScooter);
	}

	@Override
	public DTScooter update(DTScooter dtScooter) {
		return ScooterDAO.merge(dtScooter);
	}

	@Override
	public void delete(Integer Id) {
		ScooterDAO.delete(Id);
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
