package scooters.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import scooters.core.datatypes.DTScooter;
import scooters.core.logic.interfaces.ScooterFacadeLocal;
import scooters.core.logic.interfaces.ScooterFacadeRemote;
import scooters.core.persistance.interfaces.ScooterDAOLocal;

@Stateless
@LocalBean
public class ScooterFacade implements ScooterFacadeRemote, ScooterFacadeLocal {

	@EJB
	ScooterDAOLocal scooterDAO;
	
	public ScooterFacade() {
		
	}
	
	@Override
	public void add(DTScooter scooter) {
		scooterDAO.add(scooter);
	}
	@Override
	public void merge(DTScooter scooter) {
		scooterDAO.merge(scooter);
	}
	
	@Override
	public void delete(DTScooter scooter) {
		scooterDAO.delete(scooter);
	}
	
	@Override
	public DTScooter find(Integer id) {
		return scooterDAO.find(id);
	}
	
	@Override
	public List<DTScooter> findAll(){
		return scooterDAO.findAll();
	}
	
}




