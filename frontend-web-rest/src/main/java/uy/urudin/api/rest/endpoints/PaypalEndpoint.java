package uy.urudin.api.rest.endpoints;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.paypal.api.payments.Payment;

import uy.urudin.datatypes.Pair;
import uy.urudin.logic.interfaces.PaypalFacadeLocal;

@Path("/paypal")
public class PaypalEndpoint {
	
	@EJB
	private PaypalFacadeLocal PaypalEJB;
		
	@GET
	@OPTIONS
	@Path("/ping")
	@Produces(MediaType.TEXT_HTML)
	public String ping() {
		return "Status - OK";
	}
	
	@GET
	@Path("/start")
	@Produces(MediaType.APPLICATION_JSON)
	public Response StartPayment() {
		Pair p = new Pair("url", PaypalEJB.startPayment() );			
		return Response.status(200).entity(p).build();
	}

	@POST
	@Path("/finish")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response FinishPayment(List<Pair> plist) {		
		String paymentId = "",BuyerID = "";		
		Pair p = new Pair("paypal_state", "");
		for (Pair pair : plist) {
			if( pair.getKey().equals("paymentid") ) {
				paymentId = pair.getValue();
			}else if( pair.getKey().equals("buyerid") ) {
				BuyerID = pair.getValue();
			}
		}
		if( paymentId.isEmpty() || BuyerID.isEmpty()) {
			p.setValue( "vacio" );
			return Response.status(200).entity( p ).build();
		}else {
			Payment payment = PaypalEJB.finishPayment(paymentId,BuyerID);
			p.setValue( payment.getState() );
			return Response.status(200).entity( p ).build();
		}		
	}
}