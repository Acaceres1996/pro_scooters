package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import scooters.core.logic.interfaces.GlobalCompetitorFacadeLocal;
import scooters.core.logic.interfaces.ParameterFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;

@Stateless(mappedName = "wsGlobalCompetitor")
@LocalBean
@WebService(serviceName="wsGlobalCompetitor")
public class wsGlobalCompetitor implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	GlobalCompetitorFacadeLocal ejbGlobalCompetitor;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
    public wsGlobalCompetitor() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllGlobalCompetitor")
	public List<DTGlobalCompetitor> getAllGlobalCompetitor(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbGlobalCompetitor.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getGlobalCompetitor")
	public DTGlobalCompetitor getGlobalCompetitor(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id,@WebParam(name="idOrganization") Integer idOrganization) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbGlobalCompetitor.find(id,idOrganization);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deleteGlobalCompetitor")
	public void deleteGlobalCompetitor(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtGlobalCompetitor") DTGlobalCompetitor dtGlobalCompetitor) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbGlobalCompetitor.delete(dtGlobalCompetitor);
		}
	}
	
	@WebMethod(operationName="addGlobalCompetitor")
	public void addGlobalCompetitor(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtGlobalCompetitor") DTGlobalCompetitor dtGlobalCompetitor) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbGlobalCompetitor.add(dtGlobalCompetitor);
		}
	}
	
	@WebMethod(operationName="updateGlobalCompetitor")
	public void updateGlobalCompetitor(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtGlobalCompetitor") DTGlobalCompetitor dtGlobalCompetitor) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbGlobalCompetitor.update(dtGlobalCompetitor);
		}
	}


}
