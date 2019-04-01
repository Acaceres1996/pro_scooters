package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;

@Local
public interface GlobalCompetitorFacadeLocal {
	void add(DTGlobalCompetitor dtGlobalCompetitor);
	void update(DTGlobalCompetitor dtGlobalCompetitor);
	void delete(DTGlobalCompetitor dtGlobalCompetitor);
	DTGlobalCompetitor find(Integer id,Integer idOrganization);
	List<DTGlobalCompetitor> findAll();
}
