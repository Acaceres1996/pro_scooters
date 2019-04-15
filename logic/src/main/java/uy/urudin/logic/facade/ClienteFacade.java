package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.datatypes.DTCliente;
import uy.urudin.logic.interfaces.ClienteFacadeLocal;
import uy.urudin.logic.interfaces.ClienteFacadeRemote;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;



/**
 * Session Bean implementation class ClienteFacade
 */
@Stateless
@LocalBean
public class ClienteFacade implements ClienteFacadeRemote, ClienteFacadeLocal {

	@EJB
	ClienteDAOLocal ClienteDAO;
	
    /**
     * Default constructor. 
     */
    public ClienteFacade() {
        
    }

	@Override
	public void add(DTCliente dtCliente) {
		ClienteDAO.add(dtCliente);
	}

	@Override
	public void update(DTCliente dtCliente) {
		ClienteDAO.merge(dtCliente);
	}

	@Override
	public void delete(DTCliente dtCliente) {
		ClienteDAO.delete(dtCliente);
	}

	@Override
	public DTCliente find(Integer id) {
		return ClienteDAO.find(id);
	}

	@Override
	public List<DTCliente> findAll() {
		return ClienteDAO.findAll();
	}


}
