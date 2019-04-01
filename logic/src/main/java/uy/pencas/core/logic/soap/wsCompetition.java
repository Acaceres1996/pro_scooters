package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import scooters.core.logic.interfaces.CompetitionFacadeLocal;
import scooters.core.logic.interfaces.ParameterFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.datatypes.DTTeam;

@Stateless(mappedName = "wsCompetition")
@LocalBean
@WebService(serviceName="wsCompetition")
public class wsCompetition implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	CompetitionFacadeLocal ejbCompetition;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
    public wsCompetition() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllCompetition")
	public List<DTCompetition> getAllCompetition(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbCompetition.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getCompetition")
	public DTCompetition getCompetition(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbCompetition.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deleteCompetition")
	public void deleteCompetition(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtTeam") DTCompetition dtCompetition) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbCompetition.delete(dtCompetition);
		}
	}
	
	@WebMethod(operationName="addCompetition")
	public void addCompetition(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtTeam") DTCompetition dtCompetition) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbCompetition.add(dtCompetition);
		}
	}
	
	@WebMethod(operationName="updateCompetition")
	public void updateCompetition(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtTeam") DTCompetition dtCompetition) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbCompetition.update(dtCompetition);
	
		}
	}


}
