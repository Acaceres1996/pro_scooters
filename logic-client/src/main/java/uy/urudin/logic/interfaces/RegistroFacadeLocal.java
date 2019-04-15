package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.datatypes.DTRegistro;

@Local
public interface RegistroFacadeLocal {
	void add(DTRegistro dtregistro);
	void update(DTRegistro dtregistro);
	void delete(DTRegistro dtregistro);
	DTRegistro find(Integer id);
	List<DTRegistro> findAll();
}
