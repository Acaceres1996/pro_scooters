package uy.pencas.core.web.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import uy.pencas.core.datatypes.datatypes.DTOrganization;
import uy.pencas.core.logic.interfaces.OrganizationFacadeRemote;

@ManagedBean(name = "orgBean", eager = true)
public class OrgBean {

	@EJB
	OrganizationFacadeRemote orgEJB;
	
	public OrgBean() {
		// TODO Auto-generated constructor stub
	}

	public List<DTOrganization> getPendingOrgs(){
		List<DTOrganization> pending = orgEJB.getPendingOrgs();
		//TODO Test
		//List<DTOrganization> pending = orgEJB.findAll();
		return pending;
	}
	
	public String approveOrg(Integer id) {
		orgEJB.approveOrg( id);
		return "org_approval.xhtml?faces-redirect=true&includeViewParams=true";
	}
}
