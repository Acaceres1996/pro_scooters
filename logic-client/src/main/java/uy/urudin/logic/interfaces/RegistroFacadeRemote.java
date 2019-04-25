package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.urudin.datatypes.DTRegistro;

@Remote
public interface RegistroFacadeRemote {
	void add(DTRegistro dtregistro);
	void update(DTRegistro dtregistro);
	void delete(DTRegistro dtregistro);
	DTRegistro find(Integer id);
	List<DTRegistro> findAll();
}
