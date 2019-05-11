package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;

@Local
public interface AdminFacadeLocal {
	void add(DTAdmin dtadmin);
	void update(DTAdmin dtadmin);
	void delete(DTAdmin dtadmin);
	DTAdmin find(Integer id);
	List<DTAdmin> findAll();
}
