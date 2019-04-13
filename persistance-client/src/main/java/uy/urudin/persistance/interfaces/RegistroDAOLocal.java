package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.datatypes.DTRegistro;




@Local
public interface RegistroDAOLocal {
	void add(DTRegistro dtregistro);
	void merge(DTRegistro dtregistro);
	void delete(DTRegistro dtregistro);
	DTRegistro find(Integer id);
	List<DTRegistro> findAll();
}
