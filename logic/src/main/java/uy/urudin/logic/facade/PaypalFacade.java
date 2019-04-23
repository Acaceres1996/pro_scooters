package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.paypal.api.payments.Amount;
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

@Stateless
@LocalBean
public class PaypalFacade implements PaypalFacadeRemote, PaypalFacadeLocal {

	public String cancelUrl = "https://example.com/cancel";
	public String returnUrl = "https://example.com/return";
	public String clientId = "AbagFj4cbf_6SvPeQtSj3xopqlfAy9IMNZFzYWMLdXPYIF8pgqD3eaSfhr2OQctMfMZZTmEkCP4IrsvV";
	public String clientSecret = "ENFohCj_ltQ18yoplSv887gwTa_3dC21bCKLxpsJ8iFrHCUnMGvC-f4oqRXBbkL0CIXEjeRxkHb1sThX";
	public String executionMode = "sandbox";

	public String startPayment() {

		/* Configuro el payment, lo genero y obtengo la URL de aprobacion */
		
		Payment payment = this.getPaymentObject();
		APIContext context = new APIContext(clientId, clientSecret, executionMode);
		try {
			String url = "";
			Payment createdPayment = payment.create(context);

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
	
	public String finishPayment(String paymentId, String PayerID) {
		APIContext context = new APIContext(clientId, clientSecret, executionMode);
		Payment payment = new Payment();
		payment.setId( paymentId );
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(PayerID);
		try {
		  Payment createdPayment = payment.execute(context, paymentExecution);
		  System.out.println(createdPayment);
		} catch (PayPalRESTException e) {
			return "PaypalRESTException";
		}catch (Exception ex) {
			return "Exception";
		}
		return "";
	}

	private Payment getPaymentObject() {

		// Payer y su payment method
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		// URL Set
		RedirectUrls redirectUrls = new RedirectUrls();

		redirectUrls.setCancelUrl(cancelUrl);
		redirectUrls.setReturnUrl(returnUrl);
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("1.00");

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("Transaccion de prueba");

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
