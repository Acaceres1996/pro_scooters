package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.urudin.datatypes.datatypes.DTParametro;
import uy.urudin.datatypes.datatypes.DTCliente;

@Remote
public interface ClienteFacadeRemote {
	void add(DTCliente dtcliente);
	void update(DTCliente dtcliente);
	void delete(DTCliente dtcliente);
	DTCliente find(Integer id);
	List<DTCliente> findAll();
}
