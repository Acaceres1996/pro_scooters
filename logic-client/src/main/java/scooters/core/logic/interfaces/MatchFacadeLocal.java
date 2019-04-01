package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTMatch;

@Local
public interface MatchFacadeLocal {
	void add(DTMatch dtMatch);
	void update(DTMatch dtMatch);
	void delete(DTMatch dtMatch);
	DTMatch find(Integer id);
	List<DTMatch> findAll();
}
