package uy.urudin.api.rest.endpoints;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTNotificacion;
import uy.urudin.logic.interfaces.NotificacionFacadeLocal; 

@Path("/notificacion")
public class NotificacionEndpoint {

	@EJB
	private NotificacionFacadeLocal NotificacionEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllNotificacion(){
		List<DTNotificacion> ListNotificaciones = NotificacionEJB.obtenerNotificacionesEnviadas();
		return Response.ok( ListNotificaciones ).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNotificacion(DTNotificacion dtNotificacion){
		try {
			return Response.status(200).entity(NotificacionEJB.add(dtNotificacion)).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/marcarleida")
	@Produces(MediaType.APPLICATION_JSON)
	public Response marcarleida(@QueryParam("idnotificacion") Integer idnotificacion,@QueryParam("idcliente") Integer idcliente){
		return Response.ok( NotificacionEJB.marcarLeidaNotificacion(idnotificacion,idcliente) ).build();
	}
	

	@GET
	@Path("/noleidas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerNoleidasCliente(@QueryParam("idcliente") Integer idcliente){
		return Response.ok( NotificacionEJB.obtenerTodaslasNotificacionesNoleidasdeCliente(idcliente) ).build();
	}
	

	
}