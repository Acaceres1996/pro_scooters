package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;
import uy.urudin.logic.interfaces.ScooterhistoricoFacadeLocal;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.interfaces.ScooterhistoricoDAOLocal;



/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class ScooterhistoricoFacade implements  ScooterhistoricoFacadeLocal {


	@EJB
	ScooterhistoricoDAOLocal ScooterhistoricoDAO;
	
    /**
     * Default constructor. 
     */
    public ScooterhistoricoFacade() {
        
    }
    
	@EJB
	ParametroDAOLocal ParametroDAO;
	@EJB
	ScooterDAOLocal ScooterDAO;

	@Override
	public List<DTScooterhistorico> todoslosScootersHistoricoDisponibles() {
			// se considera disponible
			//Solo se mostraran Scooters encendidos, que no se encuentren en uso y con batería mayor al mínimo definido por el sistema. 
			
			//inicializo vacio
			List<DTScooterhistorico> ret = new ArrayList<DTScooterhistorico>();
			
			//parametro sistema a numero
			String minbat = ParametroDAO.getValueByName("BATERIABAJA");
			Integer minimobat = Integer.valueOf(minbat);
	System.out.println("DEBUGDEBUGDEBUG:" + minimobat + ";");
	
			//listar cuales son los scooter que cumplen con ello
			List<DTScooter> libres = ScooterDAO.scootersLibres();
	System.out.println("DEBUGDEBUGDEBUG:" +"zize" + libres.size()  + ";");
			
			//pedir ultima ubicacion de esos scooters
			for (DTScooter onescooter : libres) {
				
				//ultimo historico de uno libre.
				DTScooterhistorico oneSH = ultimoScooterHistoricoUnIdScooter(onescooter.getId());
				
				//solo incluyo quienes bateria > al minimo.
				if(oneSH.getBateria() > minimobat) {
					ret.add(oneSH);
				}
			}
			return ret;
		}

	@Override
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooter(Integer idscooter) {
		return ScooterhistoricoDAO.ultimoScooterHistoricoUnIdScooter(idscooter);
	}

	@Override
	public DTScooterhistorico find(Integer id) {
		return ScooterhistoricoDAO.find(id);
	}




}
