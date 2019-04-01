package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTPaymentRequest;

@Remote
public interface PaymentRequestFacadeRemote {
	void add(DTPaymentRequest dtPaymentRequest);
	void update(DTPaymentRequest dtPaymentRequest);
	void delete(DTPaymentRequest dtPaymentRequest);
	DTPaymentRequest find(Integer id);
	List<DTPaymentRequest> findAll();
}
