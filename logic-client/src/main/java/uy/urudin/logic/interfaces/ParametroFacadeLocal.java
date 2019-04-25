package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTParametro;

@Local
public interface ParametroFacadeLocal {
	void add(DTParametro dtParameter);
	void update(DTParametro dtParameter);
	void delete(DTParametro dtParameter);
	DTParametro find(Integer id);
	List<DTParametro> findAll();
	String getValueByName(String Name);
	DTParametro getDTParameterByName(String Name);
}
