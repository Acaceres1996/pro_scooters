package uy.pencas.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTMatch;

@Remote
public interface MatchFacadeRemote {
	void add(DTMatch dtMatch);
	void update(DTMatch dtMatch);
	void delete(DTMatch dtMatch);
	DTMatch find(Integer id);
	List<DTMatch> findAll();
}
