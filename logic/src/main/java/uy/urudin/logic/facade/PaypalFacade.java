package uy.urudin.logic.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import uy.urudin.logic.interfaces.PaypalFacadeLocal;
import uy.urudin.logic.interfaces.PaypalFacadeRemote;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;

@Stateless
@LocalBean
public class PaypalFacade implements PaypalFacadeRemote, PaypalFacadeLocal {

	public String executionMode = "sandbox";

	private static final Logger LOGGER = Logger.getLogger("PaypalFacade");
	
	@EJB
	ParametroDAOLocal parameters;
	  	
	public String startPayment() {
		String clientId = parameters.getValueByName("paypal_client_id");
		String clientSecret = parameters.getValueByName("paypal_client_secret");		
		/**/
		Payment payment = this.getPaymentObject();
		APIContext context = new APIContext(clientId, clientSecret, executionMode);
		try {
			String url = "";
			Payment createdPayment = payment.create(context);
			LOGGER.info("Start - Pago creado - id = "+ createdPayment.getId() + " - estado = " + createdPayment.getState());
			
			
			Iterator<Links> links = createdPayment.getLinks().iterator();
			while (links.hasNext()) {
				Links link = links.next();
				if (link.getRel().equalsIgnoreCase("approval_url")) {
					url = link.getHref();
				}
			}
			return url;
		} catch (PayPalRESTException e) {
			return "PaypalRESTException";
		} catch (Exception ex) {
			return "Exception";
		}
	}

	public Payment finishPayment(String paymentId, String PayerID) {
		String state = "";
		String clientId = parameters.getValueByName("paypal_client_id");
		String clientSecret = parameters.getValueByName("paypal_client_secret");
		APIContext context = new APIContext(clientId, clientSecret, executionMode);
		Payment payment = new Payment();
		try {
			payment = Payment.get(context, paymentId);
			state = payment.getState();
			LOGGER.info("Finish - Pago cargado - id = "+ payment.getId() + " - estado = " + payment.getState());
		} catch (PayPalRESTException e1) {
			e1.printStackTrace();			
		}		
		if(state.equals("created")) {
			try {
				payment.setId(paymentId);
				PaymentExecution paymentExecution = new PaymentExecution();
				paymentExecution.setPayerId(PayerID);
				System.out.println("before execute");
				Payment createdPayment = payment.execute(context, paymentExecution);
				System.out.println("after execute");
				return createdPayment;
			} catch (PayPalRESTException e) {
				System.out.println("after execute 2");
				e.printStackTrace();
				return payment;
			}catch (Exception ex) {			
				System.out.println("after execute 3");
				ex.printStackTrace();
				return null;
			}
		}else {
			return payment;
		}
		
	}

	private Payment getPaymentObject() {
		// Payer y su payment method
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		
		// URL Set
		String cancelUrl = parameters.getValueByName("paypal_cancel_url");
		String returnUrl = parameters.getValueByName("paypal_return_url");
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(cancelUrl);
		redirectUrls.setReturnUrl(returnUrl);
		
		
		//Detallse del pago
		Details details = new Details();
		details.setShipping("1");
		details.setSubtotal("5");
		details.setTax("1");
					
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("7");
		amount.setDetails(details);
		
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("Transaccion de prueba");
		Item item = new Item();
		item.setName("Scooter").setQuantity("1").setCurrency("USD").setPrice("5");
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		itemList.setItems(items);
		transaction.setItemList(itemList);
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		payment.setRedirectUrls(redirectUrls);
		return payment;
	}
	
	
}
