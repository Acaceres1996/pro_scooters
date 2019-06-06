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

import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTViaje;
import uy.urudin.datatypes.DTViajePagoDetallado;
import uy.urudin.logic.interfaces.ClienteFacadeLocal;
import uy.urudin.logic.interfaces.ViajeFacadeLocal;

/** https://api.urudin.tk/viaje/
 * 
 */
@Path("/viaje")
public class ViajeEndpoint {

	@EJB
	private ViajeFacadeLocal ViajeEJB;
	@EJB
	private ClienteFacadeLocal ClienteEJB;
	
	
	/** GET - https://api.urudin.tk/viaje/
	 * @return List(DTViaje) */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllViaje(){
		List<DTViajePagoDetallado> ListViajes = ViajeEJB.findAll();
		return Response.ok( ListViajes ).build();
	}
	
	@GET
	@Path("/usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetViajesByUser(@PathParam("id") Integer id) {
		List<DTViajePagoDetallado> ListViajes = ViajeEJB.findByUser(id);
		return Response.ok( ListViajes ).build();
	}
	
	/** POST - https://api.urudin.tk/viaje/
	 * @param DTViaje
	 * @return List<DTViaje> */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response iniciarViaje (DTViaje v){
		try {
			DTViaje nuevo = ViajeEJB.iniciarViaje(v);
			if(nuevo != null) {
				System.out.println("TOYEN1");
				return Response.status(200).entity( nuevo ).build();
			}else {
				System.out.println("TOYEN2");
				return Response.status(500).entity( nuevo ).build();
			}
		} catch (Exception e) {
			System.out.println("TOYEN3");
			return Response.status(500).entity( e ).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response finalizarViaje(DTViaje v){
		try {
			return Response.status(200).entity(ViajeEJB.finalizarViaje(v) ).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}

}