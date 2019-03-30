package uy.pencas.core.web.beans.parameter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTParameter;
import uy.pencas.core.logic.interfaces.ParameterFacadeRemote;

@ManagedBean(name = "parameter_modify", eager = true)
public class ParameterModifyBean {

	@EJB
	ParameterFacadeRemote parameterEJB;
	
	DTParameter p = new DTParameter();
	
	public ParameterModifyBean() {
		this.load();
	}
	
	public String modifyParameter() {
		parameterEJB.update(p);				
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().remove("dtparameter_mod");
		return "parameter_manage.xhtml?faces-redirect=true";
	}	
	
	public DTParameter getP() {
		return p;
	}

	public void setP(DTParameter p) {
		this.p = p;
	}

	
	public void load() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		if(  external.getSessionMap().containsKey("dtparameter_mod") ) {
			System.out.println("Entre Parameter");
			p = (DTParameter) external.getSessionMap().get("dtparameter_mod");
			System.out.println(p.getId());
		}else {
			System.out.println("Algo fallo, no lo logré cargar Parameter");
		}
	}
}
