package uy.pencas.core.web.beans.service;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTService;
import uy.pencas.core.logic.interfaces.ServiceFacadeRemote;

@ManagedBean(name = "service", eager = true)
public class serviceBean {

	@EJB
	ServiceFacadeRemote sEJB;
	
	public serviceBean() {
		// TODO Auto-generated constructor stub
	}

	public List<DTService> getServices(){
		return sEJB.findEnabled();
	}
	
	public String goToModify(DTService s) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().put("dtservice_mod", s);
		return ("service_modify.xhtml?faces-redirect=true");
	}
	
	public String disableService(DTService s) {
		s.setEnabled(false);
		sEJB.update(s);
		return "service_manage.xhtml?faces-redirect=true";
	}
}
