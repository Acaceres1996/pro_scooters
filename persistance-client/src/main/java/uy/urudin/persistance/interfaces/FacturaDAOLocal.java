package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTFactura;




@Local
public interface FacturaDAOLocal {
	public DTFactura add(DTFactura DTFactura);
	public void delete(Integer Id);
	public List<DTFactura> findAll();
}
