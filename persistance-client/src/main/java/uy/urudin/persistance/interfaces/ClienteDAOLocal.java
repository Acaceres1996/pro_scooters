package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTCliente;




@Local
public interface ClienteDAOLocal {
	public DTCliente add(DTCliente dtcliente);
	public DTCliente merge(DTCliente dtcliente);
	public List<DTCliente> findAll();
	public DTCliente find(Integer id);
	public DTCliente find(String email);
}
