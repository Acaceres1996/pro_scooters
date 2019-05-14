package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTFactura;

@Remote
public interface FacturaFacadeRemote {
	void add(DTFactura dtfactura);
	void update(DTFactura dtfactura);
	void delete(DTFactura dtfactura);
	DTFactura find(Integer id);
	List<DTFactura> findAll();
}
