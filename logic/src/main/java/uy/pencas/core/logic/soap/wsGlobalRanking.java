package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


import uy.pencas.core.datatypes.datatypes.DTGlobalRanking;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeSport;
import uy.pencas.core.logic.interfaces.GlobalRankingFacadeLocal;
import uy.pencas.core.logic.interfaces.ParameterFacadeLocal;

@Stateless(mappedName = "wsGlobalRanking")
@LocalBean
@WebService(serviceName="wsGlobalRanking")
public class wsGlobalRanking implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	GlobalRankingFacadeLocal ejbGlobalRanking;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
    public wsGlobalRanking() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllGlobalRanking")
	public List<DTGlobalRanking> getAllGlobalRanking(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		if(userP.equals(user) && passP.equals(password)) {
			return ejbGlobalRanking.findAll();
		} else {
			return null;
		}
	}
	
	@WebMethod(operationName="getGlobalRanking")
	public DTGlobalRanking getGlobalRanking(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbGlobalRanking.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deleteGlobalRanking")
	public void deleteGlobalRanking(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtGlobalRanking") DTGlobalRanking dtGlobalRanking) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbGlobalRanking.delete(dtGlobalRanking);
		}
	}
	
	@WebMethod(operationName="addGlobalRanking")
	public void addGlobalRanking(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtGlobalRanking") DTGlobalRanking dtGlobalRanking) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbGlobalRanking.add(dtGlobalRanking);
		}
	}
	
	@WebMethod(operationName="updateGlobalRanking")
	public void updateGlobalRanking(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtGlobalRanking") DTGlobalRanking dtGlobalRanking) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbGlobalRanking.update(dtGlobalRanking);
		}
	}

}
