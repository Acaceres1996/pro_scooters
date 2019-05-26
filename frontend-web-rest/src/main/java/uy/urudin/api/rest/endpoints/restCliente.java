package uy.urudin.api.rest.endpoints;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

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
	
	@GET
	@Path("/login/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginCliente(@QueryParam("email") String email) {
//System.out.println("DEBUGDEBUGDEBUG:" + email + ";");
		return Response.ok( ClienteEJB.find(email)  ).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCliente(DTCliente dtcliente){
			try {
				DTCliente newdt = ClienteEJB.add(dtcliente);
				if(newdt != null) {
					return Response.status(200).entity(newdt).build();
				}else{
					return Response.status(500).build();
				}
			}catch (Exception e) {
				return Response.status(500).entity(e).build();
			}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCliente(DTCliente dtcliente){
			try {
				DTCliente upddt = ClienteEJB.update(dtcliente);
				if(upddt != null) {
					return Response.status(200).entity(upddt).build();
				}else{
					return Response.status(500).build();
				}
			}catch (Exception e) {
				return Response.status(500).build();
			}
	}
	
}