package uy.urudin.frontend.web.rest.endpoints;


import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

//import uy.pencas.organization.logic.interfaces.RegistrooldFacadeLocal;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.datatypes.DTCliente;
import uy.urudin.datatypes.datatypes.DTRegistro;
import uy.urudin.datatypes.datatypes.DTScooter;
import uy.urudin.logic.interfaces.ClienteFacadeLocal;
import uy.urudin.logic.interfaces.RegistroFacadeLocal;
import uy.urudin.logic.interfaces.ScooterFacadeLocal; 

@Path("/registro")
public class restRegistro {

	@EJB
	private RegistroFacadeLocal RegistroEJB;
	@EJB
	private ScooterFacadeLocal ScooterEJB;
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
	public Response GetAllRegistro(){
		List<DTRegistro> ListRegistros = RegistroEJB.findAll();
		return Response.ok( ListRegistros ).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneRegistro(@PathParam("id") Integer id){
		return Response.ok( RegistroEJB.find(id)  ).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRegistro(
//			@QueryParam("id") int id, 
			@QueryParam("idcliente") int idcliente,
			@QueryParam("idscooter") int idscooter
			){
		
		DTCliente cliente = ClienteEJB.find(idcliente);
		DTScooter scooter = ScooterEJB.find(idscooter);
		
		
		DTRegistro dtRegistro = new DTRegistro();
//		dtRegistro.setId(id); //el id no se envia al crear.
		dtRegistro.setCliente(cliente);
		dtRegistro.setScooter(scooter);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dtRegistro.setFecha(timestamp);
		
		try {
			RegistroEJB.add(dtRegistro);
			return Response.status(201).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRegistro(			
			@QueryParam("id") int id, 
			@QueryParam("idcliente") int idcliente,
			@QueryParam("idscooter") int idscooter
			){
		DTCliente cliente = ClienteEJB.find(idcliente);
		DTScooter scooter = ScooterEJB.find(idscooter);
		
		DTRegistro dtRegistro = RegistroEJB.find(id);
		dtRegistro.setCliente(cliente);
		dtRegistro.setScooter(scooter);
		
		try {
			RegistroEJB.update(dtRegistro);
			return Response.status(200).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	//setea encendido en false, no elimina fisicamente.
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRegistro(@PathParam("id") int id){
		DTRegistro dtRegistro = RegistroEJB.find(id);
		try {
			RegistroEJB.delete(dtRegistro);
			return Response.status(204).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
}