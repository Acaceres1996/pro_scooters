package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.datatypes.DTParametro;
import uy.urudin.logic.interfaces.ParametroFacadeLocal;
import uy.urudin.logic.interfaces.ParametroFacadeRemote;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;



/**
 * Session Bean implementation class ParameterFacade
 */
@Stateless
@LocalBean
public class ParametroFacade implements ParametroFacadeRemote, ParametroFacadeLocal {

	@EJB
	ParametroDAOLocal ParametroDAO;
	
    /**
     * Default constructor. 
     */
    public ParametroFacade() {
        
    }

	@Override
	public void add(DTParametro dtParameter) {
		ParametroDAO.add(dtParameter);
	}

	@Override
	public void update(DTParametro dtParameter) {
		ParametroDAO.merge(dtParameter);
	}

	@Override
	public void delete(DTParametro dtParameter) {
		ParametroDAO.delete(dtParameter);
	}

	@Override
	public DTParametro find(Integer id) {
		return ParametroDAO.find(id);
	}

	@Override
	public List<DTParametro> findAll() {
		return ParametroDAO.findAll();
	}

	@Override
	public String getValueByName(String Name) {
		return ParametroDAO.getValueByName(Name);
	}


	@Override
	public DTParametro getDTParameterByName(String Name) {
		return ParametroDAO.getDTParameterByName(Name);
	}
	

}
