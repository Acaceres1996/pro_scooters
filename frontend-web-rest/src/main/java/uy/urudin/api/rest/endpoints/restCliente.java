package uy.urudin.api.rest.endpoints;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

//import uy.pencas.organization.logic.interfaces.ClienteoldFacadeLocal;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.logic.interfaces.ClienteFacadeLocal;

@Path("/cliente")
public class restCliente {

	@EJB
	private ClienteFacadeLocal ClienteEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllCliente(){
		List<DTCliente> ListClientes = ClienteEJB.findAll();
		return Response.ok( ListClientes ).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneCliente(@PathParam("id") Integer id){
		return Response.ok( ClienteEJB.find(id)  ).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCliente(
//			@QueryParam("id") int id, 
			@QueryParam("email") String email
			){

		DTCliente dtCliente = new DTCliente();
//		dtCliente.setId(id); //el id no se envia al crear.
		dtCliente.setEmail(email);
		try {
			ClienteEJB.add(dtCliente);
			return Response.status(201).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
//	@PUT
//	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response updateCliente(			
//			@QueryParam("id") int id, 
//			@QueryParam("idcliente") int idcliente,
//			@QueryParam("idscooter") int idscooter
//			){
//		DTCliente cliente = ClienteEJB.find(idcliente);
//		DTScooter scooter = ScooterEJB.find(idscooter);
//		
//		DTCliente dtCliente = ClienteEJB.find(id);
//		dtCliente.setCliente(cliente);
//		dtCliente.setScooter(scooter);
//		
//		try {
//			ClienteEJB.update(dtCliente);
//			return Response.status(200).build();
//		}catch (Exception e) {
//			return Response.status(500).build();
//		}
//	}
//	
	//setea encendido en false, no elimina fisicamente.
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCliente(@PathParam("id") int id){
		DTCliente dtCliente = ClienteEJB.find(id);
		try {
			ClienteEJB.delete(dtCliente);
			return Response.status(204).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
}