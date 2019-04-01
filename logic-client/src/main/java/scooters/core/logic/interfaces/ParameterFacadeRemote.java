package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTParameter;

@Remote
public interface ParameterFacadeRemote {
	void add(DTParameter dtParameter);
	void update(DTParameter dtParameter);
	void delete(DTParameter dtParameter);
	DTParameter find(Integer id);
	List<DTParameter> findAll();
	String getValueByName(String Name);
}
