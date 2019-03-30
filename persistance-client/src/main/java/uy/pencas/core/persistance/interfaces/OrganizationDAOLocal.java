package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTOrganization;


@Local
public interface OrganizationDAOLocal {
	void add(DTOrganization dtOrganization);
	void merge(DTOrganization dtOrganization);
	List<DTOrganization> findAll();
	DTOrganization find(Integer id);
	void delete(DTOrganization dtOrganization);
}
