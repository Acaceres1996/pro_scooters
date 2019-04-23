package uy.urudin.frontend.web.rest.endpoints;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import uy.urudin.logic.interfaces.PaypalFacadeLocal;

@Path("/paypal")
public class PaypalEndpoint {
	
	@EJB
	private PaypalFacadeLocal PaypalEJB;
	
	
	@POST
	@Path("/startpayment")
	@Produces(MediaType.TEXT_HTML)
	public String StartPayment() {
		return PaypalEJB.startPayment();
	}
	
	@POST
	@Path("/finishpayment")
	@Produces(MediaType.TEXT_HTML)
	public String FinishPayment() {
		return PaypalEJB.finishPayment("","");
	}
	
	/****/
	/*
	 Prueba de invocación a otro REST
	*/
	@GET
	@Path("/test_endpoint")
	@Produces(MediaType.TEXT_HTML)
	public String hop() {				
		
		Client client = ClientBuilder.newClient();	
		WebTarget target = client.target("http://localhost:8080/frontend-web-rest/api/paypal/second_test_endpoint");
		String response = target.request(MediaType.TEXT_HTML).get(String.class);
		return response;
	}
	
	@GET
	@Path("/second_test_endpoint")
	@Produces(MediaType.TEXT_HTML)
	public String tst() {			
		return "vengo de otro endpoint";
	}
	/****/		
}