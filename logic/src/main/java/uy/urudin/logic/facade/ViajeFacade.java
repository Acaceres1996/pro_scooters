package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTViaje;
import uy.urudin.logic.interfaces.ViajeFacadeLocal;
import uy.urudin.persistance.interfaces.ViajeDAOLocal;



/**
 * Session Bean implementation class ViajeFacade
 */
@Stateless
@LocalBean
public class ViajeFacade implements  ViajeFacadeLocal {


	@EJB
	ViajeDAOLocal ViajeDAO;
	
    /**
     * Default constructor. 
     */
    public ViajeFacade() {
        
    }

	@Override
	public DTViaje add(DTViaje dtViaje) {
		try {
			return ViajeDAO.add(dtViaje);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public DTViaje update(DTViaje dtViaje) {
		return ViajeDAO.merge(dtViaje);
	}

	@Override
	public DTViaje find(Integer id) {
		return ViajeDAO.find(id);
	}

	@Override
	public List<DTViaje> findAll() {
		return ViajeDAO.findAll();
	}

}
