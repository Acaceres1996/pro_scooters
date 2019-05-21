package uy.urudin.api.rest.endpoints;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.datatypes.DTScooter;
import uy.urudin.logic.interfaces.AdminFacadeLocal;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;

/** https://api.urudin.tk/admin/
 * 
 * @Author Agustin Caceres 
 */
@Path("/admin")
public class AdminEndpoint {
	
	@EJB
	private AdminFacadeLocal AdminEJB;
	
	/** POST - https://api.urudin.tk/admin/login - FALTA CONECTAR A BASE
	 * @param DTAdmin
	 * @return DTAdmin */
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Login(DTAdmin admin) {	

		try {
			if(AdminEJB.login(admin)) {
				return Response.status(200).entity( admin ).build();
			}else {
				return Response.status(403).build();
			}
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	/** POST - https://api.urudin.tk/admin/login - FALTA CONECTAR A BASE
	 * @param DTAdmin
	 * @return DTAdmin */
	@POST
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearAdmin(DTAdmin admin) {	
		try {
			DTAdmin newadmin=AdminEJB.add(admin);
			//solo si es true respondo.
			if(newadmin != null) {
				return Response.status(200).entity( newadmin ).build();
			}else {
				return Response.status(500).build();
			}
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	//setea encendido en false, no elimina fisicamente.
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAdmin(@PathParam("id") int id){
		try {
			AdminEJB.delete(id);
			return Response.status(204).build();
		}catch (Exception e) {
			return Response.status(500).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAllAdmin(){
		List<DTAdmin> ListAdmin = AdminEJB.findAll();
		return Response.ok( ListAdmin ).build();
	}
	
	
}