package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTCompetition;



@Local
public interface CompetitionDAOLocal {
	void add(DTCompetition dtCompetition);
	void merge(DTCompetition dtCompetition);
	void delete(DTCompetition dtCompetition);
	DTCompetition find(Integer id);
	List<DTCompetition> findAll();
	
}
