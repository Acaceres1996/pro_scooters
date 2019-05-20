package uy.urudin.api.rest.endpoints;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.logic.interfaces.MonederohistoricoFacadeLocal;

/** https://api.urudin.tk/admin/
 * 
 * @Author Agustin Caceres 
 */
@Path("/monedero")
public class MonederohistoricoEndpoint {
	
	@EJB
	private MonederohistoricoFacadeLocal MonederoEJB;
	
	
	
	/** POST - https://api.urudin.tk/admin/login - FALTA CONECTAR A BASE
	 * @param DTAdmin
	 * @return DTAdmin */
	@POST
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	//FALTA PAYPAL
	public Response cargarMonedero(DTMonederohistorico monedero) {	
		try {
			DTMonederohistorico newMonedero=MonederoEJB.add(monedero);
			//solo si es true respondo.
			if(newMonedero != null) {
				return Response.status(200).entity( newMonedero ).build();
			}else {
				return Response.status(500).build();
			}
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllHistorico(){
		List<DTMonederohistorico> ListHistorico = MonederoEJB.findAll();
		return Response.ok( ListHistorico ).build();
	}
	
	
}