package uy.pencas.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTService;

@Remote
public interface ServiceFacadeRemote {
	void add(DTService dtService);
	void update(DTService dtService);
	void delete(DTService dtService);
	DTService find(Integer id);
	List<DTService> findAll();
	List<DTService> findEnabled();
}
