package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTFactura;

@Local
public interface FacturaFacadeLocal {
	void add(DTFactura dtfactura);
	void update(DTFactura dtfactura);
	void delete(DTFactura dtfactura);
	DTFactura find(Integer id);
	List<DTFactura> findAll();
}
