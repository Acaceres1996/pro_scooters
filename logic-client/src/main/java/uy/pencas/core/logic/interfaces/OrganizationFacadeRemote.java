package uy.pencas.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTOrganization;

@Remote
public interface OrganizationFacadeRemote {
	
	void add(DTOrganization dtOrganization);
	void update(DTOrganization dtOrganization);
	void delete(DTOrganization dtOrganization);
	DTOrganization find(Integer id);
	List<DTOrganization> findAll();
	List<DTOrganization> getPendingOrgs();
	void approveOrg(Integer id);
}
