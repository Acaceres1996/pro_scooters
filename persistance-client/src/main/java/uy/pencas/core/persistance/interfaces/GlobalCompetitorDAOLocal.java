package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;



@Local
public interface GlobalCompetitorDAOLocal {
	void add(DTGlobalCompetitor dtGlobalCompetitor);
	void merge(DTGlobalCompetitor dtGlobalCompetitor);
	void delete(DTGlobalCompetitor dtGlobalCompetitor);
	DTGlobalCompetitor find(Integer id, Integer idOrganization);
	List<DTGlobalCompetitor> findAll();
	
}
