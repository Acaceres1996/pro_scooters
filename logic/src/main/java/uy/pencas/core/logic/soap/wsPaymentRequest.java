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
import scooters.core.logic.interfaces.PaymentRequestFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTPaymentRequest;
import uy.pencas.core.datatypes.datatypes.DTTeam;

@Stateless(mappedName = "wsPaymentRequest")
@LocalBean
@WebService(serviceName="wsPaymentRequest")
public class wsPaymentRequest implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	PaymentRequestFacadeLocal ejbPaymentRequest;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
	
    public wsPaymentRequest() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllPaymentRequest")
	public List<DTPaymentRequest> getAllPaymentRequest(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbPaymentRequest.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getPaymentRequest")
	public DTPaymentRequest getPaymentRequest(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbPaymentRequest.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deletePaymentRequest")
	public void deletePaymentRequest(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPaymentRequest") DTPaymentRequest dtPaymentRequest) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbPaymentRequest.delete(dtPaymentRequest);
		}
	}
	
	@WebMethod(operationName="addPaymentRequest")
	public void addPaymentRequest(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPaymentRequest") DTPaymentRequest dtPaymentRequest) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.PaymentRequest
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbPaymentRequest.add(dtPaymentRequest);
		}
	}
	
	@WebMethod(operationName="updatePaymentRequest")
	public void updatePaymentRequest(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPaymentRequest") DTPaymentRequest dtPaymentRequest) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbPaymentRequest.update(dtPaymentRequest);
		}
	}

}
