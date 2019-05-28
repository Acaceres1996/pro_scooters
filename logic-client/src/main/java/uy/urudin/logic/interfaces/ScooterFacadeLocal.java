package uy.urudin.logic.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterScan;
import uy.urudin.datatypes.DTScooterUltimoRegistro;

@Local
public interface ScooterFacadeLocal {
	DTScooter add(DTScooter dtscooter);
	DTScooter update(DTScooter dtscooter);
	void delete(Integer id);
	DTScooter find(Integer id);
	List<DTScooter> findAll();
	public List<DTScooter> scootersLibres();
	public List<DTScooterUltimoRegistro> scootersUltimosRegistros();
	String scootersAlquilados() throws UnsupportedEncodingException, IOException;
	DTScooterScan findScooterScan(Integer id);
}
