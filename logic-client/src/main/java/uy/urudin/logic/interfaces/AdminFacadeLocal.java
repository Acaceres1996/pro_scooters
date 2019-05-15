package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTParametro;
import uy.urudin.datatypes.DTScooter;

@Local
public interface AdminFacadeLocal {
	public DTAdmin add(DTAdmin dtAdmin);
	public void delete(Integer Id);
	public List<DTAdmin> findAll();
	public boolean login(DTAdmin dtAdmin);
}