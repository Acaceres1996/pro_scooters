package uy.pencas.core.logic.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import uy.pencas.core.logic.interfaces.LuckyNumbersLocal;
import uy.pencas.core.logic.interfaces.ParameterFacadeLocal;

@Stateless(mappedName = "wsLuckyNumbers")
@LocalBean
@WebService(serviceName="wsLuckyNumbers")
public class wsLuckyNumbers implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	LuckyNumbersLocal ejbLuckyNumbers;
	@EJB
	ParameterFacadeLocal ejbPar;
	
	public wsLuckyNumbers() {

	}
	
	
	@WebMethod(operationName="GetResultMatch")
	public List<Integer> GetResultMatch(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		if(userP.equals(user) && passP.equals(password)) {
			//ANU ES LENTO.
			return ejbLuckyNumbers.GetResultMatch("RANDOM");
		} else {
			return null;
		}
	}
	
//	@WebMethod(operationName="GetLuckyNumbers")
//	public List<Integer> GetLuckyNumbers(@WebParam(name="provider") String provider,@WebParam(name="game") String game) {
//		return ejbLuckyNumbers.GetLuckyNumbers(provider, game);
//	}
//
//
//	
//	@WebMethod(operationName="GetLuckyNumbersANUORO")
//	public List<Integer> GetLuckyNumbersANUORO() {
//		return ejbLuckyNumbers.GetLuckyNumbers("ANU", "5 de oro");
//	}
//	
//	@WebMethod(operationName="GetLuckyNumbersANUQUINELA")
//	public List<Integer> GetLuckyNumbersANUQUINELA() {
//		return ejbLuckyNumbers.GetLuckyNumbers("ANU", "quiniela");
//	}
//
//	@WebMethod(operationName="GetLuckyNumbersRANDOMORO")
//	public List<Integer> GetLuckyNumbersRANDOMORO() {
//		return ejbLuckyNumbers.GetLuckyNumbers("RANDOM", "5 de oro");
//	}
//	
//	@WebMethod(operationName="GetLuckyNumbersRANDOMQUINELA")
//	public List<Integer> GetLuckyNumbersRANDOMQUINELA() {
//		return ejbLuckyNumbers.GetLuckyNumbers("RANDOM", "quiniela");
//	}
	
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}

}
