package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import uy.urudin.logic.interfaces.PaypalFacadeLocal;
import uy.urudin.logic.interfaces.PaypalFacadeRemote;

@Stateless
@LocalBean
public class PaypalFacade implements PaypalFacadeRemote, PaypalFacadeLocal{
	
	public String clientId = "AbagFj4cbf_6SvPeQtSj3xopqlfAy9IMNZFzYWMLdXPYIF8pgqD3eaSfhr2OQctMfMZZTmEkCP4IrsvV";
	public String clientSecret = "ENFohCj_ltQ18yoplSv887gwTa_3dC21bCKLxpsJ8iFrHCUnMGvC-f4oqRXBbkL0CIXEjeRxkHb1sThX";
	
	public String test() {
		
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("1.00");

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://example.com/cancel");
		redirectUrls.setReturnUrl("https://example.com/return");
		payment.setRedirectUrls(redirectUrls);
		
		try {
		    APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");
		    Payment createdPayment = payment.create(apiContext);
		    return createdPayment.toString();
		} catch (PayPalRESTException e) {
			return "PaypalRESTException";
		} catch (Exception ex) {
		    return "Exception";
		}
		
	}
}



