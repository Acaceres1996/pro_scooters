package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTMatch;



@Local
public interface MatchDAOLocal {
	void add(DTMatch dtMatch);
	void merge(DTMatch dtMatch);
	void delete(DTMatch dtMatch);
	DTMatch find(Integer id);
	List<DTMatch> findAll();
	
}
