package uy.urudin.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Authorization;
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
public class PaypalFacade implements PaypalFacadeRemote, PaypalFacadeLocal{
	
	public String clientId = "AbagFj4cbf_6SvPeQtSj3xopqlfAy9IMNZFzYWMLdXPYIF8pgqD3eaSfhr2OQctMfMZZTmEkCP4IrsvV";
	public String clientSecret = "ENFohCj_ltQ18yoplSv887gwTa_3dC21bCKLxpsJ8iFrHCUnMGvC-f4oqRXBbkL0CIXEjeRxkHb1sThX";
	public String executionMode = "sandbox";
	
	public String test() {
		
		//Payer y su payment method
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		
		//URL Set
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://example.com/cancel");
		redirectUrls.setReturnUrl("https://example.com/return");
		
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("1.00");

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);	
		
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		
		payment.setRedirectUrls(redirectUrls);
		
		APIContext context = new APIContext(clientId, clientSecret, executionMode);
		try {
			 
			Payment myPayment = payment.create(context);
			
			// Identifier of the payment resource created 		
			payment.setId( myPayment.getId() );
						 
			PaymentExecution execution = new PaymentExecution();
 
			// Set your PayerID. The ID of the Payer, passed in the `return_url` by PayPal.
			execution.setPayerId("<!---- Add your PayerID here ---->");
 
			// This call will fail as user has to access Payment on UI. Programmatically
			// there is no way you can get Payer's consent.
			Payment createdAuthPayment = payment.execute(context, execution);
 
			// Transactional details including the amount and item details.
			Authorization crunchifyAuthorization = createdAuthPayment.getTransactions().get(0).getRelatedResources().get(0).getAuthorization();
 
			return ("Here is your Authorization ID" + crunchifyAuthorization.getId());
 
		} catch (PayPalRESTException e) {
			return "PaypalRESTException";
		} catch (Exception ex) {
		    return "Exception";
		}
		
	}
}



