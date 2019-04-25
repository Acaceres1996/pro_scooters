package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTCliente;




@Local
public interface ClienteDAOLocal {
	void add(DTCliente dtcliente);
	void merge(DTCliente dtcliente);
	void delete(DTCliente dtcliente);
	DTCliente find(Integer id);
	List<DTCliente> findAll();
}
