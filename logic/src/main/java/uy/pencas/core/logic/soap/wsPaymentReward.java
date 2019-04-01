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
import scooters.core.logic.interfaces.PaymentRewardFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTPaymentReward;
import uy.pencas.core.datatypes.datatypes.DTTeam;

@Stateless(mappedName = "wsPaymentReward")
@LocalBean
@WebService(serviceName="wsPaymentReward")
public class wsPaymentReward implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	PaymentRewardFacadeLocal ejbPaymentReward;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
	
    public wsPaymentReward() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllPaymentReward")
	public List<DTPaymentReward> getAllPaymentReward(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbPaymentReward.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getPaymentReward")
	public DTPaymentReward getPaymentReward(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbPaymentReward.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deletePaymentReward")
	public void deletePaymentReward(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPaymentReward") DTPaymentReward dtPaymentReward) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbPaymentReward.delete(dtPaymentReward);
		}
	}
	
	@WebMethod(operationName="addPaymentReward")
	public void addPaymentReward(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPaymentReward") DTPaymentReward dtPaymentReward) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.PaymentReward
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbPaymentReward.add(dtPaymentReward);
		}
	}
	
	@WebMethod(operationName="updatePaymentReward")
	public void updatePaymentReward(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPaymentReward") DTPaymentReward dtPaymentReward) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbPaymentReward.update(dtPaymentReward);
		}
	}

}
