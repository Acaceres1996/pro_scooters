package uy.urudin.logic.interfaces;

import javax.ejb.Local;

import com.paypal.api.payments.Payment;


@Local
public interface PaypalFacadeLocal {
	String startPayment();
	Payment finishPayment(String PaymentID, String PayerID);
}