package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTRegistro;
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
			
//System.out.println("DEBUGDEBUGDEBUG:" + "adentro" + ";");
			
			//parametro sistema a numero
			String minbat = ParametroDAO.getValueByName("BATERIABAJA");
			Integer minimobat = Integer.valueOf(minbat);
//	System.out.println("DEBUGDEBUGDEBUG:" + minimobat + ";");
	
			//listar cuales son los scooter que cumplen con ello
			List<DTScooter> libres = ScooterDAO.scootersLibres();
//	System.out.println("DEBUGDEBUGDEBUG:" +"zize" + libres.size()  + ";");
			
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

	@Override
	public DTScooterhistorico registroScooterHistorico(DTRegistro dtregistro) {
		DTScooter dtscooter = ScooterDAO.find(dtregistro.getScooterid());
		// actulizar estado a encendido si no lo esta.
		if(!dtscooter.isEncendido()) {
			dtscooter.setEncendido(true);
			dtscooter = ScooterDAO.merge(dtscooter);
		}
		
		DTScooterhistorico newSH = new DTScooterhistorico();
		newSH.setBateria(dtregistro.getBateria());
		newSH.setLatitud(dtregistro.getLatitud());
		newSH.setLongitud(dtregistro.getLongitud());
		newSH.setScooter(dtscooter);
		
		DTScooterhistorico creadoSH =  ScooterhistoricoDAO.add(newSH);
		
		return creadoSH;
		
	}

	@Override
	public List<DTScooterhistorico> todoslosScootersHistoricoCercanos(String latitudCentrada, String longitudCentrada) {
		// primero traigo todo los scooters disponibles de ser alquilados
		List<DTScooterhistorico> scootersdisponibles =  todoslosScootersHistoricoDisponibles();
		List<DTScooterhistorico> scooterscercanos = new ArrayList<DTScooterhistorico>();
				
		String mindist = ParametroDAO.getValueByName("RANGOCERCA"); //rango en metros, tiene que ser menor a lo que consideramos cerca.
		double mindistancia = Double.parseDouble(mindist);
		
		// para cada uno de ellos calculo la distancia con respecto al punto (lat,long centrada)
		for (DTScooterhistorico oneSH : scootersdisponibles) {
			double distanciakm = Haversine.distance(Double.parseDouble(latitudCentrada), Double.parseDouble(longitudCentrada), Double.parseDouble(oneSH.getLatitud()), Double.parseDouble(oneSH.getLongitud()));
			double distanciametros = distanciakm * 1000; //convierto a metros mas sercano al usuario.
System.out.println("METROS:" + distanciametros);
			if(distanciametros <= mindistancia) {
				//agrego esta en rango sercano en metros.
				scooterscercanos.add(oneSH);
			}
		}
		
		return scooterscercanos;
	}

	@Override
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooterBasico(Integer idscooter) {
		return ScooterhistoricoDAO.ultimoScooterHistoricoUnIdScooterBasico(idscooter);
	}


	@Override
	public List<DTScooterhistorico> todoslosScootersHistoricoApagadosoBateriaBaja() {
		List<DTScooterhistorico> scootershistoricoapagadosobateriabaja = new ArrayList<DTScooterhistorico>();
		
		// consigo la bateria baja
		int bateriabaja = Integer.valueOf(ParametroDAO.getDTParameterByName("BATERIABAJA").getValor());
		
		// scooters apagados creo los historicos con coordenadas.
		List<DTScooter> scootersapagados = ScooterDAO.scootersApagados();
		for (DTScooter dtScooter : scootersapagados) {
			scootershistoricoapagadosobateriabaja.add(this.ultimoScooterHistoricoUnIdScooter(dtScooter.getId()));
		}

		
		// todos los scooters
		List<DTScooter> scooterstodos = ScooterDAO.findAll();
		for (DTScooter onedtScooter : scooterstodos) {
			DTScooterhistorico dtsh = ScooterhistoricoDAO.ultimoScooterHistoricoUnIdScooter(onedtScooter.getId());
			//tiene bateria baja su ultimo registro?
			if(dtsh.getBateria() <= bateriabaja) {
				//existe ya ingresado a la lista?? para no repetir
				boolean existe = false;
				
				//reviso si existe ya.
				for (DTScooterhistorico onedtScoothistoricoerapagado : scootershistoricoapagadosobateriabaja) {
					if(onedtScoothistoricoerapagado.getId() == dtsh.getId()) {
						existe = true;
					}
				}
				
				
				if(!existe) {
					//agrego a retornar
					scootershistoricoapagadosobateriabaja.add(dtsh);
				}
			}
		}
		
		
		return scootershistoricoapagadosobateriabaja;
	}


}
