    
package uy.urudin.persistance.interfaces;

import java.util.List;
import javax.ejb.Local;
import uy.urudin.datatypes.DTMonederohistorico;




@Local
public interface MonederohistoricoDAOLocal {
	public DTMonederohistorico add(DTMonederohistorico dtMonederohistorico);
	public List<DTMonederohistorico> findAll();
	public DTMonederohistorico find(Integer id);
	public void delete(Integer Id);
	public List<DTMonederohistorico> findPagos();
}
