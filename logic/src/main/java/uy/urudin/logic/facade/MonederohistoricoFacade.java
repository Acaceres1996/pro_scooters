
package uy.urudin.logic.facade;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.logic.interfaces.MonederohistoricoFacadeLocal;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.interfaces.MonederohistoricoDAOLocal;


/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class MonederohistoricoFacade implements  MonederohistoricoFacadeLocal {


	@EJB
	MonederohistoricoDAOLocal MonederohistoricoDAO;
	@EJB
	ClienteDAOLocal ClienteDAO;
	
    /**
     * Default constructor. 
     */
    public MonederohistoricoFacade() {
        
    }

	@Override
	public DTMonederohistorico add(DTMonederohistorico dtMonederohistorico) {
		//Registro el monedero
		dtMonederohistorico.setFecha(new Timestamp(System.currentTimeMillis()));
		DTCliente c = ClienteDAO.find(dtMonederohistorico.getDtcliente().getId());
		dtMonederohistorico.setSaldoanterior(c.getSaldo());
		dtMonederohistorico.setMotivo("Paypal");
		//Acredito al cliente
		c.setSaldo(c.getSaldo() + dtMonederohistorico.getMonto());
		dtMonederohistorico.setDtcliente(c);
		ClienteDAO.merge(c);
		
		return MonederohistoricoDAO.add(dtMonederohistorico);
	}

	@Override
	public List<DTMonederohistorico> findAll() {
		return MonederohistoricoDAO.findAll();
	}

	@Override
	public DTMonederohistorico find(Integer id) {
		return MonederohistoricoDAO.find(id);
	}

	@Override
	public List<DTMonederohistorico> findPagos() {
		List<DTMonederohistorico> pagos = MonederohistoricoDAO.findPagos();
		return pagos;
	}



}
