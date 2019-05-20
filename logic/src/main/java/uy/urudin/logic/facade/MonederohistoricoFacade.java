package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.logic.interfaces.MonederohistoricoFacadeLocal;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.interfaces.MonederohistoricoDAOLocal;




/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class MonederohistoricoFacade implements  MonederohistoricoFacadeLocal {


	@EJB
	MonederohistoricoDAOLocal MonederoDAO;
	@EJB
	ClienteDAOLocal ClienteDAO;
    /**
     * Default constructor. 
     */
    public MonederohistoricoFacade() {
        
    }

    @Override
	public DTMonederohistorico add(DTMonederohistorico dtMonedero) {
    	//FALTA PAYPAL
    	DTCliente c = ClienteDAO.find(dtMonedero.getCliente().getId());
    	dtMonedero.setSaldoprevio(c.getSaldo());
    	c.setSaldo(c.getSaldo() + dtMonedero.getSaldocarga());
    	ClienteDAO.merge(c);
		return MonederoDAO.add(dtMonedero);
	}


	@Override
	public List<DTMonederohistorico> findAll() {
		return MonederoDAO.findAll();
	}

}
