package uy.urudin.logic.interfaces;

import javax.ejb.Local;


@Local
public interface PaypalFacadeLocal {
	String startPayment();
	String finishPayment(String PaymentID, String PayerID);
}