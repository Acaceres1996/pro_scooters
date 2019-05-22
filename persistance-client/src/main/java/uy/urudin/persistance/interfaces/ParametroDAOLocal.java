package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTParametro;
import uy.urudin.datatypes.DTScooter;




@Local
public interface ParametroDAOLocal {
	DTParametro add(DTParametro dtParameter);
	DTParametro merge(DTParametro dtParameter);
	void delete(DTParametro dtParameter);
	DTParametro find(Integer id);
	List<DTParametro> findAll();
	String getValueByName(String Name);
	DTParametro getDTParameterByName(String Name);
}
