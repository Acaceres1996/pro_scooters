package uy.urudin.api.rest.endpoints;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterScan;
import uy.urudin.datatypes.DTScooterUltimoRegistro;
import uy.urudin.logic.interfaces.ScooterFacadeLocal; 

/** https://api.urudin.tk/scooter/
 * 
 * @Author Agustin Caceres 
 */
@Path("/scooter")
public class ScooterEndpoint {

	@EJB
	private ScooterFacadeLocal ScooterEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	@GET
	@Path("/infoscan/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetScooterScan(@PathParam("id") Integer id){
		DTScooterScan Scooter = ScooterEJB.findScooterScan(id);
		return Response.ok( Scooter ).build();
	}
	
	/** GET - https://api.urudin.tk/scooter/
	 * @return List(DTScooter) */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllScooter(){
		List<DTScooter> ListScooters = ScooterEJB.findAll();
		return Response.ok( ListScooters ).build();
	}
	
	/** GET - https://api.urudin.tk/scooter/
	 * @return List(DTScooter) */
	@GET
	@Path("/ultimosregistros")
	@Produces(MediaType.APPLICATION_JSON)
	public Response scootersUltimosRegistros(){
		List<DTScooterUltimoRegistro> ListScooters = ScooterEJB.scootersUltimosRegistros();
		return Response.ok( ListScooters ).build();
	}
	
	/** GET - https://api.urudin.tk/scooter/
	 * @return List(DTScooter) 
	 * @throws IOException 
	 * @throws UnsupportedEncodingException */
	@GET
	@Path("/alquilados")
	@Produces(MediaType.APPLICATION_JSON)
	public Response scootersAlquilados() throws UnsupportedEncodingException, IOException{
		//List<DTScooterUltimoRegistro> ListScooters = ScooterEJB.scootersAlquilados();
		return Response.ok( ScooterEJB.scootersAlquilados() ).build();
	}
	
	
	
	/** POST - https://api.urudin.tk/scooter/
	 * @param DTScooter
	 * @return List<DTScooter> */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createScooter(DTScooter s){
		try {			
			DTScooter nuevo = ScooterEJB.add(s);
			if(nuevo != null) {
				return Response.status(200).entity( nuevo ).build();
			}else {
				return Response.status(500,"Entidad vacia").build();
			}
		}catch (Exception e) {
			return Response.status(500).entity(e).build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneScooter(@PathParam("id") Integer id){
		return Response.ok( ScooterEJB.find(id)  ).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateScooter(DTScooter s){
		try {
			DTScooter upd = ScooterEJB.update(s);
			if(upd != null) {
				return Response.status(200).entity( upd ).build();
			}else {
				return Response.status(500,"Entidad vacia").build();
			}
		}catch (Exception e) {
			return Response.status(500).entity(e).build();
		}
	}
	
	
	//setea encendido en false, no elimina fisicamente.
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteScooter(@PathParam("id") int id){
		try {
			ScooterEJB.delete(id);
			return Response.status(204).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
}