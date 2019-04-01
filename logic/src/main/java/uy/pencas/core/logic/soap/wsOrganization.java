package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import scooters.core.logic.interfaces.OrganizationFacadeLocal;
import scooters.core.logic.interfaces.ParameterFacadeLocal;
import uy.pencas.core.datatypes.datatypes.DTOrganization;

@Stateless(mappedName = "wsOrganization")
@LocalBean
@WebService(serviceName="wsOrganization")
public class wsOrganization implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;

	@EJB
	OrganizationFacadeLocal ejbOrganization;
	@EJB
	ParameterFacadeLocal ejbPar;

    public wsOrganization() {
    }

	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}

	@WebMethod(operationName="getAllOrganization")
	public List<DTOrganization> getAllOrganization(@WebParam(name="user") String user,@WebParam(name="password") String password) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbOrganization.findAll();
		}else {
			return null;
		}
	}

	@WebMethod(operationName="getOrganization")
	public DTOrganization getOrganization(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="id") Integer id) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			return ejbOrganization.find(id);
		}else {
			return null;
		}
	}

	@WebMethod(operationName="deleteOrganization")
	public void deleteOrganization(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtOrganization") DTOrganization dtOrganization) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbOrganization.delete(dtOrganization);
		}
	}

	@WebMethod(operationName="addOrganization")
	public void addOrganization(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtOrganization") DTOrganization dtOrganization) {
		//no debe enviarse Id, no debe estar en el request
		//si se envia id falla el WS. >>
		//detached entity passed to persist: uy.pencas.core.persistance.model.Organization
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbOrganization.add(dtOrganization);
		}
	}

	@WebMethod(operationName="updateOrganization")
	public void updateOrganization(@WebParam(name="user") String user,@WebParam(name="password") String password,@WebParam(name="dtOrganization") DTOrganization dtOrganization) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		if(userP.equals(user) && passP.equals(password)) {
			ejbOrganization.update(dtOrganization);
		}
	}
}
