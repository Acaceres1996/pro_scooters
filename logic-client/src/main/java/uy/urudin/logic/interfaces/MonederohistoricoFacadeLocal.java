package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.datatypes.DTParametro;
import uy.urudin.datatypes.DTScooter;

@Local
public interface MonederohistoricoFacadeLocal {
	public DTMonederohistorico add(DTMonederohistorico dtMonederohistorico);
	public List<DTMonederohistorico> findAll();
}