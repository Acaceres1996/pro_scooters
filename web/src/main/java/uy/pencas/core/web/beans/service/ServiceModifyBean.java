package uy.pencas.core.web.beans.service;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTService;
import uy.pencas.core.datatypes.enumerated.Type;
import uy.pencas.core.datatypes.enumerated.TypeService;
import uy.pencas.core.logic.interfaces.ServiceFacadeRemote;

@SessionScoped
@ManagedBean(name = "service_modify", eager = true)
public class ServiceModifyBean {

	@EJB
	ServiceFacadeRemote sEJB;	
		
	DTService s = new DTService();
	
	public ServiceModifyBean() {
		this.load();
	}
	
	public String modifyService() {
		sEJB.update(s);
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().remove("dtservice_mod");
		return "service_manage.xhtml?faces-redirect=true";
	}

	public Type[] getTypes(){
		return Type.values();
	}
	
	public TypeService[] getTypesService() {
		return TypeService.values();
	}
	
	public DTService getS() {
		return s;
	}

	public void setS(DTService s) {
		this.s = s;
	}
	
	public void load() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		if(  external.getSessionMap().containsKey("dtservice_mod") ) {
			System.out.println("Entre");
			s = (DTService) external.getSessionMap().get("dtservice_mod");
			System.out.println(s.getId());
		}else {
			System.out.println("Algo fallo, no lo logré cargar");
		}
		
	}
	
}
