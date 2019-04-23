package uy.urudin.frontend.web.rest.endpoints;


import javax.ws.rs.Produces;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.datatypes.DTParametro;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response createParameter(@QueryParam("nombre") String nombre, @QueryParam("valor") String valor){
		DTParametro dtParameter = new DTParametro();
		dtParameter.setNombre(nombre);
		dtParameter.setValor(valor);
		ParametroEJB.add(dtParameter);
		return Response.status(201).build();
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateParameter(@QueryParam("id") Integer id,@QueryParam("nombre") String nombre, @QueryParam("valor") String valor){
		DTParametro dtParameter = new DTParametro();
		dtParameter.setId(id);
		dtParameter.setNombre(nombre);
		dtParameter.setValor(valor);
		ParametroEJB.update(dtParameter);
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteParameter(@PathParam("id") Integer id){
		DTParametro dtParameter = ParametroEJB.find(id);
		ParametroEJB.delete(dtParameter);
		return Response.status(204).build();
	}

	
	
}