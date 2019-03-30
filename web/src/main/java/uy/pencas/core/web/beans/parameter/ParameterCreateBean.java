package uy.pencas.core.web.beans.parameter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import uy.pencas.core.datatypes.datatypes.DTParameter;
import uy.pencas.core.logic.interfaces.ParameterFacadeRemote;

@RequestScoped
@ManagedBean(name = "parameter_create", eager = true)
public class ParameterCreateBean {

	@EJB
	ParameterFacadeRemote parameterEJB;
	
	DTParameter p = new DTParameter();
	
	public ParameterCreateBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String createParameter() {

		parameterEJB.add(p);
		return "parameter_manage.xhtml?faces-redirect=true";
	}
	

	public DTParameter getP() {
		return p;
	}

	public void setP(DTParameter p) {
		this.p = p;
	}
	
	
	
}
