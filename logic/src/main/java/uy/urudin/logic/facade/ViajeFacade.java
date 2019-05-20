package uy.urudin.logic.facade;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTFactura;
import uy.urudin.datatypes.DTResumenViaje;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTViaje;
import uy.urudin.logic.interfaces.ViajeFacadeLocal;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.interfaces.FacturaDAOLocal;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;
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
	@EJB
	FacturaDAOLocal FacturaDAO;
	@EJB
	ParametroDAOLocal ParametroDAO;
	
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
	public DTViaje iniciarViaje(DTViaje v) {
		//Se controla que el cliente tenga saldo suficiente.
		DTCliente c = ClienteDAO.find(v.getCliente().getId());
		int minimoViaje = Integer.valueOf(ParametroDAO.getValueByName("MINIMOVIAJE"));
		if (c.getSaldo() >= minimoViaje) {
			
			//Se ocupa el scooter
			DTScooter s = ScooterDAO.find(v.getScooter().getId());
			s.setEnuso(true);
			ScooterDAO.merge(s);
			
			//Se calcula los minutos permitidos
			int precioMinuto = Integer.valueOf(ParametroDAO.getValueByName("PRECIOXMINUTO"));
			int minutosPermitidos = c.getSaldo() / precioMinuto;
			
			//Se genera el viaje
			v.setMinutospermitidossaldo(minutosPermitidos); 	
			v.setEstado("Iniciado");
			v.setFechainicio(new Timestamp(System.currentTimeMillis()));
			v.setCliente(c);
			v.setScooter(s);
			return ViajeDAO.add(v);
		} else {
			return new DTViaje();
		}
	}

	@Override
	public DTResumenViaje finalizarViaje(DTViaje v) {
		//Se termina el viaje.
		v.setFechafin(new Timestamp(System.currentTimeMillis()));
		v.setEstado("Terminado");
		
		//Se libera el scooter
		DTScooter s = ScooterDAO.find(v.getScooter().getId());
		s.setEnuso(false);
		ScooterDAO.merge(s);
		
		//Obtengo informacion para el resumen del viaje.
		DTResumenViaje resumen = new DTResumenViaje();
		int costoTotal = 0;
		int minutosTotal = 0;
		int costoBase = Integer.valueOf(ParametroDAO.getValueByName("TARIFABASE"));
		int costoMinuto = Integer.valueOf(ParametroDAO.getValueByName("PRECIOXMINUTO"));
		costoTotal = minutosTotal * costoMinuto;
		resumen.setCostoBase(costoBase);
		resumen.setCostoMinuto(costoMinuto);
		resumen.setCostoTotal(costoTotal);
		resumen.setCostoMinuto(minutosTotal);
		
		//Se le descuenta al cliente
		DTCliente c = ClienteDAO.find(v.getCliente().getId());
		c.setSaldo(c.getSaldo() - costoTotal);
		ClienteDAO.merge(c);
		
		//Se genera la factura
		DTFactura f = new DTFactura();
		f.setFecha(new Timestamp(System.currentTimeMillis()));
		f.setEstado("Pagado");
		f.setMonto(costoTotal);
		f.setViaje(v);
		FacturaDAO.add(f);
		v.setFactura(f);
		ViajeDAO.merge(v);
		
		return resumen;
	}

}
