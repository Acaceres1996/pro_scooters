package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTService;



@Local
public interface ServiceDAOLocal {
	void add(DTService dtService);
	void merge(DTService dtService);
	void delete(DTService dtService);
	DTService find(Integer id);
	List<DTService> findAll();
	
}
