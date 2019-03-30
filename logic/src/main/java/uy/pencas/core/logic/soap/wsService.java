package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


import uy.pencas.core.datatypes.datatypes.DTService;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.logic.interfaces.ParameterFacadeLocal;
import uy.pencas.core.logic.interfaces.ServiceFacadeLocal;

@Stateless(mappedName = "wsService")
@LocalBean
@WebService(serviceName="wsService")
public class wsService implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	ServiceFacadeLocal ejbService;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
	
    public wsService() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllService")
	public List<DTService> getAllService(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbService.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getService")
	public DTService getService(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbService.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deleteService")
	public void deleteService(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtService") DTService dtService) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbService.delete(dtService);
		}
	}
	
	@WebMethod(operationName="addService")
	public void addService(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtService") DTService dtService) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.Service
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbService.add(dtService);
		}
	}
	
	@WebMethod(operationName="updateService")
	public void updateService(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtService") DTService dtService) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbService.update(dtService);
		}
	}
}
