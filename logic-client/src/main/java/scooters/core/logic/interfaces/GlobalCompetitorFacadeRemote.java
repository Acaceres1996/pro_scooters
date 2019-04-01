package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTGlobalCompetitor;

@Remote
public interface GlobalCompetitorFacadeRemote {
	void add(DTGlobalCompetitor dtGlobalCompetitor);
	void update(DTGlobalCompetitor dtGlobalCompetitor);
	void delete(DTGlobalCompetitor dtGlobalCompetitor);
	DTGlobalCompetitor find(Integer id,Integer idOrganization);
	List<DTGlobalCompetitor> findAll();
}
