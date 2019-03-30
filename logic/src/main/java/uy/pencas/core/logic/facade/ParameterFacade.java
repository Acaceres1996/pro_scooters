package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTParameter;
import uy.pencas.core.logic.interfaces.ParameterFacadeLocal;
import uy.pencas.core.logic.interfaces.ParameterFacadeRemote;

import uy.pencas.core.persistance.interfaces.ParameterDAOLocal;

/**
 * Session Bean implementation class ParameterFacade
 */
@Stateless
@LocalBean
public class ParameterFacade implements ParameterFacadeRemote, ParameterFacadeLocal {

	@EJB
	ParameterDAOLocal ParameterDAO;
	
    /**
     * Default constructor. 
     */
    public ParameterFacade() {
        
    }

	@Override
	public void add(DTParameter dtParameter) {
		ParameterDAO.add(dtParameter);
	}

	@Override
	public void update(DTParameter dtParameter) {
		ParameterDAO.merge(dtParameter);
	}

	@Override
	public void delete(DTParameter dtParameter) {
		ParameterDAO.delete(dtParameter);
	}

	@Override
	public DTParameter find(Integer id) {
		return ParameterDAO.find(id);
	}

	@Override
	public List<DTParameter> findAll() {
		return ParameterDAO.findAll();
	}

	@Override
	public String getValueByName(String Name) {
		return ParameterDAO.getValueByName(Name);
	}
	

}
