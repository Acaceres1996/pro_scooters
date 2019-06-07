package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
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
	public DTCliente add(DTCliente dtParameter) throws Exception {
    	
	    try{
	    	DTCliente nuevo= ClienteDAO.add(dtParameter);
	    	if(nuevo != null) {
	    		return nuevo;
			} else {
	            throw new Exception("El correo ingresado ya está siendo utilizado.");
			}
	    }catch(Exception e){
            throw new Exception("El correo ingresado ya está siendo utilizado.");
	    }

	}

	@Override
	public DTCliente update(DTCliente dtParameter) throws Exception {
	    try{
	    	DTCliente nuevo= ClienteDAO.merge(dtParameter);
	    	if(nuevo != null) {
	    		return nuevo;
			} else {
	            throw new Exception("Ocurrió un error al actualizar los datos.");
			}
	    }catch(Exception e){
            throw new Exception("Ocurrió un error al actualizar los datos.");
	    }
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
	public DTCliente find(String email) throws Exception {
	    try{
	    	DTCliente nuevo= ClienteDAO.find(email);
	    	if(nuevo != null) {
	    		return nuevo;
			} else {
	            throw new Exception("Cliente no valido.");
			}
	    }catch(Exception e){
	            throw new Exception("Cliente no valido.");
	    }

	}

}
