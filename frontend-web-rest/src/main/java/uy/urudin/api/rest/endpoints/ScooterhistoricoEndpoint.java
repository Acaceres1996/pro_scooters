package uy.urudin.api.rest.endpoints;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTRegistro;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.logic.interfaces.ScooterhistoricoFacadeLocal; 

/** https://api.urudin.tk/scooter/
 * 
 * @Author Martin Olivera 
 */
@Path("/scooterhistorico")
public class ScooterhistoricoEndpoint {

	@EJB
	private ScooterhistoricoFacadeLocal ScooterhistoricoEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	/** GET - https://api.urudin.tk/scooter/
	 * @return List<DTScooterhistorico */
	@GET
	@Path("/disponibles/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response todoslosScootersHistoricoDisponibles(){
		List<DTScooterhistorico> all = ScooterhistoricoEJB.todoslosScootersHistoricoDisponibles();
		return Response.ok( all ).build();
	}
	
	/** GET - https://api.urudin.tk/scooter/
	 * @return List<DTScooterhistorico */
	@GET
	@Path("/apagadosbateriabaja/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response todoslosScootersHistoricoApagadosoBateriaBaja(){
		List<DTScooterhistorico> all = ScooterhistoricoEJB.todoslosScootersHistoricoApagadosoBateriaBaja();
		return Response.ok( all ).build();
	}
	
	
	
	@POST
	@Path("/cercanos/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response todoslosScootersHistoricoDisponibles(DTRegistro dtregistro){
		List<DTScooterhistorico> all = ScooterhistoricoEJB.todoslosScootersHistoricoCercanos(dtregistro.getLatitud(), dtregistro.getLongitud());
		return Response.ok( all ).build();
	}
	
	@POST
	@Path("/registro/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registroScooterHistorico(DTRegistro dtregistro){
		try {
			return Response.status(200).entity( ScooterhistoricoEJB.registroScooterHistorico(dtregistro) ).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

//	@GET
//	@Path("/{idscooter}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response find(@PathParam("idscooter") Integer idscooter){
//		return Response.ok( ScooterhistoricoEJB.find(idscooter)  ).build();
//	}
	
	@GET
	@Path("/{idscooter}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ultimoScooterHistoricoUnIdScooter(@PathParam("idscooter") Integer idscooter){
		return Response.ok( ScooterhistoricoEJB.ultimoScooterHistoricoUnIdScooter(idscooter)  ).build();
	}

	
}