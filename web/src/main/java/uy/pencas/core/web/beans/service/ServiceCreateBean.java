package uy.pencas.core.web.beans.service;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import uy.pencas.core.datatypes.datatypes.DTService;
import uy.pencas.core.datatypes.enumerated.Type;
import uy.pencas.core.datatypes.enumerated.TypeService;
import uy.pencas.core.logic.interfaces.ServiceFacadeRemote;

@RequestScoped
@ManagedBean(name = "service_create", eager = true)
public class ServiceCreateBean {

	@EJB
	ServiceFacadeRemote sEJB;	
	
	DTService s = new DTService();
	
	public ServiceCreateBean() {
		
	}
	
	public String createService() {
		s.setEnabled(true);
		sEJB.add(s);
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
	
	
	
	
}
