package uy.urudin.logic.interfaces;

import javax.ejb.Remote;

import com.paypal.api.payments.Payment;

@Remote
public interface PaypalFacadeRemote {
	String startPayment();
	Payment finishPayment(String PaymentID, String PayerID);
}