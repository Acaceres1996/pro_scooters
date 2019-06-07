package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTParametro;
import uy.urudin.datatypes.DTScooter;

@Local
public interface ClienteFacadeLocal {
	public DTCliente add(DTCliente dtcliente) throws Exception;
	public DTCliente update(DTCliente dtcliente) throws Exception;
	public List<DTCliente> findAll();
	public DTCliente find(Integer id);
	public DTCliente find(String email) throws Exception;
}