package uy.urudin.api.rest.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.urudin.datatypes.DTAdmin;

/** Endpoint: https://api.urudin.tk/admin/
 * 
 * @Author Agustin Caceres 
 */
@Path("/admin")
public class AdminEndpoint {
	
	/** POST - https://api.urudin.tk/admin/login - FALTA CONECTAR A BASE
	 * @param DTAdmin
	 * @return DTAdmin */
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Login(DTAdmin admin) {	
		return Response.status(200).entity( admin ).build();
	}		
}