package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;




@Local
public interface AdminDAOLocal {
	void add(DTAdmin dtadmin);
	void merge(DTAdmin dtadmin);
	void delete(DTAdmin dtadmin);
	DTAdmin find(Integer id);
	List<DTAdmin> findAll();
}
