package uy.pencas.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTOrganization;

@Local
public interface OrganizationFacadeLocal {
	
	void add(DTOrganization dtOrganization);
	void update(DTOrganization dtOrganization);
	void delete(DTOrganization dtOrganization);
	DTOrganization find(Integer id);
	List<DTOrganization> findAll();
	List<DTOrganization> getPendingOrgs();
	void approveOrg(Integer Id);
}
