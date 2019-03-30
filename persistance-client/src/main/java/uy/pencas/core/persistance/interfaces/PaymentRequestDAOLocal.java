package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTPaymentRequest;



@Local
public interface PaymentRequestDAOLocal {
	void add(DTPaymentRequest dtPaymentRequest);
	void merge(DTPaymentRequest dtPaymentRequest);
	void delete(DTPaymentRequest dtPaymentRequest);
	DTPaymentRequest find(Integer id);
	List<DTPaymentRequest> findAll();
	
}
