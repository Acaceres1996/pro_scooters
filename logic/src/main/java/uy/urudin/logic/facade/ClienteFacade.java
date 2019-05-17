package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTParametro;
import uy.urudin.logic.interfaces.ClienteFacadeLocal;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;




/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class ClienteFacade implements  ClienteFacadeLocal {


	@EJB
	ClienteDAOLocal ClienteDAO;
	@EJB
	ParametroDAOLocal ParametroDAO;
	
    /**
     * Default constructor. 
     */
    public ClienteFacade() {
        
    }

    @Override
	public DTCliente add(DTCliente dtParameter) {
		return ClienteDAO.add(dtParameter);
	}

	@Override
	public DTCliente update(DTCliente dtParameter) {
		return ClienteDAO.merge(dtParameter);
	}

	@Override
	public List<DTCliente> findAll() {
		return ClienteDAO.findAll();
	}

	@Override
	public DTCliente find(Integer id) {
		return ClienteDAO.find(id);
	}

	@Override
	public DTCliente find(String email) {
		return ClienteDAO.find(email);
	}

}
