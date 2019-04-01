package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTParameter;

@Local
public interface ParameterFacadeLocal {
	void add(DTParameter dtParameter);
	void update(DTParameter dtParameter);
	void delete(DTParameter dtParameter);
	DTParameter find(Integer id);
	List<DTParameter> findAll();
	String getValueByName(String Name);
}
