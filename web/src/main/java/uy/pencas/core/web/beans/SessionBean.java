package uy.pencas.core.web.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.logic.interfaces.ParameterFacadeLocal;

@ManagedBean(name = "sessionBean", eager = true)
public class SessionBean {

	public SessionBean() {
		// TODO Auto-generated constructor stub
	}
		
	@EJB
	ParameterFacadeLocal ejbPar;
	
	public String login(String user, String pwd) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		if( user.equals(userP) && pwd.equals(passP) ) {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext external = context.getExternalContext();
			external.getSessionMap().put("user", user);
			return "app/index.xhtml";
		}else {
			return "login.xhtml?faces-redirect=true&includeViewParams=true&err=1";
		}		
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().remove("user");
		return "login.xhtml";
	}

}
