package uy.urudin.api.rest.endpoints;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uy.urudin.logic.interfaces.PaypalFacadeLocal;

@Path("/paypal")
public class PaypalEndpoint {
	
	@EJB
	private PaypalFacadeLocal PaypalEJB;
	
	@GET
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "true";
	}
	
	@POST
	@Path("/start")
	@Produces(MediaType.TEXT_HTML)
	public String StartPayment() {
		return PaypalEJB.startPayment();
	}
	
	@POST
	@Path("/finish")
	@Produces(MediaType.TEXT_HTML)
	public String FinishPayment() {
		return PaypalEJB.finishPayment("","");
	}
	
}