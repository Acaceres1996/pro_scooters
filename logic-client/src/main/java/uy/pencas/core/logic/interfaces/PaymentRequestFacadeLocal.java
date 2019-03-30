package uy.pencas.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTPaymentRequest;

@Local
public interface PaymentRequestFacadeLocal {
	void add(DTPaymentRequest dtPaymentRequest);
	void update(DTPaymentRequest dtPaymentRequest);
	void delete(DTPaymentRequest dtPaymentRequest);
	DTPaymentRequest find(Integer id);
	List<DTPaymentRequest> findAll();
}
