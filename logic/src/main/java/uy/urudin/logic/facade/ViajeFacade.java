package uy.urudin.logic.facade;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTResumenViaje;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTViaje;
import uy.urudin.logic.interfaces.ViajeFacadeLocal;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.interfaces.ViajeDAOLocal;



/**
 * Session Bean implementation class ViajeFacade
 */
@Stateless
@LocalBean
public class ViajeFacade implements  ViajeFacadeLocal {


	@EJB
	ViajeDAOLocal ViajeDAO;
	@EJB
	ClienteDAOLocal ClienteDAO;
	@EJB
	ScooterDAOLocal ScooterDAO;
	//@EJB
	//FacturaDAOLocal FacturaDAO;
	
    /**
     * Default constructor. 
     */
    public ViajeFacade() {
        
    }

	@Override
	public DTViaje add(DTViaje dtViaje) {
		try {
			return ViajeDAO.add(dtViaje);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public DTViaje update(DTViaje dtViaje) {
		return ViajeDAO.merge(dtViaje);
	}

	@Override
	public DTViaje find(Integer id) {
		return ViajeDAO.find(id);
	}

	@Override
	public List<DTViaje> findAll() {
		return ViajeDAO.findAll();
	}
	
	@Override
	public DTViaje iniciarViaje(DTCliente c, int idS) {
		//Se controla que el cliente tenga saldo suficiente.
		
		//Se ocupa el scooter
		DTScooter s = ScooterDAO.find(idS);
		s.setEnuso(true);
		ScooterDAO.merge(s);
		//Se genera el viaje
		DTViaje v = new DTViaje();
		v.setFechainicio(new Timestamp(System.currentTimeMillis()));
		v.setCliente(c);
		v.setScooter(s);
		return ViajeDAO.add(v);
	}

	@Override
	public DTResumenViaje finalizarViaje(DTViaje v) {
		v.setFechafin(new Timestamp(System.currentTimeMillis()));
		//Se libera el scooter
		DTScooter s = ScooterDAO.find(v.getScooter().getId());
		s.setEnuso(false);
		ScooterDAO.merge(s);
		//Calcula el costo del viaje
		int costo = 0;
		//Se le descuenta al cliente
		DTCliente c = ClienteDAO.find(v.getCliente().getId());
		c.setSaldo(c.getSaldo() - costo);
		ClienteDAO.merge(c);
		//Se genera la factura
		
		//v.setFactura(factura);
		//Se termina el viaje.
		v.setEstado("Terminado");
		ViajeDAO.merge(v);
		return new DTResumenViaje();
	}

}
