package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import scooters.core.logic.interfaces.ParameterFacadeLocal;
import scooters.core.logic.interfaces.TeamFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeSport;

@Stateless(mappedName = "wsTeam")
@LocalBean
@WebService(serviceName="wsTeam")
public class wsTeam implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	TeamFacadeLocal ejbTeam;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
	public wsTeam() {

	}
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllTeam")
	public List<DTTeam> getAllTeam(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbTeam.findAll();
		}else {
			return null;
		}
	}

	@WebMethod(operationName="getTeam")
	public DTTeam getTeam(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbTeam.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deleteTeam")
	public void deleteTeam(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtTeam") DTTeam dtTeam) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbTeam.delete(dtTeam);
		}
		
	}
	
	@WebMethod(operationName="addTeam")
	public void addTeam(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtTeam") DTTeam dtTeam) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.Team
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbTeam.add(dtTeam);
		}
		
	}
	
	@WebMethod(operationName="updateTeam")
	public void updateTeam(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtTeam") DTTeam dtTeam) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbTeam.update(dtTeam);
		}
	}

}
