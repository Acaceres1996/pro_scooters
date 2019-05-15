package uy.urudin.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTRegistro;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterhistorico;

@Local
public interface ScooterhistoricoFacadeLocal {
	public List<DTScooterhistorico> todoslosScootersHistoricoDisponibles();
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooter(Integer idscooter);
	public DTScooterhistorico find(Integer id);
	public DTScooterhistorico registroScooterHistorico(DTRegistro dtregistro);
}
