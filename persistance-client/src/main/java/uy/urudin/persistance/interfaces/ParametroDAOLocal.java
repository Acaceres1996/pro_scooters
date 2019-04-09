package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.datatypes.DTParametro;




@Local
public interface ParametroDAOLocal {
	void add(DTParametro dtParameter);
	void merge(DTParametro dtParameter);
	void delete(DTParametro dtParameter);
	DTParametro find(Integer id);
	List<DTParametro> findAll();
	String getValueByName(String Name);
	DTParametro getDTParameterByName(String Name);
}
