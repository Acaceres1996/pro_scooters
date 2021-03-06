
package uy.urudin.logic.interfaces;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterUltimoRegistro;

@Local
public interface MonederohistoricoFacadeLocal {
	public DTCliente add(DTMonederohistorico dtMonederohistorico) throws Exception;
	public List<DTMonederohistorico> findAll();
	public DTMonederohistorico find(Integer id);
	public List<DTMonederohistorico> findPagos();
	public List<DTMonederohistorico> findPagosUsuario(Integer id);
}
