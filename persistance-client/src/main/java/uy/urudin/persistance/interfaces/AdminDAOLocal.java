package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;




@Local
public interface AdminDAOLocal {
	public DTAdmin add(DTAdmin dtAdmin);
	public void delete(Integer Id);
	public List<DTAdmin> findAll();
}
