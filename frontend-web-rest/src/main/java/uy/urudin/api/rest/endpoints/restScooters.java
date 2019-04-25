package uy.urudin.api.rest.endpoints;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

//import uy.pencas.organization.logic.interfaces.ScooteroldFacadeLocal;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.logic.interfaces.ScooterFacadeLocal; 

@Path("/scooter")
public class restScooters {

	@EJB
	private ScooterFacadeLocal ScooterEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllScooter(){
		List<DTScooter> ListScooters = ScooterEJB.findAll();
		return Response.ok( ListScooters ).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneScooter(@PathParam("id") Integer id){
		return Response.ok( ScooterEJB.find(id)  ).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createScooter(
//			@QueryParam("id") int id, 
			@QueryParam("latitud") String latitud,
			@QueryParam("longitud") String longitud,
			@QueryParam("bateria") Integer bateria,
			@QueryParam("encendido") boolean encendido
			){
		DTScooter dtScooter = new DTScooter();
//		dtScooter.setId(id); //el id no se envia al crear.
		dtScooter.setLatitud(latitud);
		dtScooter.setLongitud(longitud);
		dtScooter.setBateria(bateria);
		dtScooter.setEncendido(encendido);
		try {
			ScooterEJB.add(dtScooter);
			return Response.status(201).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateScooter(			
			@QueryParam("id") int id, 
			@QueryParam("latitud") String latitud,
			@QueryParam("longitud") String longitud,
			@QueryParam("bateria") Integer bateria,
			@QueryParam("encendido") boolean encendido
			){
		DTScooter dtScooter = new DTScooter();
		dtScooter.setId(id);
		dtScooter.setLatitud(latitud);
		dtScooter.setLongitud(longitud);
		dtScooter.setBateria(bateria);
		dtScooter.setEncendido(encendido);
		try {
			ScooterEJB.update(dtScooter);
			return Response.status(200).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	//setea encendido en false, no elimina fisicamente.
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteScooter(@PathParam("id") int id){
		DTScooter dtScooter = ScooterEJB.find(id);
		try {
			ScooterEJB.delete(dtScooter);
			return Response.status(204).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
}