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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTCliente;
import uy.urudin.logic.interfaces.ClienteFacadeLocal;


@Path("/cliente")
public class ClienteEndpoint {

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
		try {
			DTCliente nuevo = ClienteEJB.find(email);
			if(nuevo != null) {
				return Response.status(200).entity( nuevo ).build();
			}else {
				return Response.status(500).entity( nuevo ).build();
			}
		} catch (Exception e) {
			return Response.status(500).entity( e ).build();
		}		
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCliente(DTCliente dtcliente){
				try {
					DTCliente nuevo = ClienteEJB.add(dtcliente);
					if(nuevo != null) {
						return Response.status(200).entity( nuevo ).build();
					}else {
						return Response.status(500).entity( nuevo ).build();
					}
				} catch (Exception e) {
					return Response.status(500).entity( e ).build();
				}	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCliente(DTCliente dtcliente){
				try {
					DTCliente nuevo = ClienteEJB.update(dtcliente);
					if(nuevo != null) {
						return Response.status(200).entity( nuevo ).build();
					}else {
						return Response.status(500).entity( nuevo ).build();
					}
				} catch (Exception e) {
					return Response.status(500).entity( e ).build();
				}	
	}
	
}