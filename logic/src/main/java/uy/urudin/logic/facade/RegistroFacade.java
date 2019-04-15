package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.datatypes.DTRegistro;
import uy.urudin.logic.interfaces.RegistroFacadeLocal;
import uy.urudin.logic.interfaces.RegistroFacadeRemote;
import uy.urudin.persistance.interfaces.RegistroDAOLocal;



/**
 * Session Bean implementation class RegistroFacade
 */
@Stateless
@LocalBean
public class RegistroFacade implements RegistroFacadeRemote, RegistroFacadeLocal {

	@EJB
	RegistroDAOLocal RegistroDAO;
	
    /**
     * Default constructor. 
     */
    public RegistroFacade() {
        
    }

	@Override
	public void add(DTRegistro dtRegistro) {
		RegistroDAO.add(dtRegistro);
	}

	@Override
	public void update(DTRegistro dtRegistro) {
		RegistroDAO.merge(dtRegistro);
	}

	@Override
	public void delete(DTRegistro dtRegistro) {
		RegistroDAO.delete(dtRegistro);
	}

	@Override
	public DTRegistro find(Integer id) {
		return RegistroDAO.find(id);
	}

	@Override
	public List<DTRegistro> findAll() {
		return RegistroDAO.findAll();
	}


}
