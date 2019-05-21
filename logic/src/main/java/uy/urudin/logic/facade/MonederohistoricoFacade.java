package uy.urudin.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.logic.interfaces.MonederohistoricoFacadeLocal;
import uy.urudin.persistance.interfaces.MonederohistoricoDAOLocal;


/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class MonederohistoricoFacade implements  MonederohistoricoFacadeLocal {


	@EJB
	MonederohistoricoDAOLocal MonederohistoricoDAO;
	
    /**
     * Default constructor. 
     */
    public MonederohistoricoFacade() {
        
    }

	@Override
	public DTMonederohistorico add(DTMonederohistorico dtMonederohistorico) {
		System.out.println("LOGIC ADD");
		return MonederohistoricoDAO.add(dtMonederohistorico);
	}

	@Override
	public List<DTMonederohistorico> findAll() {
		System.out.println("LOGIC FINDALL");
		return MonederohistoricoDAO.findAll();
	}

	@Override
	public DTMonederohistorico find(Integer id) {
		System.out.println("LOGIC FIND");
		return MonederohistoricoDAO.find(id);
	}



}
