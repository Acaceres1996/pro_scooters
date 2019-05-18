package uy.urudin.api.rest.endpoints;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTViaje;
import uy.urudin.logic.interfaces.ViajeFacadeLocal;

/** https://api.urudin.tk/viaje/
 * 
 */
@Path("/viaje")
public class ViajeEndpoint {

	@EJB
	private ViajeFacadeLocal ViajeEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	/** GET - https://api.urudin.tk/viaje/
	 * @return List(DTViaje) */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllViaje(){
		List<DTViaje> ListViajes = ViajeEJB.findAll();
		return Response.ok( ListViajes ).build();
	}
	
	
	/** POST - https://api.urudin.tk/viaje/
	 * @param DTViaje
	 * @return List<DTViaje> */
	
	//El Cliente debe tener un saldo mínimo en su monedero para iniciar viaje.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createViaje (DTViaje v){
		try {
			return Response.status(200).entity( ViajeEJB.add(v) ).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateViaje(DTViaje v){
		try {
			return Response.status(200).entity( ViajeEJB.update(v) ).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//Se setearia la fecha de fin,y se cambiaria el estado.
	public Response finalizarViaje(DTViaje v){
		try {
			return Response.status(200).entity( ViajeEJB.update(v) ).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
}