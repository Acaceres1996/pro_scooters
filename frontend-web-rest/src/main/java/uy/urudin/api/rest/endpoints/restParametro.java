package uy.urudin.api.rest.endpoints;


import javax.ws.rs.Produces;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTParametro;
import uy.urudin.logic.interfaces.ParametroFacadeLocal;

//import uy.pencas.organization.logic.interfaces.ParameteroldFacadeLocal;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType; 

@Path("/parametro")
public class restParametro {

	@EJB
	private ParametroFacadeLocal ParametroEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllParameter(){
		List<DTParametro> ListParameters = ParametroEJB.findAll();
		return Response.ok( ListParameters ).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneParameter(@PathParam("id") Integer id){
		return Response.ok( ParametroEJB.find(id)  ).build();
	}
	
	@GET
	@Path("/getvaluebyname/")
	@Produces(MediaType.TEXT_HTML)
	public Response getValueByName(@QueryParam("name") String name){
		return Response.ok( ParametroEJB.getValueByName(name)  ).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createParameter(DTParametro dtParameter){
		try {
			return Response.status(200).entity(ParametroEJB.add(dtParameter)).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateParameter(DTParametro dtParameter){
		try {
			return Response.status(200).entity(ParametroEJB.update(dtParameter)).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteParameter(@PathParam("id") Integer id){
		try {
			DTParametro dtParameter = ParametroEJB.find(id);
			ParametroEJB.delete(dtParameter);
			return Response.status(204).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
}