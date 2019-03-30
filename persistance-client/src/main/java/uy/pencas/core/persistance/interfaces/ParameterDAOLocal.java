package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTParameter;



@Local
public interface ParameterDAOLocal {
	void add(DTParameter dtParameter);
	void merge(DTParameter dtParameter);
	void delete(DTParameter dtParameter);
	DTParameter find(Integer id);
	List<DTParameter> findAll();
	String getValueByName(String Name);
	
	
}
