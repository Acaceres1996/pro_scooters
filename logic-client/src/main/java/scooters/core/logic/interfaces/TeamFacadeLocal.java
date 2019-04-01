package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTTeam;

@Local
public interface TeamFacadeLocal {
	void add(DTTeam dtTeam);
	void update(DTTeam dtTeam);
	void delete(DTTeam dtTeam);
	DTTeam find(Integer id);
	List<DTTeam> findAll();
}
