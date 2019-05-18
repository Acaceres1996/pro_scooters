package uy.urudin.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTScooterhistorico;




@Local
public interface ScooterhistoricoDAOLocal {
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooter(Integer idscooter);
	public DTScooterhistorico ultimoScooterHistoricoUnIdScooterBasico(Integer idscooter);
	public DTScooterhistorico find(Integer id);
	public DTScooterhistorico add(DTScooterhistorico dtscooterhistorico);
}
