package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.datatypes.DTCliente;

@Local
public interface ClienteFacadeLocal {
	void add(DTCliente dtcliente);
	void update(DTCliente dtcliente);
	void delete(DTCliente dtcliente);
	DTCliente find(Integer id);
	List<DTCliente> findAll();
}
