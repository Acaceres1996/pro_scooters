package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTFactura;


@Local
public interface FacturaDAOLocal {
	void add(DTFactura dtfactura);
	void merge(DTFactura dtfactura);
	void delete(DTFactura dtfactura);
	DTFactura find(Integer id);
	List<DTFactura> findAll();
}
