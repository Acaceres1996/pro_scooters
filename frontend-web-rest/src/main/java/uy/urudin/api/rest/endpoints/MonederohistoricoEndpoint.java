
package uy.urudin.api.rest.endpoints;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
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
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import uy.urudin.datatypes.DTRegistro;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTMonederohistorico;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;
import uy.urudin.logic.interfaces.MonederohistoricoFacadeLocal; 

/** https://api.urudin.tk/scooter/
 * 
 * @Author Martin Olivera 
 */
@Path("/monederohistorico")
public class MonederohistoricoEndpoint {

	@EJB
	private MonederohistoricoFacadeLocal MonederohistoricoEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registroMonederohistorico(DTMonederohistorico dtMonederohistorico){
		try {
			return Response.status(200).entity( MonederohistoricoEJB.add(dtMonederohistorico) ).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") Integer id){
		return Response.ok( MonederohistoricoEJB.find(id)  ).build();
	}
	
	@GET
	@Path("/usuariopagos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pagosUsuario(@PathParam("id") Integer id){
		return Response.ok( MonederohistoricoEJB.findPagosUsuario(id)  ).build();
	}
	
	@GET
	@Path("/pagos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response todoslosPagos(){
		return Response.ok( MonederohistoricoEJB.findPagos()  ).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll(){
		return Response.ok( MonederohistoricoEJB.findAll()  ).build();
	}

}