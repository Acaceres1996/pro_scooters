package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import scooters.core.logic.interfaces.MatchFacadeLocal;
import scooters.core.logic.interfaces.ParameterFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeSport;

@Stateless(mappedName = "wsMatch")
@LocalBean
@WebService(serviceName="wsMatch")
public class wsMatch implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	MatchFacadeLocal ejbMatch;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
	
    public wsMatch() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllMatch")
	public List<DTMatch> getAllMatch(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbMatch.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getMatch")
	public DTMatch getMatch(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbMatch.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deleteMatch")
	public void deleteMatch(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtMatch") DTMatch dtMatch) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbMatch.delete(dtMatch);
		}
	}
	
	@WebMethod(operationName="addMatch")
	public void addMatch(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtMatch") DTMatch dtMatch) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.Match
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbMatch.add(dtMatch);
		}
	}
	
	@WebMethod(operationName="updateMatch")
	public void updateMatch(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtMatch") DTMatch dtMatch) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbMatch.update(dtMatch);
		}
	}


}
