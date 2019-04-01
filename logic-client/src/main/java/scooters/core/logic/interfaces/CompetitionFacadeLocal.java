package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTCompetition;

@Remote
public interface CompetitionFacadeLocal {
	void add(DTCompetition dtCompetition);
	void update(DTCompetition dtCompetition);
	void delete(DTCompetition dtCompetition);
	DTCompetition find(Integer id);
	List<DTCompetition> findAll();
}
