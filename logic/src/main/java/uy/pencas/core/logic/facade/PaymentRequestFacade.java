package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTPaymentRequest;
import uy.pencas.core.logic.interfaces.PaymentRequestFacadeLocal;
import uy.pencas.core.logic.interfaces.PaymentRequestFacadeRemote;

import uy.pencas.core.persistance.interfaces.PaymentRequestDAOLocal;

/**
 * Session Bean implementation class PaymentRequestFacade
 */
@Stateless
@LocalBean
public class PaymentRequestFacade implements PaymentRequestFacadeRemote, PaymentRequestFacadeLocal {

	@EJB
	PaymentRequestDAOLocal paymentRequestDAO;
	
    /**
     * Default constructor. 
     */
    public PaymentRequestFacade() {
        
    }

	@Override
	public void add(DTPaymentRequest dtPaymentRequest) {
		paymentRequestDAO.add(dtPaymentRequest);
	}

	@Override
	public void update(DTPaymentRequest dtPaymentRequest) {
		paymentRequestDAO.merge(dtPaymentRequest);
	}

	@Override
	public void delete(DTPaymentRequest dtPaymentRequest) {
		paymentRequestDAO.delete(dtPaymentRequest);
	}

	@Override
	public DTPaymentRequest find(Integer id) {
		return paymentRequestDAO.find(id);
	}

	@Override
	public List<DTPaymentRequest> findAll() {
		return paymentRequestDAO.findAll();
	}
	

}
