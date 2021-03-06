package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.datatypes.DTFactura;
import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.datatypes.DTResumenViaje;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterUltimoRegistro;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.datatypes.DTViaje;
import uy.urudin.datatypes.DTViajePagoDetallado;
import uy.urudin.logic.interfaces.ViajeFacadeLocal;
import uy.urudin.persistance.interfaces.ClienteDAOLocal;
import uy.urudin.persistance.interfaces.FacturaDAOLocal;
import uy.urudin.persistance.interfaces.MonederohistoricoDAOLocal;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.interfaces.ScooterhistoricoDAOLocal;
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
	@EJB
	MonederohistoricoDAOLocal MonederohistoricoDAO;
	@EJB
	ScooterhistoricoDAOLocal ScooterhistoricoDAO;
	
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
	//REVISAR!!! da mal la duracion y el costo total, fecha inicio fin da 2 minutos cuando se cobraron 1
	public List<DTViajePagoDetallado> findAll() {
		List<DTViaje> viajes = ViajeDAO.findAll();
		List<DTViajePagoDetallado> detalle = new ArrayList<DTViajePagoDetallado>(); 
		
		for (DTViaje v : viajes) {
			double monto = 0;
			int duracion = 0;
			
			if (v.getEstado().equals("Finalizado")) {
				monto = FacturaDAO.findByViaje(v.getId()).getMonto();
				duracion = duracionViaje(v);
			}
			
			DTViajePagoDetallado d = new DTViajePagoDetallado 
			(v.getId(),v.getFechainicio(),v.getFechafin(),v.getCliente().getEmail(),
			v.getScooter().getNumeroserial(),duracion,monto,v.getEstado());
			detalle.add(d);
		}
		return detalle;
	}
	
	@Override
	//REVISAR!!! da mal la duracion y el costo total, fecha inicio fin da 2 minutos cuando se cobraron 1
	public List<DTViajePagoDetallado> findByUser(int id) {
		List<DTViaje> viajes = ViajeDAO.findByUser(id);
		List<DTViajePagoDetallado> detalle = new ArrayList<DTViajePagoDetallado>(); 
		
		for (DTViaje v : viajes) {
			double monto = 0;
			int duracion = 0;
			if (v.getEstado().equals("Finalizado")) {
				monto = FacturaDAO.findByViaje(v.getId()).getMonto();
				duracion = duracionViaje(v);
			}
			DTViajePagoDetallado d = new DTViajePagoDetallado 
			(v.getId(),v.getFechainicio(),v.getFechafin(),v.getCliente().getEmail(),
			v.getScooter().getNumeroserial(),duracion,monto,v.getEstado());
			detalle.add(d);
		}
		return detalle;
	}
	
	//PROBAR EL CONTROL DE BATERIA
	@Override
	public DTViaje iniciarViaje(DTViaje v) throws Exception {
		
	    try{
			//Se controla que el scooter tenga bateria suficiente
			int batscooter = Integer.valueOf(ParametroDAO.getDTParameterByName("BATERIABAJA").getValor());
			DTScooterhistorico sh = ScooterhistoricoDAO.ultimoScooterHistoricoUnIdScooter(v.getScooter().getId());
			DTScooter dtscooter = ScooterDAO.find(v.getScooter().getId());
			
			//verifico se encuentre encendido
			if (sh != null && dtscooter.isEncendido() && !dtscooter.isEnuso() ) { 
				if (sh.getBateria() > batscooter) {
					//Se controla que el cliente tenga saldo suficiente.
					DTCliente c = ClienteDAO.find(v.getCliente().getId());
					int minimoViaje = Integer.valueOf(ParametroDAO.getDTParameterByName("MINIMOVIAJE").getValor());
					if (c.getSaldo() >= minimoViaje) {
						
						//Se ocupa el scooter
						DTScooter s = ScooterDAO.find(v.getScooter().getId());
						s.setEnuso(true); 
						ScooterDAO.merge(s);
						
						//Se calcula los minutos permitidos
						int precioMinuto = Integer.valueOf(ParametroDAO.getDTParameterByName("PRECIOXMINUTO").getValor());
						int minutosPermitidos = c.getSaldo() / precioMinuto;
						
						//Se genera el viaje
						v.setMinutospermitidossaldo(minutosPermitidos); 	
						v.setEstado("Iniciado");
						v.setFechainicio(new Timestamp(System.currentTimeMillis()));
						v.setCliente(c);
						v.setScooter(s);
						return ViajeDAO.add(v);
					} else {
			            throw new Exception("Saldo minimo del cliente insuficiente [minimo:"+ minimoViaje+ "]"); 
					}
				} else {
		            throw new Exception("Bateria del scooter insuficiente [mayor a:"+ batscooter+ "]"); 
				}
			} else {
	            throw new Exception("Scooter apagado o en uso");
			}
	    }catch(Exception e){
	    	throw  e;
	    }
	}

	@Override
	public DTResumenViaje finalizarViaje(DTViaje v) throws Exception {
		DTResumenViaje resumen = new DTResumenViaje();
			//Se termina el viaje.
			v.setFechafin(new Timestamp(System.currentTimeMillis()));
			v.setEstado("Finalizado");
			
			System.out.println("v.getScooter().getId():"+v.getScooter().getId());
			
			//Se libera el scooter
			DTScooter s = ScooterDAO.find(v.getScooter().getId());
			s.setEnuso(false);
			ScooterDAO.merge(s);
			
			//Obtengo informacion para el resumen del viaje.
			
			int costoTotal = 0;
			
			//Calculo minutos del viaje.
			
            int minutosTotal = duracionViaje(v);
			
			int costoBase = Integer.valueOf(ParametroDAO.getDTParameterByName("TARIFABASE").getValor());
			int costoMinuto = Integer.valueOf(ParametroDAO.getDTParameterByName("PRECIOXMINUTO").getValor());
			
			costoTotal =  costoBase + (minutosTotal * costoMinuto);
			resumen.setCostoBase(costoBase);
			resumen.setCostoMinuto(costoMinuto);
			resumen.setCostoTotal(costoTotal);
			resumen.setMinutos(minutosTotal);
			
			DTCliente c = ClienteDAO.find(v.getCliente().getId());
			
			//REGISTRO EN MONEDERO HISTORICO
			DTMonederohistorico dtMonederohistorico = new DTMonederohistorico ();
			dtMonederohistorico.setFecha(new Timestamp(System.currentTimeMillis()));
			dtMonederohistorico.setSaldoanterior(c.getSaldo());
			dtMonederohistorico.setMotivo("Viaje");
			dtMonederohistorico.setMonto(costoTotal);
			dtMonederohistorico.setDtcliente(c);
			MonederohistoricoDAO.add(dtMonederohistorico);
			
			//Se le descuenta al cliente
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
	
	@Override
	public int duracionViaje(DTViaje v) {
		int minutosTotal = 0;
		try {
			long milis1, milis2, diff;
			Date dinicio = null, dfinal = null;
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ffin  = sdf.format(v.getFechainicio());
			String fini  = sdf.format(v.getFechafin());
			dinicio = sdf.parse(ffin);
			dfinal = sdf.parse(fini);
			Calendar cinicio = Calendar.getInstance();
	        Calendar cfinal = Calendar.getInstance();
	        cinicio.setTime(dinicio);
	        cfinal.setTime(dfinal);
	        milis1 = cinicio.getTimeInMillis();
	        milis2 = cfinal.getTimeInMillis();
	        diff = milis2-milis1;
	        long diffMinutos =  Math.abs (diff / (60 * 1000));
	        minutosTotal = (int) diffMinutos%60;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return minutosTotal;
	}

	@Override
	public DTViaje buscarIniciadoPorScooter(int idScooter) {
		return ViajeDAO.buscarIniciadoPorScooter(idScooter);
	}
	
}


