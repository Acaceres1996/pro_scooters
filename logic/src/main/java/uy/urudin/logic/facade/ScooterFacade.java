package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterUltimoRegistro;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.interfaces.ScooterhistoricoDAOLocal;



/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class ScooterFacade implements  ScooterFacadeLocal {


	@EJB
	ScooterDAOLocal ScooterDAO;
	@EJB
	ScooterhistoricoDAOLocal ScooterhistoricoDAO;
	
    /**
     * Default constructor. 
     */
    public ScooterFacade() {
        
    }

	@Override
	public DTScooter add(DTScooter dtScooter) {
		try {
			DTScooter newdtscooter = ScooterDAO.add(dtScooter);
			
			//historico por default
			DTScooterhistorico newSH = new DTScooterhistorico();
			newSH.setBateria(100);
			newSH.setLatitud("-34.9181706");
			newSH.setLongitud("-56.1665725");
			newSH.setScooter(newdtscooter);
			DTScooterhistorico creadoSH =  ScooterhistoricoDAO.add(newSH);
			// sino existe almenos 1 falla el buscar disponibles.
			
			return newdtscooter;
		} catch (Exception e) {
			return null;
		}
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

	@Override
	public List<DTScooter> scootersLibres() {
		return ScooterDAO.scootersLibres();
	}

	@Override
	public List<DTScooterUltimoRegistro> scootersUltimosRegistros() {
		List<DTScooterUltimoRegistro> ret = new ArrayList<DTScooterUltimoRegistro>(); 
		
		//todos los scooters
		List<DTScooter> allscooters = ScooterDAO.findAll();
		
		for (DTScooter onedtScooter : allscooters) {
			//busco su dtscooterhistorico.
			DTScooterhistorico onehistorico = ScooterhistoricoDAO.ultimoScooterHistoricoUnIdScooterBasico(onedtScooter.getId());
			
			//armo el dt nuevo
			DTScooterUltimoRegistro dtnew = new DTScooterUltimoRegistro(onedtScooter,onehistorico);
			ret.add(dtnew);
			
		}
		
		return ret;
	}


}
