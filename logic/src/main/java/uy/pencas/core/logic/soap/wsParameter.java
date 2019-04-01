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
import uy.pencas.core.datatypes.datatypes.DTParameter;
import uy.pencas.core.datatypes.datatypes.DTTeam;

@Stateless(mappedName = "wsParameter")
@LocalBean
@WebService(serviceName="wsParameter")
public class wsParameter implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	ParameterFacadeLocal ejbParameter;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
	
    public wsParameter() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getAllParameter")
	public List<DTParameter> getAllParameter(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbParameter.findAll();
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="getParameter")
	public DTParameter getParameter(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbParameter.find(id);
		}else {
			return null;
		}
	}
	
	@WebMethod(operationName="deleteParameter")
	public void deleteParameter(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtParameter") DTParameter dtParameter) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbParameter.delete(dtParameter);
		}
	}
	
	@WebMethod(operationName="addParameter")
	public void addParameter(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtParameter") DTParameter dtParameter) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.Parameter
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbParameter.add(dtParameter);
		}
	}
	
	@WebMethod(operationName="updateParameter")
	public void updateParameter(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtParameter") DTParameter dtParameter) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbParameter.update(dtParameter);
		}
	}

	@WebMethod(operationName="getValueByName")
	public String getValueByName(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="name") String name) {
			String userP = ejbPar.getValueByName("USERBACKCORE");
			String passP = ejbPar.getValueByName("PASSBACKCORE");
			
			if(userP.equals(user) && passP.equals(password)) {
				return ejbParameter.getValueByName(name);
			}else {
				return null;
			}
	}


}
