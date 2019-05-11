package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.urudin.datatypes.DTAdmin;

@Remote
public interface AdminFacadeRemote {
	void add(DTAdmin dtadmin);
	void update(DTAdmin dtadmin);
	void delete(DTAdmin dtadmin);
	DTAdmin find(Integer id);
	List<DTAdmin> findAll();
}
