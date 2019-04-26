package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
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
import uy.urudin.persistance.interfaces.ParametroDAOLocal;

@Stateless
@LocalBean
public class PaypalFacade implements PaypalFacadeRemote, PaypalFacadeLocal {

	public String executionMode = "sandbox";

	@EJB
	ParametroDAOLocal parameters;

	public String startPayment() {
		String clientId = parameters.getValueByName("paypal_client_id");
		String clientSecret = parameters.getValueByName("paypal_client_secret");
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

	public Payment finishPayment(String paymentId, String PayerID) {
		String clientId = parameters.getValueByName("paypal_client_id");
		String clientSecret = parameters.getValueByName("paypal_client_secret");
		APIContext context = new APIContext(clientId, clientSecret, executionMode);
		Payment payment = new Payment();
		payment.setId(paymentId);
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(PayerID);

		if (payment.getState().equals("approved")) {
			return payment;
		} else {
			try {
				Payment createdPayment = payment.execute(context, paymentExecution);
				return createdPayment;
			} catch (PayPalRESTException e) {
				return payment;
			} catch (Exception ex) {
				return null;
			}
		}

	}

	private Payment getPaymentObject() {

		// Payer y su payment method
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		// URL Set
		RedirectUrls redirectUrls = new RedirectUrls();

		String cancelUrl = parameters.getValueByName("paypal_cancel_url");
		String returnUrl = parameters.getValueByName("paypal_return_url");
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
