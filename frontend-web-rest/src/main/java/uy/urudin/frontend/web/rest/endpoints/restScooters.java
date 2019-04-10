package uy.urudin.frontend.web.rest.endpoints;


import javax.ws.rs.Produces;

import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.datatypes.DTScooter;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;

//import uy.pencas.organization.logic.interfaces.ScooteroldFacadeLocal;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType; 

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
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createScooter(@QueryParam("name") String name, @QueryParam("value") String value){
//		DTScooter dtScooter = new DTScooter();
//		dtScooter.setName(name);
//		dtScooter.setValue(value);
//		ScooterEJB.add(dtScooter);
//		return Response.status(201).build();
//	}
//	
//	@PUT
//	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response updateScooter(@QueryParam("id") Integer id,@QueryParam("name") String name, @QueryParam("value") String value){
//		DTScooter dtScooter = new DTScooter();
//		dtScooter.setId(id);
//		dtScooter.setName(name);
//		dtScooter.setValue(value);
//		ScooterEJB.update(dtScooter);
//		return Response.status(200).build();
//	}
//	
//	@DELETE
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response deleteScooter(@PathParam("id") Integer id){
//		DTScooter dtScooter = ScooterEJB.find(id);
//		ScooterEJB.delete(dtScooter);
//		return Response.status(204).build();
//	}

	
	
}