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
import scooters.core.logic.interfaces.PrizeFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.datatypes.datatypes.DTTeam;

@Stateless(mappedName = "wsPrize")
@LocalBean
@WebService(serviceName="wsPrize")
public class wsPrize implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	PrizeFacadeLocal ejbLocalPrize;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
	
    public wsPrize() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllPrize")
	public List<DTPrize> getAllPrize(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbLocalPrize.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getPrize")
	public DTPrize getPrize(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbLocalPrize.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deletePrize")
	public void deletePrize(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPrize") DTPrize dtPrize) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbLocalPrize.delete(dtPrize);
		}
	}
	
	@WebMethod(operationName="addPrize")
	public void addPrize(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPrize") DTPrize dtPrize) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.Prize
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbLocalPrize.add(dtPrize);
		}
	}
	
	@WebMethod(operationName="updatePrize")
	public void updatePrize(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtPrize") DTPrize dtPrize) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbLocalPrize.update(dtPrize);
		}
	}
}
