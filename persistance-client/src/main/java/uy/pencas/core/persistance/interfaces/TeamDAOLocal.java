package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTTeam;



@Local
public interface TeamDAOLocal {
	void add(DTTeam dtTeam);
	void merge(DTTeam dtTeam);
	void delete(DTTeam dtTeam);
	DTTeam find(Integer id);
	List<DTTeam> findAll();
	
}
