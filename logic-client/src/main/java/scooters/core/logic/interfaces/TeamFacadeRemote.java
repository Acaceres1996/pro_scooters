package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTTeam;

@Remote
public interface TeamFacadeRemote {
	void add(DTTeam dtTeam);
	void update(DTTeam dtTeam);
	void delete(DTTeam dtTeam);
	DTTeam find(Integer id);
	List<DTTeam> findAll();
}
