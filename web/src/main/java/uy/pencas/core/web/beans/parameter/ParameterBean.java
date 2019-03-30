package uy.pencas.core.web.beans.parameter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTParameter;
import uy.pencas.core.logic.interfaces.ParameterFacadeRemote;

@RequestScoped
@ManagedBean(name = "parameterBean", eager = true)
public class ParameterBean {

	@EJB
	ParameterFacadeRemote parameterEJB;
		
	public ParameterBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<DTParameter> getParameters(){
		return parameterEJB.findAll();
	}
	


	public String goToModify(DTParameter p) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().put("dtparameter_mod", p );
		return ("parameter_modify.xhtml?faces-redirect=true");
	}
	


}
